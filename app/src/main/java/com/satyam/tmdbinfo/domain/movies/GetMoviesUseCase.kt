package com.satyam.tmdbinfo.domain.movies

import com.satyam.tmdbinfo.model.movielist.Movie

class GetMoviesUseCase(private val moviesRepository: MovieRepository) {
    suspend fun execute(): List<Movie>? = moviesRepository.getMovies()
}