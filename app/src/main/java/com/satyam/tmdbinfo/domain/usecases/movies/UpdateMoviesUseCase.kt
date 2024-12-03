package com.satyam.tmdbinfo.domain.usecases.movies

import com.satyam.tmdbinfo.domain.repository.MovieRepository
import com.satyam.tmdbinfo.model.movielist.Movie

class UpdateMoviesUseCase(private val moviesRepository: MovieRepository) {
    suspend fun execute(): List<Movie>? = moviesRepository.updateMovies()
}