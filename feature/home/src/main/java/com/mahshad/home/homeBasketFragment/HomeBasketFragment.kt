package com.mahshad.home.homeBasketFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.mahshad.home.databinding.FragmentHomeBBinding

class HomeBasketFragment : Fragment() {
    private lateinit var fragmentHomeBBinding: FragmentHomeBBinding
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentHomeBBinding = FragmentHomeBBinding.inflate(
            inflater, container,
            false
        )
        recyclerView = fragmentHomeBBinding.basketRecyclerView
        return fragmentHomeBBinding.root
    }
}