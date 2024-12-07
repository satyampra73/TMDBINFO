package com.satyam.tmdbinfo.presentation.di.movie

import com.satyam.tmdbinfo.presentation.artist.ArtistActivity
import com.satyam.tmdbinfo.presentation.di.artist.ArtistScope
import com.satyam.tmdbinfo.presentation.movie.MovieActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {

    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): MovieSubComponent
    }

}