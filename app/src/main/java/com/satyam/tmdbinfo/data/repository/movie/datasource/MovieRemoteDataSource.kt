package com.satyam.tmdbinfo.data.repository.movie.datasource

import com.satyam.tmdbinfo.data.model.movielist.MovieList
import retrofit2.Response


interface MovieRemoteDataSource {
    suspend fun getMovies(): Response<MovieList>
}