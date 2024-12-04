package com.satyam.tmdbinfo.data.repository.artist.datasourceimpl

import com.satyam.tmdbinfo.data.api.TMDBService
import com.satyam.tmdbinfo.data.model.artist.Artist
import com.satyam.tmdbinfo.data.model.artist.ArtistList
import com.satyam.tmdbinfo.data.model.movielist.MovieList
import com.satyam.tmdbinfo.data.repository.artist.datasource.ArtistRemoteDataSource
import com.satyam.tmdbinfo.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(private val tmdbService: TMDBService): ArtistRemoteDataSource {

    override suspend fun getArtist(): Response<ArtistList> = tmdbService.getPopularArtist()


}