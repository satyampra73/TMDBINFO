package com.satyam.tmdbinfo.presentation.di.movie

import com.satyam.tmdbinfo.domain.usecases.artist.GetArtistUseCase
import com.satyam.tmdbinfo.domain.usecases.artist.UpdateArtistUseCase
import com.satyam.tmdbinfo.domain.usecases.movies.GetMoviesUseCase
import com.satyam.tmdbinfo.domain.usecases.movies.UpdateMoviesUseCase
import com.satyam.tmdbinfo.presentation.artist.ArtistViewModelFactory
import com.satyam.tmdbinfo.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ):MovieViewModelFactory{
        return MovieViewModelFactory(
            getMoviesUseCase,
            updateMoviesUseCase
        )
    }
}