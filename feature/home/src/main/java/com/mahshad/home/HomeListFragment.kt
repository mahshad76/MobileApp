package com.mahshad.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.mahshad.home.databinding.FragmentHomeABinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeListFragment : Fragment() {

    private val myViewModel: HomeListViewModel by viewModels()
    private lateinit var homeListFragmentBinding: FragmentHomeABinding
    private lateinit var recyclerView: RecyclerView

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
        recyclerView = homeListFragmentBinding.recyclerView
        myViewModel.updateObjectsList()
        myViewModel.objectState.observe(viewLifecycleOwner) { result ->
//            when (result) {
//                is Result.Successful -> textView.text = result.data.toString()
//                is Result.Error -> textView.text = result.error.toString()
//                is Result.Loading -> textView.text = "Loading"
//                null -> textView.text = "null"
//            }
        }
        return homeListFragmentBinding.root
    }
}