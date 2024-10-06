package com.example.artbookk.repo

import androidx.lifecycle.LiveData
import com.atilsamancioglu.artbookhilttesting.model.ImageResponse
import com.example.artbookk.roomdb.Art
import com.example.artbookk.util.Resource

interface ArtRepositoryInterface {

    suspend fun  insertArt(art: Art)

    suspend fun deleteArt(art: Art)

    fun getArt(): LiveData<List<Art>>

    suspend fun searchImage(imageString: String): Resource<ImageResponse>

}