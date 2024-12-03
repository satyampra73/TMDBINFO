package com.satyam.tmdbinfo.data.repository.movie

import com.satyam.tmdbinfo.data.model.movielist.Movie

interface MovieLocalDataSource {
    suspend fun getMoviesFromDB(): List<Movie>
    suspend fun saveMoviesToDB(movies: List<Movie>)
    suspend fun clearAll()
}