package com.mahshad.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
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
        ///objectView.productImageView  = using coil or glide
        objectView.descriptionTextView.text = item.data?.description
    }

}