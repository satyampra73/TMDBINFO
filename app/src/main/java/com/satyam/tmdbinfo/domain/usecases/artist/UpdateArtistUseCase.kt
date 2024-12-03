package com.satyam.tmdbinfo.domain.usecases.artist

import com.satyam.tmdbinfo.domain.repository.ArtistRepository
import com.satyam.tmdbinfo.data.model.artist.Artist

class UpdateArtistUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute(): List<Artist>? = artistRepository.updateArtist()
}