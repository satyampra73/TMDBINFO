package com.satyam.tmdbinfo.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.satyam.tmdbinfo.data.model.movielist.Movie
import com.satyam.tmdbinfo.data.model.tvshowlist.TvShow

@Dao
interface TvShowDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTVShows(movies: List<TvShow>)

    @Query(value = "DELETE FROM popular_tvShows")
    suspend fun deleteAllTvShows()

    @Query(value = "SELECT * FROM popular_tvShows")
    suspend fun getTVShows(): List<TvShow>

}
