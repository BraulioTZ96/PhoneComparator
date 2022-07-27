package com.example.phonecomparator.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.phonecomparator.model.CategorySearch
import com.example.phonecomparator.model.ResultSmart
import com.example.phonecomparator.repository.SearchRepositoryImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchViewModel(private val repositoryImpl: SearchRepositoryImpl): ViewModel() {

    private val _searchListResult = MutableLiveData<List<ResultSmart>>()
    val searchListResult: LiveData<List<ResultSmart>> get() = _searchListResult

    private val _textIsEmpty = MutableLiveData(true)
    val textIsEmpty get() = _textIsEmpty

    fun searchSmartThings(spinnerPositionSelected: Int, productToSearch: String){
        val bodyCategory = when(spinnerPositionSelected){
            1 -> CategorySearch(listOf("smartwatch"))
            2 -> CategorySearch(listOf("tablet"))
            3 -> CategorySearch(listOf("laptop"))
            else -> CategorySearch(listOf("smartphone"))
        }
        if(productToSearch.isNotEmpty() && productToSearch.isNotBlank()){
            _textIsEmpty.postValue(false)
            getSearchList(bodyCategory, productToSearch)
        }else{
            _textIsEmpty.postValue(true)
            _searchListResult.postValue(emptyList())
        }
    }

    private fun getSearchList(body: CategorySearch, productToSearch: String){
        CoroutineScope(Dispatchers.IO).launch {
            val response = repositoryImpl.getSearchProduct(body, productToSearch)
            _searchListResult.postValue(response.results)
        }
    }

    companion object {
        const val IS_EMPTY = true
        const val IS_NOT_EMPTY = false
    }

}