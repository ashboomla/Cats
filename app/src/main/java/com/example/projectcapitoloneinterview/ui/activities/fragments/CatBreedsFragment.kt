package com.example.projectcapitoloneinterview.ui.activities.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projectcapitoloneinterview.R
import com.example.projectcapitoloneinterview.network.ApiInterface
import com.example.projectcapitoloneinterview.ui.adapters.CatsBreedsAdapter
import com.example.projectcapitoloneinterview.ui.cats.CatsRepository
import com.example.projectcapitoloneinterview.ui.cats.CatsViewModel
import com.example.projectcapitoloneinterview.ui.cats.CatsViewModelFactory
import kotlinx.android.synthetic.main.fragment_cat_breeds.*

/**
 * A simple [Fragment] subclass.
 */
class CatBreedsFragment : Fragment() {

    private lateinit var viewModel : CatsViewModel
    private lateinit var factory: CatsViewModelFactory
    private lateinit var adapter: CatsBreedsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cat_breeds, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val repository = CatsRepository(ApiInterface.getApiInterface())
        factory = CatsViewModelFactory(repository)
        viewModel = ViewModelProvider(this,factory).get(CatsViewModel::class.java)

        recyclerViewBreeds.layoutManager = LinearLayoutManager(activity as Context)

        viewModel.getBreeds().observe(viewLifecycleOwner, Observer {list ->
            Log.i("aaa", list.toString())
            adapter =
                CatsBreedsAdapter(activity as Context, list)

            recyclerViewBreeds.adapter = adapter
        })

    }

}
