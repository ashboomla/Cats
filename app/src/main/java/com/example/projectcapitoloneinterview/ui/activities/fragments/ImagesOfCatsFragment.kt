package com.example.projectcapitoloneinterview.ui.activities.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.projectcapitoloneinterview.ui.adapters.CatsImageAdapter
import com.example.projectcapitoloneinterview.R
import com.example.projectcapitoloneinterview.ui.cats.CatsRepository
import com.example.projectcapitoloneinterview.ui.cats.CatsViewModel
import com.example.projectcapitoloneinterview.ui.cats.CatsViewModelFactory
import com.example.projectcapitoloneinterview.network.ApiInterface
import kotlinx.android.synthetic.main.fragment_images_of_cats.*

/**
 * A simple [Fragment] subclass.
 */

class ImagesOfCatsFragment : Fragment() {

    private lateinit var viewModel : CatsViewModel
    private lateinit var factory: CatsViewModelFactory
    private lateinit var adapter: CatsImageAdapter

            override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
                return inflater.inflate(R.layout.fragment_images_of_cats, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val repository = CatsRepository(ApiInterface.getApiInterface())
        factory = CatsViewModelFactory(repository)
        viewModel = ViewModelProviders.of(this,factory).get(CatsViewModel::class.java)

        recyclerViewImages.layoutManager = GridLayoutManager(activity as Context,2)

        viewModel.getImages().observe(viewLifecycleOwner, Observer {list ->
            Log.i("aaa", list.toString())
            adapter =
                CatsImageAdapter(activity as Context, list)
            recyclerViewImages.adapter = adapter
        })
    }
}
