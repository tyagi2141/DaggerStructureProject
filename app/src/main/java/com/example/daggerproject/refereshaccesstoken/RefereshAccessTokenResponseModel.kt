package com.example.daggerproject.refereshaccesstoken


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RefereshAccessTokenResponseModel(
    @SerializedName("ResponseData")
    var responseData: ResponseData?,
    @SerializedName("ResponseStatus")
    var responseStatus: Int?, // 200
    @SerializedName("success")
    var success: Boolean? // true
) : Parcelable