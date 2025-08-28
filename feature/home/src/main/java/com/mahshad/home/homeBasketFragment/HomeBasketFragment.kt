package com.mahshad.home.homeBasketFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mahshad.home.databinding.FragmentHomeBBinding

class HomeBasketFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentHomeBBinding = FragmentHomeBBinding.inflate(
            inflater, container,
            false
        )
        //fragmentHomeBBinding.basketRecyclerView.adapter = HomeBasketAdapter()
        return fragmentHomeBBinding.root
    }
}