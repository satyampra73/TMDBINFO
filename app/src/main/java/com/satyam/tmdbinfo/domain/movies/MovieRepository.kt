package com.satyam.tmdbinfo.domain.movies

import com.satyam.tmdbinfo.model.movielist.Movie

interface MovieRepository {
    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?
}