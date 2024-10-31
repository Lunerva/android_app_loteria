package com.example.app_loto.viewModels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoteriaViewModel:ViewModel(){
    private  val _lotoNumbers = mutableStateOf(emptyList<Int>())
    val lotoNumbers:State<List<Int>> = _lotoNumbers

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading


    fun generateLotoNumbers(){
        _lotoNumbers.value=(1 .. 60).shuffled().take(6).sorted()
    }

    //funcion para generar nums y presentarlos gradualmente
    fun generateAndShowLotoNumbers() {
        viewModelScope.launch {
            _isLoading.value = true
            val numbers = (1..60).shuffled().take(6).sorted()
            _lotoNumbers.value = emptyList()

            //mostramos los numeros en intervalos de 2 segundos
            for (number in numbers) {
                _lotoNumbers.value = _lotoNumbers.value + number
                delay(2000)  //tiempo de espera 2seg
            }
            _isLoading.value = false  // Indicamos que la carga ha terminado

        }
    }

}