package com.anywhere.billing

import android.content.Context
import com.anywhere.androidcommons.enum.AppMode
import com.anywhere.androidcommons.plugin.Component
import com.anywhere.androidcommons.plugin.Sync
import com.anywhere.androidcommons.plugin.Token
import com.anywhere.androidcommons.socket.jdo.Message

/**
 * Created by vignesh on 30/September/2021
 */
class BillingSdk(private val context: Context, private val token: Token,
                 override var needRealtimeSync: Boolean,
                 override var requiredEvents: HashSet<String>?
) : Component {

    override var isForegroundSync: Boolean = false

    override var isInitialized: Boolean = false

    override var isSyncCompleted: Boolean = false

    override var isSyncRequired: Boolean = true

    override suspend fun clearSession() {

    }

    override fun initializeSDK() {
        isInitialized = true

    }

    override fun isRegistered(): Boolean {
        return false
    }

    override fun onAppStarted() {
    }

    override fun onAppStopped() {
    }

    override fun onMessageReceived(message: Message?) {

    }

    override suspend fun registerSDK(
        mode: AppMode,
        brand: String,
        accountId: String,
        userId: String,
        timeZone: String?
    ) {
        BillingPreference.initPreferences(context)
        BillingPreference.brand = brand
        BillingPreference.accountId = accountId
        BillingPreference.accessToken = token.getAccessToken()
        println("$brand $accountId")
    }

    override fun startBackgroundSync() {
    }

    override suspend fun startForegroundSync() {
    }

    override fun startSync(callback: Sync.Callback) {
    }


}