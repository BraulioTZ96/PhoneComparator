package com.example.phonecomparator.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.phonecomparator.repository.SearchRepositoryImpl
import java.lang.IllegalArgumentException

class SearchViewModelFactory(private val searchRepositoryImpl: SearchRepositoryImpl): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SearchViewModel::class.java))
            return SearchViewModel(searchRepositoryImpl) as T
        throw IllegalArgumentException("Unknown ViewModel")
    }

}