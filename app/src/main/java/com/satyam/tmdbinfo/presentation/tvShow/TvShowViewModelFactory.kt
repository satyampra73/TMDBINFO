package com.satyam.tmdbinfo.presentation.tvShow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.satyam.tmdbinfo.domain.usecases.tvshows.GetTvShowUseCase
import com.satyam.tmdbinfo.domain.usecases.tvshows.UpdateTVShowUseCase

class TvShowViewModelFactory (
    private val getTvShowUseCase: GetTvShowUseCase,
    private val updateTvShowUseCase : UpdateTVShowUseCase
):ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TVShowViewModel(
            getTvShowUseCase,
            updateTvShowUseCase
        ) as T
    }

}