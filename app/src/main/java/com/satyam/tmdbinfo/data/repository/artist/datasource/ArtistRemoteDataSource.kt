package com.satyam.tmdbinfo.data.repository.artist.datasource

import com.satyam.tmdbinfo.data.model.artist.ArtistList
import retrofit2.Response


interface ArtistRemoteDataSource {
    suspend fun getArtist(): Response<ArtistList>
}