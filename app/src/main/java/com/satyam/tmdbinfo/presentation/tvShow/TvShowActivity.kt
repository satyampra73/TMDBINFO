package com.satyam.tmdbinfo.presentation.tvShow

import android.os.Bundle
import android.widget.RelativeLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.satyam.tmdbinfo.R
import com.satyam.tmdbinfo.databinding.ActivityTvShowBinding

class TvShowActivity : AppCompatActivity() {
    lateinit var binding: ActivityTvShowBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_show)

    }
}