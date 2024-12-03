package com.satyam.tmdbinfo.data.repository.movie.datasourceImpl

import com.satyam.tmdbinfo.data.model.movielist.Movie
import com.satyam.tmdbinfo.data.repository.movie.datasource.MoviesCacheDataSource

class MovieCacheDataSourceImpl : MoviesCacheDataSource {
    private var movieList = ArrayList<Movie>()
    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}