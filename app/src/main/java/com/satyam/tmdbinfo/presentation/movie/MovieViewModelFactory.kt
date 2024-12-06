package com.satyam.tmdbinfo.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.satyam.tmdbinfo.domain.usecases.movies.GetMoviesUseCase
import com.satyam.tmdbinfo.domain.usecases.movies.UpdateMoviesUseCase
import com.satyam.tmdbinfo.presentation.tvShow.TVShowViewModel

class MovieViewModelFactory(
    private val getMoviesUseCase : GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
):
ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieViewModel(
            getMoviesUseCase,
            updateMoviesUseCase
        ) as T
    }

}