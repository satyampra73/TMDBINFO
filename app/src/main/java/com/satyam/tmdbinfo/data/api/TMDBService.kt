package com.satyam.tmdbinfo.api

import com.satyam.tmdbinfo.model.artist.ArtistList
import com.satyam.tmdbinfo.model.movielist.MovieList
import com.satyam.tmdbinfo.model.tvshowlist.TvShowList
import retrofit2.Response
import retrofit2.http.GET

interface TMDBService {
    @GET("movie/popular")
    suspend fun getPopularMovies(): Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTvShows(): Response<TvShowList>

    @GET("person/popular")
    suspend fun getPopularArtist(): Response<ArtistList>
}