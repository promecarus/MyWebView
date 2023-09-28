package com.promecarus.mywebview

import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<WebView>(R.id.webView).apply {
            loadUrl("https://www.dicoding.com")
            settings.javaScriptEnabled = true
            webViewClient = object : WebViewClient() {
                override fun onPageFinished(view: WebView, url: String) {
                    view.loadUrl("javascript:alert('Web Dicoding berhasil dimuat')")
                }
            }
            webChromeClient = object : WebChromeClient() {
                override fun onJsAlert(
                    view: WebView,
                    url: String,
                    message: String,
                    result: android.webkit.JsResult
                ): Boolean {
                    Toast.makeText(this@MainActivity, message, Toast.LENGTH_LONG).show()
                    result.confirm()
                    return true
                }
            }
        }
    }
}
