package com.mahshad.home.homebasketfragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.mahshad.home.databinding.FragmentHomeBBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeBasketFragment : Fragment() {

    private val homeBasketViewModel: HomeBasketViewModel by viewModels()
    private var fragmentHomeBBinding: FragmentHomeBBinding? = null
    private lateinit var myContext: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        myContext = context
    }

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
        fragmentHomeBBinding?.basketRecyclerView?.layoutManager = LinearLayoutManager(myContext)

        homeBasketViewModel.updateUiState()

        viewLifecycleOwner.lifecycleScope.launch {
            ///TODO(use diffutils to avoid recreation of the adapter each time the flow emits a list)
            homeBasketViewModel.uiState.collect { objectsBasket: HomeBasketUiEvent ->
                when (objectsBasket) {
                    is HomeBasketUiEvent.Error -> {
                        fragmentHomeBBinding?.progressBar?.visibility =
                            GONE
                        Toast.makeText(
                            context,
                            objectsBasket.e.toString(), Toast.LENGTH_LONG
                        ).show()
                    }

                    is HomeBasketUiEvent.Loading -> fragmentHomeBBinding?.progressBar?.visibility =
                        VISIBLE

                    is HomeBasketUiEvent.Successful -> {
                        fragmentHomeBBinding?.progressBar?.visibility =
                            GONE
                        val adapter = HomeBasketAdapter(objectsBasket.devices)
                        fragmentHomeBBinding?.basketRecyclerView?.adapter = adapter
                    }
                }
            }
        }
        return fragmentHomeBBinding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentHomeBBinding = null
    }
}