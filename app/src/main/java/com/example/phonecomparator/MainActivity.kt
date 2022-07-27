package com.example.phonecomparator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.phonecomparator.databinding.ActivityMainBinding
import com.example.phonecomparator.model.MetaSmart
import com.example.phonecomparator.model.RawSmart
import com.example.phonecomparator.model.ResultSmart
import com.example.phonecomparator.view.SearchRecyclerAdapter

class MainActivity : AppCompatActivity() {

    private var _binding : ActivityMainBinding? = null
    private val binding : ActivityMainBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}