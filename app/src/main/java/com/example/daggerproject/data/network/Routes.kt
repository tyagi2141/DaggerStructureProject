package com.example.daggerproject.data.network

import com.example.daggerproject.echomodel.EchoRequestModel
import com.example.daggerproject.echomodel.EchoResponseModel
import com.example.daggerproject.refereshaccesstoken.RefreshAccessTokenRequestModel
import com.example.daggerproject.refereshaccesstoken.RefereshAccessTokenResponseModel
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


const val ENTITY_TYPE_CITY = "city"

interface Routes {


    @POST("/retail/api/v1/user/token/refresh/")
    fun refreshToken(@Body refreshAccessTokenRequestModel: RefreshAccessTokenRequestModel): Call<RefereshAccessTokenResponseModel>


    @POST("echo/")
    fun echo(@Body echoRequestModel: EchoRequestModel): Observable<EchoResponseModel>


}