package com.example.animationsample.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.animationsample.R
import com.example.animationsample.data.Picture

class ImageAdapter(@NonNull private val pictures: List<Picture>) :
    RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder = ImageViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false)
    )

    override fun getItemCount(): Int = pictures.size

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.onBind(pictures[position])
    }

    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(picture: Picture) {
            Glide.with(itemView.context)
                .load(picture.url)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_background)
                .into(itemView.findViewById(R.id.item_image_image_view))
        }
    }
}
