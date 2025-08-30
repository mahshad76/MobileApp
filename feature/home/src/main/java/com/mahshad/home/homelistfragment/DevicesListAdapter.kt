package com.mahshad.home.homelistfragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mahshad.home.databinding.ObjectLayoutBinding
import com.mahshad.model.data.Object

class DevicesListAdapter(
    private val objectsList: List<Object>,
    private val clickListener: (Int) -> Unit
) :
    RecyclerView.Adapter<DevicesListAdapter.HomeListViewHolder>() {

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

    inner class HomeListViewHolder(val objectView: ObjectLayoutBinding) :
        RecyclerView.ViewHolder(objectView.root) {
        init {
            objectView.basketButton.setOnClickListener {
                clickListener(absoluteAdapterPosition)
            }
        }

        fun bind(item: Object) {
            objectView.objectName.text = item.name
            objectView.priceText.text = item.data?.price
            objectView.descriptionObject.text = item.data?.description
        }
    }
}