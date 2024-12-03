package com.satyam.tmdbinfo.domain.repository

import com.satyam.tmdbinfo.data.model.tvshowlist.TvShow

interface TVShowsRepository {
    suspend fun getTvShows(): List<TvShow>?
    suspend fun updateMovies(): List<TvShow>?
}