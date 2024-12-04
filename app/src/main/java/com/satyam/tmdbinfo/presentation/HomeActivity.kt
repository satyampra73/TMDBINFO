package com.satyam.tmdbinfo.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.satyam.tmdbinfo.R
import com.satyam.tmdbinfo.databinding.ActivityHomeBinding
import com.satyam.tmdbinfo.presentation.artist.ArtistActivity
import com.satyam.tmdbinfo.presentation.movie.MovieActivity
import com.satyam.tmdbinfo.presentation.tvShow.TvShowActivity

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        binding.btnMovies.setOnClickListener {
            val intent = Intent(this, MovieActivity::class.java)
            startActivity(intent)
        }

        binding.btnTvShow.setOnClickListener {
            val intent = Intent(this, TvShowActivity::class.java)
            startActivity(intent)
        }

        binding.btnArtist.setOnClickListener{
            val intent = Intent(this, ArtistActivity::class.java)
            startActivity(intent)
        }

    }
}