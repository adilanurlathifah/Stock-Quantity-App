package org.assesment2.stockquantityapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.assesment2.stockquantityapp.data.ItemDatabase
import org.assesment2.stockquantityapp.model.Item
import org.assesment2.stockquantityapp.repository.ItemRepository

class ItemViewModel(application: Application) : AndroidViewModel(application) {

    val readAllData : LiveData<List<Item>>
    private val repository : ItemRepository

    init{
        val itemDao = ItemDatabase.getDatabase(application).itemDao()
        repository = ItemRepository(itemDao)
        readAllData = repository.readAllData
    }

    fun addItem(item: Item){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addItem(item)
        }
    }

    fun updateItem(item: Item)
    {
        viewModelScope.launch(Dispatchers.IO){
            repository.updateItem(item)
        }
    }

    fun deleteItem(item: Item){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteItem(item)
        }
    }

    fun deleteAllItem(){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteAllItem()
        }
    }
}