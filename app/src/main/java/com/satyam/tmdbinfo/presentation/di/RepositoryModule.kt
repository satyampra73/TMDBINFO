package com.satyam.tmdbinfo.presentation.di

import com.satyam.tmdbinfo.data.repository.artist.ArtistRepositoryImpl
import com.satyam.tmdbinfo.data.repository.artist.datasource.ArtistCacheDataSource
import com.satyam.tmdbinfo.data.repository.artist.datasource.ArtistLocalDataSource
import com.satyam.tmdbinfo.data.repository.artist.datasource.ArtistRemoteDataSource
import com.satyam.tmdbinfo.data.repository.movie.MovieRepositoryImpl
import com.satyam.tmdbinfo.data.repository.movie.datasource.MovieLocalDataSource
import com.satyam.tmdbinfo.data.repository.movie.datasource.MovieRemoteDataSource
import com.satyam.tmdbinfo.data.repository.movie.datasource.MoviesCacheDataSource
import com.satyam.tmdbinfo.data.repository.tvshow.TvShowRepositoryImpl
import com.satyam.tmdbinfo.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.satyam.tmdbinfo.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.satyam.tmdbinfo.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.satyam.tmdbinfo.domain.repository.ArtistRepository
import com.satyam.tmdbinfo.domain.repository.MovieRepository
import com.satyam.tmdbinfo.domain.repository.TVShowsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        moviesCacheDataSource: MoviesCacheDataSource
    ):MovieRepository{
        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            moviesCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ):TVShowsRepository{
        return TvShowRepositoryImpl(
            tvShowRemoteDataSource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {
        return ArtistRepositoryImpl(
            artistRemoteDataSource,
            artistLocalDataSource,
            artistCacheDataSource
        )
    }

}