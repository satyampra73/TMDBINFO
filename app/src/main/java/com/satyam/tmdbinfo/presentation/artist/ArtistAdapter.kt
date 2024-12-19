package com.satyam.tmdbinfo.presentation.artist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.satyam.tmdbinfo.R
import com.satyam.tmdbinfo.data.model.artist.Artist
import com.satyam.tmdbinfo.databinding.ListItemBinding

class ArtistAdapter():RecyclerView.Adapter<ArtistViewHolder>(){
    private val artistList = ArrayList<Artist>()
    fun setList(artists:List<Artist>){
        artistList.clear()
        artistList.addAll(artists)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
     val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ListItemBinding = DataBindingUtil.inflate(layoutInflater,
            R.layout.list_item,parent,false)
        return ArtistViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return artistList.size
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        holder.bind(artistList[position])
    }
}
class ArtistViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(artist: Artist){
        binding.txtTitle.text = artist.name
        binding.txtDescription.text = artist.knownForDepartment
        val posterUrl = "https://image.tmdb.org/t/p/w500"+artist.profilePath
        Glide.with(binding.imgPoster.context)
            .load(posterUrl)
            .into(binding.imgPoster)
    }
}