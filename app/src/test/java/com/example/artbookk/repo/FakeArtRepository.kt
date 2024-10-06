package com.example.artbookk.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.atilsamancioglu.artbookhilttesting.model.ImageResponse
import com.example.artbookk.roomdb.Art
import com.example.artbookk.util.Resource

class FakeArtRepository:ArtRepositoryInterface {

    private val arts= mutableListOf<Art>()
    private  val artsLiveData= MutableLiveData<List<Art>>(arts)

    override suspend fun insertArt(art: Art) {
        arts.add(art)
        refreshData()
    }

    override suspend fun deleteArt(art: Art) {
        arts.remove(art)
        refreshData()
    }

    override fun getArt(): LiveData<List<Art>> {
        return artsLiveData
    }

    override suspend fun searchImage(imageString: String): Resource<ImageResponse> {
        return Resource.success(ImageResponse(listOf(),0,0))
    }

    private fun refreshData(){
        artsLiveData.postValue(arts)
    }
}
