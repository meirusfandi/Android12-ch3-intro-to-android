package id.my.fanslab.myprofileapps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.my.fanslab.myprofileapps.databinding.ActivityMainBinding
import id.my.fanslab.myprofileapps.Constants.GITHUB
import id.my.fanslab.myprofileapps.Constants.INSTAGRAM
import id.my.fanslab.myprofileapps.Constants.LINKEDIN
import id.my.fanslab.myprofileapps.SocialMediaActivity.Companion.URL_STRING

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.profileImage.setImageResource(R.drawable.profile_images)

        binding.github.setOnClickListener{ movePage(GITHUB) }
        binding.instagram.setOnClickListener{ movePage(INSTAGRAM) }
        binding.linkedin.setOnClickListener{ movePage(LINKEDIN) }
    }

    private fun movePage(tipe: String) {
        val intent = Intent(this@MainActivity, SocialMediaActivity::class.java)
        val url: String = when(tipe) {
            GITHUB -> "https://github.com/meirusfandi"
            LINKEDIN -> "https://www.linkedin.com/in/meirusfandi/"
            INSTAGRAM -> "https://instagram.com/meirusfandi"
            else -> "https://meirusfandi.com"
        }
        intent.putExtra(URL_STRING, url)
        startActivity(intent)
    }

}