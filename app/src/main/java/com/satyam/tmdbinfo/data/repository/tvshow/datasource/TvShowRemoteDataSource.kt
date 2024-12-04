package com.satyam.tmdbinfo.data.repository.tvshow.datasource

import com.satyam.tmdbinfo.data.model.tvshowlist.TvShowList
import retrofit2.Response


interface TvShowRemoteDataSource {
    suspend fun getTvShow(): Response<TvShowList>
}