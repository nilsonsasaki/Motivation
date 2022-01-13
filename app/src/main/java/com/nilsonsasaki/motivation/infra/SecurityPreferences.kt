package com.nilsonsasaki.motivation.infra

import android.content.Context

class SecurityPreferences(context: Context) {

    private val sharedPreferences = context.getSharedPreferences("motivation", Context.MODE_PRIVATE)

    fun storeString(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    fun getString(key: String): String {
        return sharedPreferences.getString(key,"")?:""
    }

}