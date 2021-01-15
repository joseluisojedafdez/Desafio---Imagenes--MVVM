package com.i4bchile.desafio_images_mvvm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.i4bchile.desafio_images_mvvm.databinding.ItemListPhotoBinding

class PhotoAdapter: RecyclerView.Adapter<PhotoVH>() {

    var photoList=listOf<Photo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoVH {

        val binding= ItemListPhotoBinding.inflate(LayoutInflater.from(parent.context))

        return PhotoVH(binding)
    }

    override fun onBindViewHolder(holder: PhotoVH, position: Int) {
       val photo=photoList[position]
        holder.bind(photo)
    }

    override fun getItemCount(): Int {
        return photoList.size
    }

    fun updateList(lista: List<Photo>) {
        photoList=lista
        notifyDataSetChanged()

    }


}

class PhotoVH(val binding:ItemListPhotoBinding):RecyclerView.ViewHolder(binding.root) {

    fun bind(photo: Photo) {
        binding.tvPhotoTitle.text=photo.title
        binding.ivPhoto.load(photo.thumbnailUrl)

    }


}
