package com.satyam.tmdbinfo.presentation

import android.app.Application
import com.satyam.tmdbinfo.BuildConfig
import com.satyam.tmdbinfo.presentation.di.Injector
import com.satyam.tmdbinfo.presentation.di.artist.ArtistSubComponent
import com.satyam.tmdbinfo.presentation.di.core.AppComponent
import com.satyam.tmdbinfo.presentation.di.core.AppModule
import com.satyam.tmdbinfo.presentation.di.core.DaggerAppComponent
import com.satyam.tmdbinfo.presentation.di.core.NetModule
import com.satyam.tmdbinfo.presentation.di.core.RemoteDatamodule
import com.satyam.tmdbinfo.presentation.di.movie.MovieSubComponent
import com.satyam.tmdbinfo.presentation.di.tvShow.TvShowSubComponent

class App : Application(),Injector {

    private lateinit var appComponent:AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL,"eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiZjRjYzUwOWEzNTlmM2E4MTczNmEzMTY1NmFlNWI1NyIsIm5iZiI6MTczMjcyNjI1MS42NjQsInN1YiI6IjY3NDc0ZGViZDdhMjA1NzE1YjYxNzcyNSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.lfJyEWec2iHpmluIJeXyhxzNMpo45xGZ5RIoxbhWIbc"))
            .remoteDatamodule(RemoteDatamodule())
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }

}