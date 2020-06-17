package com.example.projectcapitoloneinterview.ui.cats

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.projectcapitoloneinterview.data.Breed
import com.example.projectcapitoloneinterview.data.CatData

class CatsViewModel(private val repository: CatsRepository) : ViewModel() {
    fun getImages(): MutableLiveData<List<CatData>> = repository.getImages()
    fun getBreeds(): MutableLiveData<List<Breed>> = repository.getBreeds()
}