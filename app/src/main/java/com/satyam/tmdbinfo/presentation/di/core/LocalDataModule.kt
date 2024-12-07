package com.satyam.tmdbinfo.presentation.di.core

import com.satyam.tmdbinfo.data.repository.artist.datasource.ArtistLocalDataSource
import com.satyam.tmdbinfo.data.repository.artist.datasourceimpl.ArtistLocalDataSourceImpl
import com.satyam.tmdbinfo.data.repository.movie.datasource.MovieLocalDataSource
import com.satyam.tmdbinfo.data.repository.movie.datasourceImpl.MovieLocalDataSourceImpl
import com.satyam.tmdbinfo.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.satyam.tmdbinfo.data.repository.tvshow.datasourceimpl.TvShowLocalDataSourceImpl
import com.satyam.tmdbinfo.data.room.ArtistDao
import com.satyam.tmdbinfo.data.room.MovieDao
import com.satyam.tmdbinfo.data.room.TvShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Provides
    @Singleton
    fun provideMovieLocalDataSource(movieDao: MovieDao):MovieLocalDataSource{
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Provides
    @Singleton
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao):TvShowLocalDataSource{
        return TvShowLocalDataSourceImpl(tvShowDao)
    }

    @Provides
    @Singleton
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }

}