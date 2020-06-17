package com.example.projectcapitoloneinterview.ui.cats

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.projectcapitoloneinterview.app.Config
import com.example.projectcapitoloneinterview.data.Breed
import com.example.projectcapitoloneinterview.network.ApiInterface
import com.example.projectcapitoloneinterview.data.CatData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val TAG = "cats repo"
private const val TAG2 = "c2"


class CatsRepository(private val api: ApiInterface) {
    private val catResponse: MutableLiveData<List<CatData>> = MutableLiveData()
    private val breedResponse: MutableLiveData<List<Breed>> = MutableLiveData()

    fun getImages(): MutableLiveData<List<CatData>> {
        api.getImages(Config.API_KEY, page = 1, limit = 50)
            .enqueue(object : Callback<List<CatData>> {
                override fun onFailure(call: Call<List<CatData>>?, t: Throwable?) {
                    Log.i(TAG, "error is: ${t?.message}")
                }

                override fun onResponse(
                    call: Call<List<CatData>>?,
                    response: Response<List<CatData>>?
                ) {
                    catResponse.value = response?.body()
                    Log.i(TAG, "response is: ${response?.body().toString()}")

                }

            })
        return catResponse
    }

    fun getBreeds() :  MutableLiveData<List<Breed>> {
        api.getCatsBreeds(Config.API_KEY)
            .enqueue(object : Callback<List<Breed>>{
                override fun onFailure(call: Call<List<Breed>>?, t: Throwable?) {
                    Log.i(TAG2, "error is: ${t?.message}")
                }

                override fun onResponse(
                    call: Call<List<Breed>>?,
                    response: Response<List<Breed>>?
                ) {
                    Log.i(TAG2, "response is: ${response?.body().toString()}")
                    breedResponse.value = response?.body()
                }

            })
        return breedResponse
    }
}