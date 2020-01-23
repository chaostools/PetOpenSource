package ru.sheckspir.petapplication.fragments.corutinloader.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.api.load
import coil.transform.CircleCropTransformation
import kotlinx.android.synthetic.main.item_image_view.view.*
import ru.sheckspir.petapplication.R
import ru.sheckspir.petapplication.fragments.corutinloader.model.ImageData

class ImageAdapter(private val imageLoader: ImageLoader) : RecyclerView.Adapter<ImageVH>(){

    private var images : MutableList<ImageData> = ArrayList()

    fun replaceImages(images : MutableList<ImageData>) {
        this.images = images
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageVH {
        return ImageVH(LayoutInflater.from(parent.context).inflate(R.layout.item_image_view, parent, false), imageLoader)
    }

    override fun getItemCount(): Int {
        return images.size
    }

    override fun onBindViewHolder(holder: ImageVH, position: Int) {
        holder.bind(images[position])
    }
}

class ImageVH(itemView : View, private val imageLoader: ImageLoader) : RecyclerView.ViewHolder(itemView) {

    private val imageView = itemView.imageView

    fun bind(imageData: ImageData) {
        if (imageData.url.isNotEmpty()) {
            imageView.load(imageData.url, imageLoader)
        } else {
            imageView.load(imageData.id, imageLoader)
        }
    }


}