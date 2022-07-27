package com.example.phonecomparator.model

import com.google.gson.annotations.SerializedName

data class CategorySearch(
    @SerializedName("category") val category: List<String>
)