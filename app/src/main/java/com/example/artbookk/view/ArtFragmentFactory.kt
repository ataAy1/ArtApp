package com.example.artbookk.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.example.artbookk.adapter.ArtRecylerAdapter
import com.example.artbookk.adapter.ImageRecyclerAdapter
import javax.inject.Inject

class ArtFragmentFactory @Inject constructor(
    private val artRecylerAdapter: ArtRecylerAdapter,
    private  val glide: RequestManager,
    private val imageRecyclerAdapter: ImageRecyclerAdapter
):FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when(className){
            ImageApiFragment::class.java.name -> ImageApiFragment(imageRecyclerAdapter)
            ArtDetailsFragment::class.java.name -> ArtDetailsFragment(glide)
            ArtFragment::class.java.name -> ArtFragment(artRecylerAdapter)
            else -> super.instantiate(classLoader, className)
        }
    }
}