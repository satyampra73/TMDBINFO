package com.satyam.tmdbinfo.data.repository.movie

import com.satyam.tmdbinfo.data.model.movielist.Movie

interface MoviesCacheDataSource {
    suspend fun getMoviesFromCache(): List<Movie>
    suspend fun saveMoviesToCache(movies: List<Movie>)
}