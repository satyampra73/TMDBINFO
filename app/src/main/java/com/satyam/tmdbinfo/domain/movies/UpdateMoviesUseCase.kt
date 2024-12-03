package com.satyam.tmdbinfo.domain.movies

import com.satyam.tmdbinfo.model.movielist.Movie

class UpdateMoviesUseCase(private val moviesRepository: MovieRepository) {
    suspend fun execute(): List<Movie>? = moviesRepository.updateMovies()
}