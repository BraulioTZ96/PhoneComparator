package com.example.phonecomparator.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.phonecomparator.R
import com.example.phonecomparator.databinding.FragmentDetailBinding
import com.example.phonecomparator.repository.ProductDetailImpl
import com.example.phonecomparator.repository.SearchRepositoryImpl
import com.example.phonecomparator.view.SearchRecyclerAdapter
import com.example.phonecomparator.viewmodel.DetailViewModel
import com.example.phonecomparator.viewmodel.DetailViewModelFactory
import com.example.phonecomparator.viewmodel.SearchViewModel
import com.example.phonecomparator.viewmodel.SearchViewModelFactory

private const val PARAM_PRODUCT_ID = "product_id"

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    private lateinit var detailViewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        val productId = arguments?.getString(PARAM_PRODUCT_ID) ?: ""

        detailViewModel = ViewModelProvider(this, DetailViewModelFactory(ProductDetailImpl(), productId))[DetailViewModel::class.java]
        configureListObserver()
        // Inflate the layout for this fragment
        return binding.root
    }

    private fun configureListObserver(){
        detailViewModel.productListResult.observe(viewLifecycleOwner, Observer { newResponseList ->
            binding.pgbLoadingDetail.visibility = View.GONE
            if(newResponseList.isEmpty()){
                binding.tvProductId.text = "EMPTY LIST"
            }else{
                binding.tvProductId.text = detailViewModel.productListResult.value?.get(0).toString()
            }
        })
    }

    companion object {

        fun newInstance(productId: String) : DetailFragment{
            val instance = DetailFragment()
            val bundle = Bundle()
            bundle.putString(PARAM_PRODUCT_ID, productId)
            instance.arguments = bundle
            return instance
        }

    }
}