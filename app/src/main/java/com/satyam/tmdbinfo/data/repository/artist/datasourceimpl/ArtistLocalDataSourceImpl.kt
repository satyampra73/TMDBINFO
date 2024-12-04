package com.satyam.tmdbinfo.data.repository.artist.datasourceimpl

import com.satyam.tmdbinfo.data.model.artist.Artist
import com.satyam.tmdbinfo.data.model.movielist.Movie
import com.satyam.tmdbinfo.data.repository.artist.datasource.ArtistLocalDataSource
import com.satyam.tmdbinfo.data.repository.movie.datasource.MovieLocalDataSource
import com.satyam.tmdbinfo.data.room.ArtistDao
import com.satyam.tmdbinfo.data.room.MovieDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(private val artistDAO: ArtistDao): ArtistLocalDataSource {
    override suspend fun getArtistFromDB(): List<Artist> {
        return artistDAO.getArtists()
    }

    override suspend fun saveArtistToDB(artist: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDAO.saveArtists(artist)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDAO.deleteAllArtists()
        }
    }
}