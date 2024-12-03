package com.satyam.tmdbinfo.domain.repository

import com.satyam.tmdbinfo.model.movielist.Movie

interface MovieRepository {
    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?
}