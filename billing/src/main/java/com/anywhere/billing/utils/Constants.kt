package com.anywhere.billing.utils

import com.anywhere.billing.BillingPreference

internal object Constants {
    var BASE_URL = "https://settings-dot-live-cwa.appspot.com/mobilebilling?uniquePin="+BillingPreference.accountId+"&brandId="+BillingPreference.brand
}