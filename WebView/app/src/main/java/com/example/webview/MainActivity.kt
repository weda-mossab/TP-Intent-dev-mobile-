package com.example.webview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

lateinit var webv:WebView
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        webv = findViewById(R.id.webview)
        webv.webViewClient = WebViewClient()
        webv.loadUrl("http://www.isetb.rnu.tn")
    }

}