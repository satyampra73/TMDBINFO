package com.satyam.tmdbinfo.presentation.artist

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.satyam.tmdbinfo.R
import com.satyam.tmdbinfo.databinding.ActivityArtistBinding

class ArtistActivity : AppCompatActivity() {
    lateinit var binding: ActivityArtistBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_artist)

    }
}