package com.satyam.tmdbinfo.presentation.di

import com.satyam.tmdbinfo.presentation.di.artist.ArtistSubComponent
import com.satyam.tmdbinfo.presentation.di.movie.MovieSubComponent
import com.satyam.tmdbinfo.presentation.di.tvShow.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
    fun createTvShowSubComponent():TvShowSubComponent
    fun createArtistSubComponent():ArtistSubComponent
}