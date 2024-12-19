package com.satyam.tmdbinfo.presentation.di.core

import com.satyam.tmdbinfo.data.api.TMDBService
import com.satyam.tmdbinfo.data.repository.artist.datasource.ArtistRemoteDataSource
import com.satyam.tmdbinfo.data.repository.artist.datasourceimpl.ArtistRemoteDataSourceImpl
import com.satyam.tmdbinfo.data.repository.movie.datasource.MovieRemoteDataSource
import com.satyam.tmdbinfo.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import com.satyam.tmdbinfo.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.satyam.tmdbinfo.data.repository.tvshow.datasourceimpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDatamodule() {
    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService):MovieRemoteDataSource{
        return MovieRemoteDataSourceImpl(tmdbService)
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImpl(tmdbService)
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(tmdbService)
    }

}