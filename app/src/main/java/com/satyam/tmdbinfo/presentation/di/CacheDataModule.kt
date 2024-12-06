package com.satyam.tmdbinfo.presentation.di

import com.satyam.tmdbinfo.data.repository.artist.datasource.ArtistCacheDataSource
import com.satyam.tmdbinfo.data.repository.artist.datasourceimpl.ArtistCacheDataSourceImpl
import com.satyam.tmdbinfo.data.repository.movie.datasource.MoviesCacheDataSource
import com.satyam.tmdbinfo.data.repository.movie.datasourceImpl.MovieCacheDataSourceImpl
import com.satyam.tmdbinfo.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.satyam.tmdbinfo.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.satyam.tmdbinfo.data.repository.tvshow.datasourceimpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {
    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MoviesCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }

}