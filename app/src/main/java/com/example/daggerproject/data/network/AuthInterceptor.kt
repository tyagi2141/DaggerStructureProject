package com.example.daggerproject.data.network

import android.util.Log
import com.example.daggerproject.BuildConfig
import com.example.daggerproject.preferences.AuthPreferences
import com.example.daggerproject.refereshaccesstoken.RefreshAccessTokenRequestModel
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class AuthInterceptor constructor(
    private val routes: Routes,
    private val authPreferences: AuthPreferences
) : Interceptor {

    companion object {

        const val TAG = "AuthInterceptor"

        fun getBearerAccessToken(accessToken: String?): String {
            return "Bearer $accessToken"
        }
    }

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {

        //MAKE SYNCHRONIZED
        synchronized(this) {
            val originalRequest = chain.request()

            if (
                (originalRequest.url.encodedPath.contains("/login") && originalRequest.method == "post") ||
                (originalRequest.url.encodedPath.contains("/sign-up") && originalRequest.method == "post")
            ) {
                return chain.proceed(originalRequest)
            }

            val authenticationRequest = originalRequest.newBuilder()
                .addHeader("Authorization", getBearerAccessToken(authPreferences.getAccessToken()))
                .addHeader("appVersion", BuildConfig.VERSION_NAME).build()

            val initialResponse = chain.proceed(authenticationRequest)

            when (initialResponse.code) {
                403, 401 -> {
                    initialResponse.close()
                    //RUN BLOCKING!!
                    val refreshAccessTokenRequestModelResponse = runBlocking {
                        routes.refreshToken(RefreshAccessTokenRequestModel(authPreferences.getRefreshToken()))
                            .execute()
                    }

                    return if (refreshAccessTokenRequestModelResponse.code() != 200) {
                        //AuthManager().authExpiredAndGoLogin(AndroidApplication().getContext())
                        Log.d(TAG, "goto :login page ");
                        //null
                        initialResponse
                    } else {

                        refreshAccessTokenRequestModelResponse.body()?.responseData?.access?.let {
                            authPreferences.putAccessToken(it)

                        }

                        val renewAuthenticationRequest = originalRequest.newBuilder()
                            .addHeader(
                                "Authorization",
                                getBearerAccessToken(authPreferences.getAccessToken())
                            ).build()

                        chain.proceed(renewAuthenticationRequest)

                    }
                }
                else -> return initialResponse
            }
        }
    }
}

