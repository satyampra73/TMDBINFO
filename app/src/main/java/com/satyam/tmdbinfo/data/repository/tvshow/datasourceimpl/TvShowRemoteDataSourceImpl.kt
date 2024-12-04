package com.satyam.tmdbinfo.data.repository.tvshow.datasourceimpl

import com.satyam.tmdbinfo.data.api.TMDBService
import com.satyam.tmdbinfo.data.model.artist.ArtistList
import com.satyam.tmdbinfo.data.model.tvshowlist.TvShowList
import com.satyam.tmdbinfo.data.repository.artist.datasource.ArtistRemoteDataSource
import com.satyam.tmdbinfo.data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(private val tmdbService: TMDBService): TvShowRemoteDataSource {

    override suspend fun getTvShow(): Response<TvShowList> = tmdbService.getPopularTvShows()


}