package com.example.projectcapitoloneinterview.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.projectcapitoloneinterview.R
import com.example.projectcapitoloneinterview.data.CatData
import kotlinx.android.synthetic.main.images_row_adapter.view.*

class CatsImageAdapter(var myContext: Context, var mList : List<CatData>) :
    RecyclerView.Adapter<CatsImageAdapter.CatsImageViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatsImageViewHolder {
        var view = LayoutInflater.from(myContext).inflate(R.layout.images_row_adapter,parent,false)
        return CatsImageViewHolder(view)
    }

    override fun getItemCount(): Int {
      return mList.size
    }

    override fun onBindViewHolder(holder: CatsImageViewHolder, position: Int) {
        var catImage = mList[position]
        holder.bind(catImage)
    }

    inner class CatsImageViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(catImage: CatData){
            itemView.image_view.loadImage(catImage.url)
        }

        private fun ImageView.loadImage(url: String?) {
            Glide
                .with(context)
                .load(url)
                .placeholder(android.R.drawable.ic_menu_report_image)
                .error(android.R.drawable.ic_menu_report_image)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(this)
        }
    }

}