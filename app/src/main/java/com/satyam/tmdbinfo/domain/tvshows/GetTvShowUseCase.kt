package com.satyam.tmdbinfo.domain.tvshows

import com.satyam.tmdbinfo.model.tvshowlist.TvShow

class GetTvShowUseCase(private val tvshowRepository: TVShowsRepository) {
    suspend fun execute(): List<TvShow>?=tvshowRepository.getTvShows()
}