package com.satyam.tmdbinfo.domain.artist

import com.satyam.tmdbinfo.model.artist.Artist

class UpdateArtistUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute(): List<Artist>? = artistRepository.updateArtist()
}