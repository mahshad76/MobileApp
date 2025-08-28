package com.mahshad.home.homeBasketFragment

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mahshad.home.databinding.FragmentHomeBBinding
import com.mahshad.model.data.Object

class HomeBasketAdapter(private val objects: List<Object>) :
    RecyclerView.Adapter<HomeBasketAdapter.HomeBasketViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeBasketViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: HomeBasketViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount() = objects.size

    inner class HomeBasketViewHolder(view: FragmentHomeBBinding) :
        RecyclerView.ViewHolder(view.root) {

    }
}
