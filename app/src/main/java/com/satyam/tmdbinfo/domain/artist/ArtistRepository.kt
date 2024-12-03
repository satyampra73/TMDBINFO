package com.satyam.tmdbinfo.domain.artist

import com.satyam.tmdbinfo.model.artist.Artist
import com.satyam.tmdbinfo.model.movielist.Movie

interface ArtistRepository {
    suspend fun getArtist(): List<Artist>?
    suspend fun updateArtist(): List<Artist>?
}