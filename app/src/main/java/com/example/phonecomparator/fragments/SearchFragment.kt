package com.example.phonecomparator.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.phonecomparator.R
import com.example.phonecomparator.databinding.FragmentSearchBinding
import com.example.phonecomparator.repository.SearchRepositoryImpl
import com.example.phonecomparator.view.SearchRecyclerAdapter
import com.example.phonecomparator.viewmodel.SearchViewModel
import com.example.phonecomparator.viewmodel.SearchViewModelFactory

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private lateinit var searchAdapter: SearchRecyclerAdapter
    lateinit var searchViewModel: SearchViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        searchViewModel = ViewModelProvider(this, SearchViewModelFactory(SearchRepositoryImpl()))[SearchViewModel::class.java]

        configureListObserver()
        configureTextObserver()

        binding.spinSmartThing.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                startProgress()
                searchViewModel.searchSmartThings(position, binding.etItemSearch.text.toString())
            }

        }

        binding.bttnSearch.setOnClickListener {
            startProgress()
            searchViewModel.searchSmartThings(binding.spinSmartThing.selectedItemPosition, binding.etItemSearch.text.toString())
        }

        // Inflate the layout for this fragment

        return binding.root
    }

    private fun startProgress(){
        binding.tvErrorMessage.text = ""
        binding.pgbLoading.visibility = View.VISIBLE
        binding.tvErrorMessage.visibility = View.GONE
    }

    private fun configureListObserver(){
        searchViewModel.searchListResult.observe(viewLifecycleOwner, Observer { newResponseList ->
            if(newResponseList.isEmpty()){
                binding.rvResultSearch.adapter = SearchRecyclerAdapter(emptyList(), ::openDetailFragment)
                //binding.tvErrorMessage.text = "Network call failed"
                binding.pgbLoading.visibility = View.GONE
                //binding.tvErrorMessage.visibility = View.VISIBLE
            }else{
                searchAdapter = SearchRecyclerAdapter(newResponseList, ::openDetailFragment)
                binding.rvResultSearch.adapter = searchAdapter
                binding.pgbLoading.visibility = View.GONE
                //binding.tvErrorMessage.visibility = View.GONE
            }
        })
    }

    private fun configureTextObserver(){
        searchViewModel.textIsEmpty.observe(viewLifecycleOwner, Observer { newValue ->
            if (newValue == SearchViewModel.IS_EMPTY){
                binding.tvErrorMessage.text = "Text cant be empty"
                binding.tvErrorMessage.visibility = View.VISIBLE
            }else{
                binding.tvErrorMessage.visibility = View.GONE
            }
        })
    }

    private fun openDetailFragment(productId: String){
        parentFragmentManager.beginTransaction()
            .replace(R.id.main_fragment_container, DetailFragment.newInstance(productId))
            .addToBackStack(null)
            .commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}