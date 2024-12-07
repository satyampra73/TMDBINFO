package com.satyam.tmdbinfo.presentation.di.core

import com.satyam.tmdbinfo.domain.repository.ArtistRepository
import com.satyam.tmdbinfo.domain.repository.MovieRepository
import com.satyam.tmdbinfo.domain.repository.TVShowsRepository
import com.satyam.tmdbinfo.domain.usecases.artist.GetArtistUseCase
import com.satyam.tmdbinfo.domain.usecases.artist.UpdateArtistUseCase
import com.satyam.tmdbinfo.domain.usecases.movies.GetMoviesUseCase
import com.satyam.tmdbinfo.domain.usecases.movies.UpdateMoviesUseCase
import com.satyam.tmdbinfo.domain.usecases.tvshows.GetTvShowUseCase
import com.satyam.tmdbinfo.domain.usecases.tvshows.UpdateTVShowUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    //Movies
    @Provides
    fun provideGetMovieUseCase(movieRepository : MovieRepository) : GetMoviesUseCase{
        return GetMoviesUseCase(movieRepository)
    }
    @Provides
    fun provideUpdateMovieUseCase(movieRepository : MovieRepository) : UpdateMoviesUseCase {
        return UpdateMoviesUseCase(movieRepository)
    }

    //tvShow
    @Provides
    fun provideGetTvShowUseCase(tvShowsRepository : TVShowsRepository) : GetTvShowUseCase{
        return GetTvShowUseCase(tvShowsRepository)
    }

    @Provides
    fun provideUpdateTvShowUseCase(tvShowRepository : TVShowsRepository) : UpdateTVShowUseCase {
        return UpdateTVShowUseCase(tvShowRepository)
    }

    //Artist

    @Provides
    fun provideGetArtistUseCase(artistRepository : ArtistRepository) : GetArtistUseCase{
        return GetArtistUseCase(artistRepository)
    }

    @Provides
    fun provideUpdateArtistUseCase(artistRepository : ArtistRepository) : UpdateArtistUseCase {
        return UpdateArtistUseCase(artistRepository)
    }

}