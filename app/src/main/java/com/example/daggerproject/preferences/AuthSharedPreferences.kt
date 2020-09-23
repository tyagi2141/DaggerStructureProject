package com.example.daggerproject.preferences

interface AuthSharedPreferences {

    fun getAccessToken(): String?
    fun putAccessToken(string: String)

    fun getRefreshToken(): String?
    fun putRefreshToken(string: String)


}