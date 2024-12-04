package com.satyam.tmdbinfo.data.repository.artist.datasource

import com.satyam.tmdbinfo.data.model.artist.Artist
import com.satyam.tmdbinfo.data.model.movielist.Movie

interface ArtistCacheDataSource {
    suspend fun getArtistFromCache(): List<Artist>
    suspend fun saveArtistToCache(artist: List<Artist>)
}