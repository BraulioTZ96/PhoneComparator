package com.example.phonecomparator.view

import com.example.phonecomparator.model.SmartthingSearch

sealed class UIState {

    object Loading: UIState()
    class Error(val error: Exception): UIState()
    class Success(val response: SmartthingSearch): UIState()

}

enum class DaysOfTheWeek {

    Monday,
    Tuesday,
    Wednesday,
    Thursday,
    Friday,
    Saturday,
    Sunday

}