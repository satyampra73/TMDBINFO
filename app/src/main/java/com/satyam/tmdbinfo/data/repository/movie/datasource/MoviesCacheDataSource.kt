package com.satyam.tmdbinfo.data.repository.movie.datasource

import com.satyam.tmdbinfo.data.model.movielist.Movie

interface MoviesCacheDataSource {
    suspend fun getMoviesFromCache(): List<Movie>
    suspend fun saveMoviesToCache(movies: List<Movie>)
}