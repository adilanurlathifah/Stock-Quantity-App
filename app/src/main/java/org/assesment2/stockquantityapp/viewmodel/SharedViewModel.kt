package org.assesment2.stockquantityapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    val totalPrice = MutableLiveData<Int>()
}
