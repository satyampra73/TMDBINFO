package com.satyam.tmdbinfo.data.repository.tvshow.datasourceimpl

import com.satyam.tmdbinfo.data.model.artist.Artist
import com.satyam.tmdbinfo.data.model.tvshowlist.TvShow
import com.satyam.tmdbinfo.data.repository.artist.datasource.ArtistCacheDataSource
import com.satyam.tmdbinfo.data.repository.tvshow.datasource.TvShowCacheDataSource

class TvShowCacheDataSourceImpl : TvShowCacheDataSource {
    private var tvShowList = ArrayList<TvShow>()
    override suspend fun getTvShowFromCache(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveTvShowToCache(artist: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(artist)
    }
}