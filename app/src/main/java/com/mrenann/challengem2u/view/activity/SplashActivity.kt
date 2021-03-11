package com.mrenann.challengem2u.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.mrenann.challengem2u.R
import com.mrenann.challengem2u.utils.Constants

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MovieDetailedActivity::class.java)
            intent.putExtra(Constants.ConstantsFilms.BASE_MOVIE_KEY, 372058)
            startActivity(intent)
            finish()
        }, 1000)
    }
}