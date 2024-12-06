package com.satyam.tmdbinfo.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.satyam.tmdbinfo.domain.usecases.artist.GetArtistUseCase
import com.satyam.tmdbinfo.domain.usecases.artist.UpdateArtistUseCase
import com.satyam.tmdbinfo.presentation.movie.MovieViewModel

class ArtistViewModelFactory(
    private val getArtistUseCase: GetArtistUseCase,
    private val updateArtistUseCase :UpdateArtistUseCase
) :ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArtistViewModel(
            getArtistUseCase,
            updateArtistUseCase
        ) as T
    }
}