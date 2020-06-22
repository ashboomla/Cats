package com.example.projectcapitoloneinterview.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projectcapitoloneinterview.R
import com.example.projectcapitoloneinterview.data.Breed
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.breed_row_adapter.*

class DetailsActivity : AppCompatActivity() {
lateinit var breed: Breed
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        breed = intent.getParcelableExtra("DATA") as Breed

        text_view_breed_name.text = breed.name
        text_view_description.text = breed.description
        text_view_origin.text = breed.origin
        text_view_temperament.text = breed.temperament

        button_wiki.setOnClickListener {
            var webIntent = Intent(this, WebViewActivity::class.java)
            webIntent.putExtra("WEBKEY",breed.wikipedia_url)
            startActivity(webIntent)
        }
    }
}
