package com.satyam.tmdbinfo.presentation.tvShow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.satyam.tmdbinfo.domain.usecases.tvshows.GetTvShowUseCase
import com.satyam.tmdbinfo.domain.usecases.tvshows.UpdateTVShowUseCase

class TVShowViewModel(
    private val getTvShowUseCase: GetTvShowUseCase,
    private val updateTVShowUseCase: UpdateTVShowUseCase
) : ViewModel() {

    fun getTvShow() = liveData {
        val tvShowList = getTvShowUseCase.execute()
        emit(tvShowList)
    }

    fun updateTvShow() = liveData {
        val tvShowList = updateTVShowUseCase.execute()
        emit(tvShowList)
    }
}