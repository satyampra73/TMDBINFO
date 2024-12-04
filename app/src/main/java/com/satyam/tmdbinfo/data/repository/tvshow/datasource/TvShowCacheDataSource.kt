package com.satyam.tmdbinfo.data.repository.tvshow.datasource

import com.satyam.tmdbinfo.data.model.artist.Artist
import com.satyam.tmdbinfo.data.model.tvshowlist.TvShow

interface TvShowCacheDataSource {
    suspend fun getTvShowFromCache(): List<TvShow>
    suspend fun saveTvShowToCache(artist: List<TvShow>)
}