package com.satyam.tmdbinfo.domain.tvshows

import com.satyam.tmdbinfo.model.tvshowlist.TvShow

class UpdateTVShowUseCase(private val tvShowRepository: TVShowsRepository) {
    suspend fun execute(): List<TvShow>? = tvShowRepository.getTvShows()
}