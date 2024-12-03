package com.satyam.tmdbinfo.domain.tvshows

import com.satyam.tmdbinfo.model.tvshowlist.TvShow

interface TVShowsRepository {
    suspend fun getTvShows(): List<TvShow>?
    suspend fun updateMovies(): List<TvShow>?
}