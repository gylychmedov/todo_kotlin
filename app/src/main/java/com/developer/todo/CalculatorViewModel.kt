package com.developer.todo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel: ViewModel() {
    var result = MutableLiveData<String>()

    init {
        result = MutableLiveData<String>()
    }

    fun addition (san1: String, san2: String) {
        val san1Int = san1.toInt()
        val san2Int = san2.toInt()
        result.value = (san1Int+san2Int).toString()
    }

    fun multiplication (san1: String, san2: String) {
        val san1Int = san1.toInt()
        val san2Int = san2.toInt()
        result.value = (san1Int * san2Int).toString()
    }

    fun subtraction (san1: String, san2: String) {
        val san1Int = san1.toInt()
        val san2Int = san2.toInt()
        result.value = (san1Int - san2Int).toString()
    }

    fun division (san1: String, san2: String) {
        val san1Int = san1.toInt()
        val san2Int = san2.toInt()
        result.value = (san1Int / san2Int).toString()
    }
}