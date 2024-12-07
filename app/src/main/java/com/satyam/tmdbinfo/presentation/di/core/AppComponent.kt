package com.satyam.tmdbinfo.presentation.di.core

import com.satyam.tmdbinfo.presentation.di.artist.ArtistSubComponent
import com.satyam.tmdbinfo.presentation.di.movie.MovieSubComponent
import com.satyam.tmdbinfo.presentation.di.tvShow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetModule::class,
        DataBaseModule::class,
        UseCaseModule::class,
        RepositoryModule::class,
        RemoteDatamodule::class,
        LocalDataModule::class,
        CacheDataModule::class
    ]
)
interface AppComponent {
    fun movieSubComponent():MovieSubComponent.Factory
    fun tvShowSubComponent(): TvShowSubComponent.Factory
    fun artistSubComponent():ArtistSubComponent.Factory
}