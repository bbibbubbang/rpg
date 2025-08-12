package com.example.webgame

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

/**
 * Simple activity that hosts a WebView loading a local HTML game.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val webView = WebView(this)
        setContentView(webView)

        // Enable JavaScript for interactive content
        webView.settings.javaScriptEnabled = true
        // Ensure links open within the WebView
        webView.webViewClient = WebViewClient()
        // Load the HTML game from the assets folder
        webView.loadUrl("file:///android_asset/index.html")
    }
}
