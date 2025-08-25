package com.mahshad.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mahshad.home.databinding.ObjectLayoutBinding
import com.mahshad.model.data.Object

class HomeListAdapter(private val objectsList: List<Object>) :
    RecyclerView.Adapter<HomeListViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeListViewHolder {
        val binding = ObjectLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return HomeListViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: HomeListViewHolder,
        position: Int
    ) = holder.bind(objectsList[position])

    override fun getItemCount(): Int = objectsList.size

}

class HomeListViewHolder(private val objectView: ObjectLayoutBinding) :
    RecyclerView.ViewHolder(objectView.root) {
    fun bind(item: Object) {
        objectView.generationTextView.text = item.data?.generation
        objectView.nameTextView.text = item.name
        objectView.priceTextView.text = item.data?.price
        Glide.with(itemView.context)
            .load("https://i.guim.co.uk/img/media/50a105c31fd62140c195309511a5074e12e9d90e/897_0_4449_3558/master/4449.jpg?width=1200&height=630&quality=85&auto=format&fit=crop&precrop=40:21,offset-x50,offset-y0&overlay-align=bottom%2Cleft&overlay-width=100p&overlay-base64=L2ltZy9zdGF0aWMvb3ZlcmxheXMvdGctZGVmYXVsdC5wbmc&enable=upscale&s=e0ce26f1498f6fda5da9e56eb973a30d")
            .into(objectView.productImageView)
        objectView.descriptionTextView.text = item.data?.description
    }
}