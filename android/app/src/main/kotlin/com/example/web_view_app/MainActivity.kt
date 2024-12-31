package com.example.web_view_app

import android.content.Context
import android.webkit.WebView
import android.webkit.WebViewClient
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.platform.PlatformView
import io.flutter.plugin.platform.PlatformViewFactory
import io.flutter.plugin.platform.PlatformViewRegistry

class MainActivity : FlutterActivity() {
    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)

        val registry: PlatformViewRegistry = flutterEngine.platformViewsController.registry
        registry.registerViewFactory("native-webview", WebViewFactory(this))
    }

    private class WebViewFactory(private val context: Context) : PlatformViewFactory(null) {
        override fun create(context: Context, viewId: Int, args: Any?): PlatformView {
            return NativeWebView(context)
        }
    }

    private class NativeWebView(context: Context) : PlatformView {
        private val webView: WebView = WebView(context).apply {
            settings.javaScriptEnabled = true
            loadUrl("https://bongobangla.com/")
            webViewClient = WebViewClient()
        }

        override fun getView(): WebView = webView

        override fun dispose() {
            webView.destroy()
        }
    }
}
