package com.mahshad.home.homeBasketFragment

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mahshad.home.databinding.BasketLayoutBinding
import com.mahshad.model.data.Object

class HomeBasketAdapter(private val objects: List<Object>) :
    RecyclerView.Adapter<HomeBasketAdapter.HomeBasketViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeBasketViewHolder {
        val binding = BasketLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return HomeBasketViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeBasketViewHolder, position: Int) {
        holder.binding(objects[position])
    }

    override fun getItemCount(): Int {
        Log.d("TAG", "getItemCount:${objects.size} ")
        return objects.size
    }

    inner class HomeBasketViewHolder(private val view: BasketLayoutBinding) :
        RecyclerView.ViewHolder(view.root) {

        fun binding(item: Object) {
            view.deviceName.text = item.name
            view.devicePrice.text = item.data?.price
            view.deviceDescription.text = item.data?.description
        }

    }
}
