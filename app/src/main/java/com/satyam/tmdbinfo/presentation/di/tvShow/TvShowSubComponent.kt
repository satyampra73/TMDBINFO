package com.satyam.tmdbinfo.presentation.di.tvShow

import com.satyam.tmdbinfo.presentation.artist.ArtistActivity
import com.satyam.tmdbinfo.presentation.di.artist.ArtistScope
import com.satyam.tmdbinfo.presentation.di.movie.MovieScope
import com.satyam.tmdbinfo.presentation.movie.MovieActivity
import com.satyam.tmdbinfo.presentation.tvShow.TvShowActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {

    fun inject(tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): TvShowSubComponent
    }

}