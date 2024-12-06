package com.satyam.tmdbinfo.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.satyam.tmdbinfo.domain.usecases.movies.GetMoviesUseCase
import com.satyam.tmdbinfo.domain.usecases.movies.UpdateMoviesUseCase

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModel() {
    fun getMovies() = liveData {
        val movieList = getMoviesUseCase.execute()
        emit(movieList)
    }

    fun updateMovies() = liveData {
        val movieList = updateMoviesUseCase.execute()
        emit(movieList)
    }
}