package edu.temple.basicbrowser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var urlEditText: EditText
    private lateinit var goButton: ImageButton
    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        urlEditText = findViewById(R.id.urlEditText)
        goButton = findViewById(R.id.goButton)
        webView = findViewById(R.id.webView)

        // Allow your browser to intercept hyperlink clicks
        webView.webViewClient = object: WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
            }
        }

        goButton.setOnClickListener{
            var website = urlEditText.text.toString()
            if (!website.startsWith("http://")) {
                Toast.makeText(this, "Always enter web URLs with their protocol, e.g. 'https'", Toast.LENGTH_LONG).show()
                website = "https://" + website
            }
            webView.loadUrl(website)
        }
    }
}