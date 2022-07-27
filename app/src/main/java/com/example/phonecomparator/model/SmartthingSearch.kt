package com.example.phonecomparator.model

data class SmartthingSearch(
    val Success: Int,
    val message: String,
    val error: ErrorSmart,
    val data: DataSmart
)

data class ErrorSmart(
    val errorMessage: ErrorMessageSmart
)

data class ErrorMessageSmart(
    val message: String,
    val name: String,
    val stack: String
    //val config: ConfigSmart
)

data class DataSmart(
    val results: List<ResultSmart>
)

data class ResultSmart(
    val model: RawSmart?,
    val brand: RawSmart?,
    val version: RawSmart?,
    val _meta: MetaSmart,
    val image_front: RawSmart?
)

data class RawSmart(
    val raw: String
)

data class MetaSmart(
    val score: Double,
    val id: String
)
