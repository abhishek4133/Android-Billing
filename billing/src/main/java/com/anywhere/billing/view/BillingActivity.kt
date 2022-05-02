package com.anywhere.billing.view

import android.app.Activity
import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.webkit.CookieManager
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import com.anywhere.billing.R
import com.anywhere.billing.utils.Constants
import kotlinx.android.synthetic.main.billing_layout.*

class BillingActivity : Activity() {

    lateinit var loader : ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.billing_layout)
        loader = findViewById(R.id.webviewLoader)

        loadView.webViewClient = RedirectWebClient()
        loadView.settings.javaScriptEnabled = true

        CookieManager.getInstance().flush()
        CookieManager.getInstance().removeSessionCookies(null)
        CookieManager.getInstance().removeAllCookies(null)

        val extraHeaders: MutableMap<String, String?> = HashMap()
//        extraHeaders["Authorization"] = "Bearer "+BillingPreference.accessToken
        extraHeaders["Authorization"] = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6IjY4MGZjMTNkZWEwMjhhODJkM2I4NjcxZDJlN2NhZjMyZTM0NmU3ZjkifQ.eyJpc3MiOiJodHRwczovL2Z1bGxjcmVhdGl2ZS5mdWxsYXV0aC5jb20iLCJpYXQiOjE2NTE0NzM4ODIsInByb2pfaWQiOiJzZXRtb3JlIiwidHlwZSI6InVzZXIiLCJzdWIiOiJkN2RkMmI3NTVjNjEwZWJkMGU5OTlmM2NlNjYwMWU4ZjNhMjg2NmQ1IiwiZXhwIjoxNjUyMDc4NjgyLCJqdGkiOiJjNTUyYTlnb1ExY1dDY0hVIn0.bsuxTcGC61R2RY4di4MpYiMi384__DiVbtX0ig60V4EqBg-cDkuEOmh1NzAUVXbF6bbeVqDu4XmK8pdDgdVJi4txoUcwnO5UDvnk3NE1oJfCfw67VUnZ3Y-pT8byfRSBRO_RrPr_3D_yt5W-4tqzqFjFrDp20a5vOFIS6iKY02hBSdyicox5aDb9CFlWI9Np-hzuftboIQvggRANMoAXeIl8DZKOJ_cPYCGZjAFr4KAfwxu6-rABBbqhRNyP-tQ9uOZAVPCq_n8BKzfOsT2IsgXl6SW2TjBNXjXI6Wue7r7bJeakTk858KbqJ2BqDVSUpbP9HyP-G_Uz_1ZY3wjz5Q"

        loadView.loadUrl(Constants.BASE_URL, extraHeaders)

        close.setOnClickListener{
            finish()
        }
    }


    inner class RedirectWebClient : WebViewClient(){
        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            super.onPageStarted(view, url, favicon)
            println(url)
            loader.visibility = View.GONE
//            url.let { }
        }
    }

}