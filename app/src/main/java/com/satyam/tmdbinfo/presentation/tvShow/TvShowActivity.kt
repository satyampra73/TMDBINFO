package com.satyam.tmdbinfo.presentation.tvShow

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.satyam.tmdbinfo.R
import com.satyam.tmdbinfo.databinding.ActivityTvShowBinding
import com.satyam.tmdbinfo.presentation.artist.ArtistAdapter
import com.satyam.tmdbinfo.presentation.di.Injector
import javax.inject.Inject

class TvShowActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: TvShowViewModelFactory
    lateinit var tvShowViewModel: TVShowViewModel
    lateinit var adapter: TVShowAdapter
    lateinit var binding: ActivityTvShowBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_show)
        (application as Injector).createTvShowSubComponent()
            .inject(this)
        tvShowViewModel = ViewModelProvider(this, factory)
            .get(TVShowViewModel::class.java)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = TVShowAdapter()
        binding.recyclerView.adapter = adapter
        displayPopularTvShow()

    }

    private fun displayPopularTvShow() {
        binding.progressBar.visibility = View.VISIBLE
        val responseLiveData = tvShowViewModel.getTvShow()
        responseLiveData.observe(this, Observer {
            Log.i("MYTAG", it.toString())
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
            } else {
                Log.e("MYTAG", "Error")
                Toast.makeText(this, "No Data Available", Toast.LENGTH_SHORT).show()
            }
            binding.progressBar.visibility = View.GONE
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_update -> {
                updateTvShow()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    fun updateTvShow() {
        binding.progressBar.visibility = View.VISIBLE
        val response = tvShowViewModel.updateTvShow()
        response.observe(this, Observer {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.progressBar.visibility = View.GONE
            } else {
                binding.progressBar.visibility = View.GONE
            }
        })
    }

}