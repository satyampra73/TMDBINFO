package com.satyam.tmdbinfo.domain.repository

import com.satyam.tmdbinfo.model.artist.Artist

interface ArtistRepository {
    suspend fun getArtist(): List<Artist>?
    suspend fun updateArtist(): List<Artist>?
}