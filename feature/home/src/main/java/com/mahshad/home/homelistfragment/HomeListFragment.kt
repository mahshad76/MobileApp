package com.mahshad.home.homelistfragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.mahshad.home.databinding.FragmentHomeABinding
import com.mahshad.model.data.Object
import com.mahshad.repository.objectrepository.Result
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeListFragment : Fragment(), ClickListener {

    private val myViewModel: HomeListViewModel by viewModels()
    private var _homeListFragmentBinding: FragmentHomeABinding? = null
    private val homeListFragmentBinding: FragmentHomeABinding
        get() = _homeListFragmentBinding!!

    private var _data: List<Object>? = null
    private val data: List<Object>
        get() = _data!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _homeListFragmentBinding = FragmentHomeABinding.inflate(
            inflater, container,
            false
        )
        val numberOfColumns = 2
        val gridLayoutManager = GridLayoutManager(context, numberOfColumns)
        homeListFragmentBinding.recyclerView.layoutManager = gridLayoutManager
        myViewModel.updateObjectsList()
        myViewModel.objectState.observe(viewLifecycleOwner) { result ->
            when (result) {
                is Result.Successful -> {
                    homeListFragmentBinding.loadingSpinner.isVisible = false
                    _data = result.data
                    val adapter = HomeListAdapter(
                        data,
                        ::addButtonIsClicked
                    )
                    homeListFragmentBinding.recyclerView.adapter = adapter
//                    lifecycleScope.launch {
//                        adapter
//                            .clicksFlow.throttleFirst(300L)
//                            .collect { click ->
//                                myViewModel.addButtonClickListener(result.data[click])
//                            }
//                    }
                }

                is Result.Error -> {
                    homeListFragmentBinding.loadingSpinner.isVisible = false
                    Log.d("TAG", "error: ${result.error} ")
                }

                is Result.Loading -> homeListFragmentBinding.loadingSpinner.isVisible = true
                null -> Log.d("TAG", "onCreateView:null ")
            }
        }
        return homeListFragmentBinding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _homeListFragmentBinding = null
    }

    override fun addButtonIsClicked(clickPosition: Int) =
        myViewModel.addButtonClickListener(data[clickPosition])
}