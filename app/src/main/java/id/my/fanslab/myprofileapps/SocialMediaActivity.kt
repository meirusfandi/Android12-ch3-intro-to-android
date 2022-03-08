package id.my.fanslab.myprofileapps

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import id.my.fanslab.myprofileapps.databinding.ActivitySocialMediaBinding

class SocialMediaActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySocialMediaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySocialMediaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var url: String
        intent.getStringExtra(URL_STRING).let {
            url = it.toString()
        }

        setupUI(url)
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setupUI(url: String) = with(binding){
        pageSocialMedia.webViewClient = WebViewClient()
        pageSocialMedia.loadUrl(url)
        val setup = pageSocialMedia.settings
        setup.javaScriptEnabled = true
    }

    companion object {
        const val URL_STRING = "url_string"
    }
}