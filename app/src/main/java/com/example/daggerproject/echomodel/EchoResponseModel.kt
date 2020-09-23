package com.example.daggerproject.echomodel

import kotlinx.android.parcel.Parcelize
import com.google.gson.annotations.SerializedName

import android.os.Parcelable

@Parcelize
data class EchoResponseModel(
    @SerializedName("ResponseData")
    var responseData: ResponseData?,
    @SerializedName("ResponseStatus")
    var responseStatus: Int?, // 201
    @SerializedName("success")
    var success: Boolean? // true
) : Parcelable