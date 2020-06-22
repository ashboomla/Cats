package com.example.projectcapitoloneinterview.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.projectcapitoloneinterview.R
import com.example.projectcapitoloneinterview.app.Config
import com.example.projectcapitoloneinterview.data.Breed
import com.example.projectcapitoloneinterview.network.ApiInterface
import com.example.projectcapitoloneinterview.ui.adapters.MainTabAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * //api_key=0f77267c-6012-4083-97d9-9811ace0070b
- I need an Android application that has information on cats using the API https://thecatapi.com/
- The architecture pattern should be MVVM and in Kotlin
- I want the landing page to be a tab layout with two tabs: Images of cats and Information on cat breeds
- One tab should be titled Images
- The other tab should be titled Breeds
- The Images tab should be a grid layout of ImageViews
- data: https://api.thecatapi.com/v1/images/search
- The Breeds tab should be a list of all the breeds available on the API
- data: https://api.thecatapi.com/v1/breeds
- When the user clicks on one of the listed breeds, they should be navigated to a details page which shows the following information:
- Breed name
- Breed origin
- Breed description
- Breed temperament
- Link to more information on the breed which opens in an external browser experience
- Project must have version control and use git

 - https://docs.thecatapi.com/api-reference/breeds/breeds-list
 - https://docs.thecatapi.com/api-reference/images/images-search
 */
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // getdata()
       init()
    }

    private fun init() {
        var mainFragmentAdapter =
            MainTabAdapter(
                supportFragmentManager
            )
        view_pager.adapter = mainFragmentAdapter
        tab_layout.setupWithViewPager(view_pager)
    }


//testing
    private fun getdata(){
        var Api = ApiInterface.getApiInterface().getCatsBreeds(Config.API_KEY)
        Api.enqueue(object: Callback<List<Breed>>{
            override fun onFailure(call: Call<List<Breed>>?, t: Throwable?) {
                Log.e("aaa", t?.message)
            }

            override fun onResponse(call: Call<List<Breed>>?, response: Response<List<Breed>>?) {
                Log.i("aaa", response?.body().toString())
            }

        })
    }


}
