package com.example.randomnews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.randomnews.databinding.ActivitySplashBinding
import com.example.randomnews.ui.home.HomeActivity

class SplashActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Handler(Looper.getMainLooper()).postDelayed({

            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }, DELAY_TIME)
    }


    companion object {
        const val DELAY_TIME: Long = 2_000
    }
}