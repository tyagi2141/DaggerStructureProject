package com.example.daggerproject.refereshaccesstoken


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RefreshAccessTokenRequestModel(
    @SerializedName("refresh")
    var refresh: String? // eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0b2tlbl90eXBlIjoicmVmcmVzaCIsImV4cCI6MTU4MzQxNzQ1MiwianRpIjoiOThiZGRhMDVlOTg3NDQwM2FkMjZmMTJkNGYxMTc3NDciLCJ1c2VyX2lkIjoyLCJwaG9uZSI6Ijk5MzA1ODY1MTkiLCJpc19hY3RpdmUiOnRydWUsImVtYWlsIjpudWxsLCJyb2xlIjoiIiwiZm5hbWUiOiIiLCJsbmFtZSI6IiIsImNvdW50cnkiOiJJTkRJQSJ9.vWcM34tUDB7mqAXXjZZxt6dBYs1QiQWi4ySv7C97lBM
) : Parcelable