package com.satyam.tmdbinfo.data.repository.artist

import android.util.Log
import com.satyam.tmdbinfo.data.model.artist.Artist
import com.satyam.tmdbinfo.data.model.artist.ArtistList
import com.satyam.tmdbinfo.data.model.movielist.Movie
import com.satyam.tmdbinfo.data.model.movielist.MovieList
import com.satyam.tmdbinfo.data.repository.artist.datasource.ArtistCacheDataSource
import com.satyam.tmdbinfo.data.repository.artist.datasource.ArtistLocalDataSource
import com.satyam.tmdbinfo.data.repository.artist.datasource.ArtistRemoteDataSource
import com.satyam.tmdbinfo.data.repository.movie.datasource.MovieLocalDataSource
import com.satyam.tmdbinfo.data.repository.movie.datasource.MovieRemoteDataSource
import com.satyam.tmdbinfo.data.repository.movie.datasource.MoviesCacheDataSource
import com.satyam.tmdbinfo.domain.repository.ArtistRepository
import com.satyam.tmdbinfo.domain.repository.MovieRepository
import retrofit2.Response

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource,
) : ArtistRepository {
    override suspend fun getArtist(): List<Artist>? {
        return getArtistFromCache()
    }

    override suspend fun updateArtist(): List<Artist>? {
        val newListOfMovies = getArtistFromApi()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistToDB(newListOfMovies)
        artistCacheDataSource.saveArtistToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getArtistFromApi():List<Artist>{
         lateinit var artistList:List<Artist>
        try {
            val response:Response<ArtistList> = artistRemoteDataSource.getArtist()
            val body = response.body()
            if (body!=null){
                artistList = body.artists
            }
        }
        catch (exception: Exception){
            Log.d("MyTag",exception.message.toString())
        }
        return artistList
    }

    suspend fun getArtistFromDB():List<Artist>{
        lateinit var artistList:List<Artist>
        try {
           artistList = artistLocalDataSource.getArtistFromDB()
        }
        catch (exception: Exception){
            Log.d("MyTag",exception.message.toString())
        }

        if (artistList.size>0){
            return artistList
        }
        else{
            artistList = getArtistFromApi()
            artistLocalDataSource.saveArtistToDB(artistList)
        }
        return artistList
    }

    suspend fun getArtistFromCache():List<Artist>{
        lateinit var artistList:List<Artist>
        try {
            artistList = artistCacheDataSource.getArtistFromCache()
        }
        catch (exception: Exception){
            Log.d("MyTag",exception.message.toString())
        }

        if (artistList.size>0){
            return artistList
        }
        else{
            artistList = getArtistFromDB()
            artistCacheDataSource.saveArtistToCache(artistList)
        }
        return artistList
    }

}