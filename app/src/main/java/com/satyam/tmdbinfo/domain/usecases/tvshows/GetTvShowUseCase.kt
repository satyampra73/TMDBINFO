package com.satyam.tmdbinfo.domain.usecases.tvshows

import com.satyam.tmdbinfo.domain.repository.TVShowsRepository
import com.satyam.tmdbinfo.data.model.tvshowlist.TvShow

class GetTvShowUseCase(private val tvshowRepository: TVShowsRepository) {
    suspend fun execute(): List<TvShow>?=tvshowRepository.getTvShows()
}