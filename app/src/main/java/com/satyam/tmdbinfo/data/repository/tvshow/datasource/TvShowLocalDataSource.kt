package com.satyam.tmdbinfo.data.repository.tvshow.datasource

import com.satyam.tmdbinfo.data.model.artist.Artist
import com.satyam.tmdbinfo.data.model.tvshowlist.TvShow

interface TvShowLocalDataSource {
    suspend fun getTvShowFromDB(): List<TvShow>
    suspend fun saveTvShowToDB(artist: List<TvShow>)
    suspend fun clearAll()
}