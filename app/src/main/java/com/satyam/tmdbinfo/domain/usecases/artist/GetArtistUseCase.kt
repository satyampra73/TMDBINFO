package com.satyam.tmdbinfo.domain.usecases.artist

import com.satyam.tmdbinfo.domain.repository.ArtistRepository
import com.satyam.tmdbinfo.model.artist.Artist

class GetArtistUseCase (private val artistRepository: ArtistRepository){
 suspend fun execute(): List<Artist>? = artistRepository.getArtist()


}