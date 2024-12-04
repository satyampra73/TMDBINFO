package com.satyam.tmdbinfo.data.repository.artist.datasource

import com.satyam.tmdbinfo.data.model.artist.Artist
import com.satyam.tmdbinfo.data.model.movielist.Movie

interface ArtistLocalDataSource {
    suspend fun getArtistFromDB(): List<Artist>
    suspend fun saveArtistToDB(artist: List<Artist>)
    suspend fun clearAll()
}