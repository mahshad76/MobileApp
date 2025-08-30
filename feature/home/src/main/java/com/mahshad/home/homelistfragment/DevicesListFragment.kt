package com.mahshad.home.homelistfragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.mahshad.home.databinding.FragmentHomeABinding
import com.mahshad.model.data.Object
import com.mahshad.repository.objectrepository.Result
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DevicesListFragment : Fragment(), ClickListener {

    private val myViewModel: DevicesListViewModel by viewModels()
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
        homeListFragmentBinding.recyclerView.layoutManager = LinearLayoutManager(context)
        myViewModel.updateObjectsList()
        myViewModel.objectState.observe(viewLifecycleOwner) { result ->
            when (result) {
                is Result.Successful -> {
                    homeListFragmentBinding.loadingSpinner.visibility = GONE
                    _data = result.data
                    val adapter = DevicesListAdapter(
                        data,
                        ::addButtonIsClicked
                    )
                    homeListFragmentBinding.recyclerView.adapter = adapter
                }

                is Result.Error -> {
                    homeListFragmentBinding.loadingSpinner.visibility = GONE
                    Log.d("TAG", "error: ${result.error} ")
                }

                is Result.Loading -> homeListFragmentBinding.loadingSpinner.visibility = VISIBLE
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