package com.satyam.tmdbinfo.presentation.di

import com.satyam.tmdbinfo.data.api.TMDBService
import com.satyam.tmdbinfo.data.repository.artist.datasourceimpl.ArtistRemoteDataSourceImpl
import com.satyam.tmdbinfo.data.repository.movie.datasource.MovieRemoteDataSource
import com.satyam.tmdbinfo.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
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
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService):TvShowRemoteDataSourceImpl{
        return TvShowRemoteDataSourceImpl(tmdbService)
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService):ArtistRemoteDataSourceImpl{
        return ArtistRemoteDataSourceImpl(tmdbService)
    }

}