package com.satyam.tmdbinfo.domain.usecases.tvshows

import com.satyam.tmdbinfo.domain.repository.TVShowsRepository
import com.satyam.tmdbinfo.data.model.tvshowlist.TvShow

class UpdateTVShowUseCase(private val tvShowRepository: TVShowsRepository) {
    suspend fun execute(): List<TvShow>? = tvShowRepository.getTvShows()
}