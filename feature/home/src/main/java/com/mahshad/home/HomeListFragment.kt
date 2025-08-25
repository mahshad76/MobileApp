package com.mahshad.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mahshad.home.databinding.FragmentHomeABinding
import com.mahshad.repository.Result
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeListFragment : Fragment() {

    private val myViewModel: HomeListViewModel by viewModels()
    private lateinit var homeListFragmentBinding: FragmentHomeABinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar

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
        val numberOfColumns = 2
        val gridLayoutManager = GridLayoutManager(context, numberOfColumns)
        recyclerView.layoutManager = gridLayoutManager
        progressBar = homeListFragmentBinding.loadingSpinner
        myViewModel.updateObjectsList()
        myViewModel.objectState.observe(viewLifecycleOwner) { result ->
            when (result) {
                is Result.Successful -> {
                    progressBar.isVisible = false
                    val adapter = HomeListAdapter(result.data)
                    recyclerView.adapter = adapter
                }

                is Result.Error -> {
                    progressBar.isVisible = false
                    Log.d("TAG", "error: ${result.error} ")
                }

                is Result.Loading -> progressBar.isVisible = true
                null -> Log.d("TAG", "onCreateView:null ")
            }
        }
        return homeListFragmentBinding.root
    }
}