package com.satyam.tmdbinfo.presentation.tvShow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.satyam.tmdbinfo.data.model.tvshowlist.TvShow
import com.satyam.tmdbinfo.databinding.ListItemBinding
import com.satyam.tmdbinfo.R
class TVShowAdapter() : RecyclerView.Adapter<TVShowViewHolder>(){
    private val tvShowsList = ArrayList<TvShow>()
    fun setList(tvShows:List<TvShow>){
        tvShowsList.clear()
        tvShowsList.addAll(tvShows)
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TVShowViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = DataBindingUtil.inflate(layoutInflater,R.layout.list_item,parent,false)
        return TVShowViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: TVShowViewHolder,
        position: Int
    ) {
        holder.bind(tvShowsList[position])
    }

    override fun getItemCount(): Int {
        return tvShowsList.size
    }
}
class TVShowViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(tvShow: TvShow){
        binding.txtTitle.text = tvShow.name
        binding.txtDescription.text = tvShow.overview
        val posterUrl = "https://image.tmdb.org/t/p/w500"+tvShow.posterPath
        Glide.with(binding.imgPoster.context)
            .load(posterUrl)
            .into(binding.imgPoster)
    }
}