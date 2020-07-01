package com.example.projectcapitoloneinterview.ui.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projectcapitoloneinterview.R
import com.example.projectcapitoloneinterview.data.Breed
import com.example.projectcapitoloneinterview.ui.activities.DetailsActivity
import kotlinx.android.synthetic.main.breed_row_adapter.view.*

class CatsBreedsAdapter(var myContext: Context, var mList: List<Breed>) :
    RecyclerView.Adapter<CatsBreedsAdapter.CatsBreedsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatsBreedsViewHolder {
        var view = LayoutInflater.from(myContext).inflate(R.layout.breed_row_adapter, parent, false)
        return CatsBreedsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    inner class CatsBreedsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(catBreed: Breed) {
            itemView.textView.text = catBreed.name

            itemView.textView.setOnClickListener{
                var intent = Intent(myContext, DetailsActivity::class.java)
                intent.putExtra("DATA",catBreed)
                myContext.startActivity(intent)
            }
        }

    }

    override fun onBindViewHolder(holder: CatsBreedsViewHolder, position: Int) {
        var catBreed = mList[position]
        holder.bind(catBreed)
    }

}
