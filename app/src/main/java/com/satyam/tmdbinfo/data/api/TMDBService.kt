package com.satyam.tmdbinfo.data.api

import com.satyam.tmdbinfo.data.model.artist.ArtistList
import com.satyam.tmdbinfo.data.model.movielist.MovieList
import com.satyam.tmdbinfo.data.model.tvshowlist.TvShowList
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