package com.satyam.tmdbinfo.presentation.di.tvShow

import com.satyam.tmdbinfo.domain.usecases.artist.GetArtistUseCase
import com.satyam.tmdbinfo.domain.usecases.artist.UpdateArtistUseCase
import com.satyam.tmdbinfo.domain.usecases.movies.GetMoviesUseCase
import com.satyam.tmdbinfo.domain.usecases.movies.UpdateMoviesUseCase
import com.satyam.tmdbinfo.domain.usecases.tvshows.GetTvShowUseCase
import com.satyam.tmdbinfo.domain.usecases.tvshows.UpdateTVShowUseCase
import com.satyam.tmdbinfo.presentation.artist.ArtistViewModelFactory
import com.satyam.tmdbinfo.presentation.di.movie.MovieScope
import com.satyam.tmdbinfo.presentation.movie.MovieViewModelFactory
import com.satyam.tmdbinfo.presentation.tvShow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {
    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowUseCase: GetTvShowUseCase,
        updateTVShowUseCase: UpdateTVShowUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(
            getTvShowUseCase,
            updateTVShowUseCase
        )
    }
}