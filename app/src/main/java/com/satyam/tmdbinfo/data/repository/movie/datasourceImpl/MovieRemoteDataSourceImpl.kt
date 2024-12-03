package com.satyam.tmdbinfo.data.repository.movie.datasourceImpl

import com.satyam.tmdbinfo.data.api.TMDBService
import com.satyam.tmdbinfo.data.model.movielist.MovieList
import com.satyam.tmdbinfo.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(private val tmdbService: TMDBService): MovieRemoteDataSource {

    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies()


}