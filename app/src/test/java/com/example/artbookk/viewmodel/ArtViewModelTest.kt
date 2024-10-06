package com.example.artbookk.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.artbookk.MainCoroutineRule
import com.example.artbookk.getOrAwaitValueTest
import com.example.artbookk.repo.FakeArtRepository
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class ArtViewModelTest {

    @get:Rule
    var instantTaskExecutorRule=InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule=MainCoroutineRule()
    private lateinit var viewModel: com.example.artbookk.view.ArtViewModel

    @Before
    fun setup() {
        viewModel = com.example.artbookk.view.ArtViewModel(FakeArtRepository())
    }

    @Test
    fun `insert art without year returns error`() {
        viewModel.makeArt("Mona Lisa", "davinci", "")
        val value = viewModel.insertArtMessage.getOrAwaitValueTest()
        assertThat(value.status).isEqualTo(com.example.artbookk.util.Status.ERROR)

    }

    @Test
    fun `insert art without name returns error`() {
        viewModel.makeArt("", "davinci", "121")
        val value = viewModel.insertArtMessage.getOrAwaitValueTest()
        assertThat(value.status).isEqualTo(com.example.artbookk.util.Status.ERROR)
    }

    @Test
    fun `insert art without artistName returns error`() {
        viewModel.makeArt("Mona Lisa", "", "2112")
        val value = viewModel.insertArtMessage.getOrAwaitValueTest()
        assertThat(value.status).isEqualTo(com.example.artbookk.util.Status.ERROR)
    }

}