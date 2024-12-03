package com.satyam.tmdbinfo.data.repository.movie

import android.util.Log
import com.satyam.tmdbinfo.data.model.movielist.Movie
import com.satyam.tmdbinfo.data.model.movielist.MovieList
import com.satyam.tmdbinfo.data.repository.movie.datasource.MovieLocalDataSource
import com.satyam.tmdbinfo.data.repository.movie.datasource.MovieRemoteDataSource
import com.satyam.tmdbinfo.data.repository.movie.datasource.MoviesCacheDataSource
import com.satyam.tmdbinfo.domain.repository.MovieRepository
import retrofit2.Response

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MoviesCacheDataSource
) : MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromApi()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getMoviesFromApi():List<Movie>{
         lateinit var movieList:List<Movie>
        try {
            val response:Response<MovieList> = movieRemoteDataSource.getMovies()
            val body = response.body()
            if (body!=null){
                movieList = body.movies
            }
        }
        catch (exception: Exception){
            Log.d("MyTag",exception.message.toString())
        }
        return movieList
    }

    suspend fun getMoviesFromDB():List<Movie>{
        lateinit var movieList:List<Movie>
        try {
           movieList = movieLocalDataSource.getMoviesFromDB()
        }
        catch (exception: Exception){
            Log.d("MyTag",exception.message.toString())
        }

        if (movieList.size>0){
            return movieList
        }
        else{
            movieList = getMoviesFromApi()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }
        return movieList
    }

    suspend fun getMoviesFromCache():List<Movie>{
        lateinit var movieList:List<Movie>
        try {
            movieList = movieCacheDataSource.getMoviesFromCache()
        }
        catch (exception: Exception){
            Log.d("MyTag",exception.message.toString())
        }

        if (movieList.size>0){
            return movieList
        }
        else{
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }
        return movieList
    }

}