package com.example.daggerproject.echomodel


import kotlinx.android.parcel.Parcelize
import com.google.gson.annotations.SerializedName

import android.os.Parcelable

@Parcelize
data class EchoRequestModel(
    @SerializedName("message")
    var message: String?, // asd
    @SerializedName("version")
    var version: String? // 1
) : Parcelable