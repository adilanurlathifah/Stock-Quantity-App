package org.assesment2.stockquantityapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    val productName = MutableLiveData<String>()
    val quantity = MutableLiveData<Int>()
    val totalPrice = MutableLiveData<Int>()
}
