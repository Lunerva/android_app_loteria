package com.example.app_loto.viewModels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel

class LoteriaViewModel:ViewModel(){
    private  val _lotoNumbers = mutableStateOf(emptyList<Int>())
    val lotoNumbers:State<List<Int>> = _lotoNumbers

    fun generateLotoNumbers(){
        _lotoNumbers.value=(1 .. 60).shuffled().take(6).sorted()
    }


}