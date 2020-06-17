package com.example.projectcapitoloneinterview.network

import com.example.projectcapitoloneinterview.app.Config
import com.example.projectcapitoloneinterview.data.Breed
import com.example.projectcapitoloneinterview.data.CatData
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("images/search")
    fun getImages(@Query("x-api-key") apiKey: String, @Query("page") page: Int, @Query("limit") limit: Int): Call<List<CatData>>

    @GET("breeds")
    fun getCatsBreeds(@Query("x-api-key") apiKey: String): Call<List<Breed>>

    companion object {

        private val _apiInterface by lazy {
            Retrofit.Builder()
                .baseUrl(Config.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiInterface::class.java)
        }

        fun getApiInterface(): ApiInterface = _apiInterface
    }
}