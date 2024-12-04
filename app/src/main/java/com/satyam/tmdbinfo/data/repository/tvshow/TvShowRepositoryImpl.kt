package com.satyam.tmdbinfo.data.repository.tvshow

import android.util.Log
import com.satyam.tmdbinfo.data.model.artist.Artist
import com.satyam.tmdbinfo.data.model.artist.ArtistList
import com.satyam.tmdbinfo.data.model.tvshowlist.TvShow
import com.satyam.tmdbinfo.data.model.tvshowlist.TvShowList
import com.satyam.tmdbinfo.data.repository.artist.datasource.ArtistCacheDataSource
import com.satyam.tmdbinfo.data.repository.artist.datasource.ArtistLocalDataSource
import com.satyam.tmdbinfo.data.repository.artist.datasource.ArtistRemoteDataSource
import com.satyam.tmdbinfo.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.satyam.tmdbinfo.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.satyam.tmdbinfo.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.satyam.tmdbinfo.domain.repository.ArtistRepository
import com.satyam.tmdbinfo.domain.repository.TVShowsRepository
import retrofit2.Response

class TvShowRepositoryImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource,
) : TVShowsRepository {

    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>{
        val newListOfMovies = getTvShowFromApi()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowToDB(newListOfMovies)
        tvShowCacheDataSource.saveTvShowToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getTvShowFromApi():List<TvShow>{
         lateinit var tvShowList:List<TvShow>
        try {
            val response:Response<TvShowList> = tvShowRemoteDataSource.getTvShow()
            val body = response.body()
            if (body!=null){
                tvShowList = body.tvShows
            }
        }
        catch (exception: Exception){
            Log.d("MyTag",exception.message.toString())
        }
        return tvShowList
    }

    suspend fun getTvShowFromDB():List<TvShow>{
        lateinit var tvShowList:List<TvShow>
        try {
           tvShowList = tvShowLocalDataSource.getTvShowFromDB()
        }
        catch (exception: Exception){
            Log.d("MyTag",exception.message.toString())
        }

        if (tvShowList.size>0){
            return tvShowList
        }
        else{
            tvShowList = getTvShowFromApi()
            tvShowLocalDataSource.saveTvShowToDB(tvShowList)
        }
        return tvShowList
    }

    suspend fun getTvShowFromCache():List<TvShow>{
        lateinit var tvShowList:List<TvShow>
        try {
            tvShowList = tvShowCacheDataSource.getTvShowFromCache()
        }
        catch (exception: Exception){
            Log.d("MyTag",exception.message.toString())
        }

        if (tvShowList.size>0){
            return tvShowList
        }
        else{
            tvShowList = getTvShowFromDB()
            tvShowCacheDataSource.saveTvShowToCache(tvShowList)
        }
        return tvShowList
    }

}