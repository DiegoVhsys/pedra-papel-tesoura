package br.com.vhsys.pedrapapeletesoura.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    companion object {
        const val SCISSOR_MOVE = 1
        const val ROCK_MOVE = 2
        const val PAPER_MOVE = 3
    }

    val liveDataComputerMove = MutableLiveData<String>()

    fun move(value: Int) {


    }


}