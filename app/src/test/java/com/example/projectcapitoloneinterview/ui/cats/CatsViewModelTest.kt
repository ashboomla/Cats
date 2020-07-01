package com.example.projectcapitoloneinterview.ui.cats

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.example.projectcapitoloneinterview.data.Breed
import com.example.projectcapitoloneinterview.data.CatData
import org.junit.Assert
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)

class CatsViewModelTest {
    @get:Rule
    var instantRule = InstantTaskExecutorRule()

    @Mock
    lateinit var repository: CatsRepository

    @Before
    fun setUp() {

    }

    @Test
    fun getImages() {
        val catImagesRet: MutableLiveData<List<CatData>> = MutableLiveData()
        Mockito.`when`(repository.getImages()).thenReturn(catImagesRet)
        val viewModel = CatsViewModel(repository)
        val temp = viewModel.getImages()
        //verification
        Mockito.verify(repository).getImages()
        Assert.assertEquals(true, temp == catImagesRet)
    }

    @Test
    fun getBreeds() {
        val catBreedRet: MutableLiveData<List<Breed>> = MutableLiveData()
        Mockito.`when`(repository.getBreeds()).thenReturn(catBreedRet)
        val viewModel = CatsViewModel(repository)

        val temp = viewModel.getBreeds()
        Mockito.verify(repository).getBreeds()
        Assert.assertEquals(true, temp == catBreedRet)

    }
}