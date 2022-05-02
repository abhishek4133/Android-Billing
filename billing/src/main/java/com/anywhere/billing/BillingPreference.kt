package com.anywhere.billing

import android.content.Context
import com.anywhere.androidcommons.preference.BaseAppPreferences

/**
 * Created by vignesh on 30/September/2021
 */
object BillingPreference : BaseAppPreferences() {

    override val name: String = "com.anywhere.notification-module"
    val ACCESS_TOKEN = Pair("accessToken", null)

    fun initPreferences(context: Context) {
        preferences = context.getSharedPreferences(name, Context.MODE_PRIVATE)
    }

    var accessToken: String?
        get() = preferences.getString(ACCESS_TOKEN.first, ACCESS_TOKEN.second)
        set(value) = preferences.edit {
            it.putString(ACCESS_TOKEN.first, value)
        }
}