package com.example.mygallery

import android.content.Context
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_image_view.view.*


class MyAdapter(
    private val images: ArrayList<Image>, private val context: Context,val clickListener: (Int) -> Unit) : RecyclerView.Adapter<ViewHolder>() {

    override fun getItemCount(): Int {
        return images.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_image_view, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: Image = images[position]
        holder.image.setImageResource(item.imageId)
        holder.itemView.setOnClickListener { clickListener(position) }
    }
}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val image = view.singleImage!!
}