package com.satyam.tmdbinfo.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.satyam.tmdbinfo.data.model.movielist.Movie

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies: List<Movie>)

    @Query(value = "DELETE FROM popular_movies")
    suspend fun deleteAllMovies()

    @Query(value = "SELECT * FROM popular_movies")
    suspend fun getMovies(): List<Movie>

}