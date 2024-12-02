package com.satyam.tmdbinfo.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.satyam.tmdbinfo.model.artist.Artist
import com.satyam.tmdbinfo.model.movielist.Movie
import com.satyam.tmdbinfo.model.tvshowlist.TvShow

@Database(
    entities = [Movie::class, TvShow::class, Artist::class],
    version = 1,
    exportSchema = false
)
abstract class TMDBDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun tvDao(): TvShowDao
    abstract fun artistDao(): ArtistDao
}