package com.example.projectcapitoloneinterview.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projectcapitoloneinterview.R
import kotlinx.android.synthetic.main.activity_web_view.*

class WebViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        var url = intent.getStringExtra("WEBKEY")
        val myView = webView
        webView.loadUrl(url)
    }
}
