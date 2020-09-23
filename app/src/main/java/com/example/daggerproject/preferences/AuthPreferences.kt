package com.example.daggerproject.preferences

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.example.daggerproject.App
import me.ebraheem.restaurants.common.Constants
import javax.inject.Inject

class AuthPreferences @Inject constructor(var app: App) : AuthSharedPreferences {

    private val prefs: Lazy<SharedPreferences> = lazy {
        app.getSharedPreferences(
            Constants.AUTH_PREFERENCES_FILE_NAME, Context.MODE_PRIVATE
        )
    }

    companion object {
        const val ACCESS_TOKEN: String = "access_token"
        const val REFRESH_TOKEN: String = "refresh_token"
    }

    override fun getAccessToken(): String? {
        return prefs.value.getString(ACCESS_TOKEN, null)
    }

    override fun putAccessToken(string: String) {
        prefs.value.edit {
            putString(ACCESS_TOKEN, string)
        }
    }

    override fun getRefreshToken(): String? {
        return prefs.value.getString(REFRESH_TOKEN, null)
    }

    override fun putRefreshToken(string: String) {
        prefs.value.edit {
            putString(REFRESH_TOKEN, string)
        }
    }

}