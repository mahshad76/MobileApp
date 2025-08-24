package com.mahshad.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.mahshad.home.databinding.FragmentHomeABinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeListFragment : Fragment() {

    private val myViewModel: HomeListViewModel by viewModels()
    private lateinit var homeListFragmentBinding: FragmentHomeABinding
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeListFragmentBinding = FragmentHomeABinding.inflate(
            inflater, container,
            false
        )
        textView = homeListFragmentBinding.textView
        textView.text = "Hello world"
        return homeListFragmentBinding.root
    }
}