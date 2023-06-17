package org.assesment2.stockquantityapp.repository

import androidx.lifecycle.LiveData
import org.assesment2.stockquantityapp.data.ItemDao
import org.assesment2.stockquantityapp.model.Item

class ItemRepository(private val itemDao: ItemDao) {

    val readAllData : LiveData<List<Item>> = itemDao.readAllData()

    suspend fun addItem(item: Item) {
        itemDao.addItem(item)
    }

    suspend fun updateItem(item: Item) {
        itemDao.updateItem(item)
    }
    suspend fun deleteItem(item: Item){
        itemDao.deleteItem(item)
    }

    suspend fun deleteAllItem() {
        itemDao.deleteAllItems()
    }
}