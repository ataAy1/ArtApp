package com.example.artbookk.repo

import androidx.lifecycle.LiveData
import com.atilsamancioglu.artbookhilttesting.model.ImageResponse
import com.example.artbookk.api.RetrofitAPI
import com.example.artbookk.roomdb.Art
import com.example.artbookk.roomdb.ArtDao
import com.example.artbookk.util.Resource
import java.lang.Exception
import javax.inject.Inject

class ArtRepository @Inject constructor(
    private val artDao: ArtDao,
    private val retrofitAPI: RetrofitAPI
) : ArtRepositoryInterface {
    override suspend fun insertArt(art: Art) {
        artDao.insertArt(art)
    }

    override suspend fun deleteArt(art: Art) {
        artDao.deleteArt(art)
    }

    override fun getArt(): LiveData<List<Art>> {
        return artDao.observeArts()
    }

    override suspend fun searchImage(imageString: String): Resource<ImageResponse> {
        return try {
            val response = retrofitAPI.imageSearch(imageString)
            if (response.isSuccessful) {
                response.body()?.let {
                    return@let Resource.success(it)
                } ?: Resource.error("Error", null)
            }else{
                Resource.error("Error", null)
            }
        } catch (e: Exception) {
            Resource.error("no data,", null)
        }
    }
}