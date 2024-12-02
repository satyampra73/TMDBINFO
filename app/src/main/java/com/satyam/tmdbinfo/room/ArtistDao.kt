package com.satyam.tmdbinfo.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.satyam.tmdbinfo.model.artist.Artist
import com.satyam.tmdbinfo.model.movielist.Movie

@Dao
interface ArtistDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtists(movies: List<Artist>)

    @Query(value = "DELETE FROM popular_artist")
    suspend fun deleteAllArtists()

    @Query(value = "SELECT * FROM popular_artist")
    suspend fun getArtists(): List<Artist>

}
