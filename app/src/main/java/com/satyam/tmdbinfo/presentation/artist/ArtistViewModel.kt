package com.satyam.tmdbinfo.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.satyam.tmdbinfo.domain.usecases.artist.GetArtistUseCase
import com.satyam.tmdbinfo.domain.usecases.artist.UpdateArtistUseCase
import com.satyam.tmdbinfo.domain.usecases.tvshows.GetTvShowUseCase
import com.satyam.tmdbinfo.domain.usecases.tvshows.UpdateTVShowUseCase

class ArtistViewModel(
    private val getArtistUseCase: GetArtistUseCase,
    private val updateArtistUseCase: UpdateArtistUseCase
):
ViewModel(){

    fun getArtist() = liveData {
        val tvShowList = getArtistUseCase.execute()
        emit(tvShowList)
    }

    fun updateArtist() = liveData {
        val tvShowList = updateArtistUseCase.execute()
        emit(tvShowList)
    }

}