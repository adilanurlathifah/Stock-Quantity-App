package org.assesment2.stockquantityapp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import org.assesment2.stockquantityapp.model.Item

@Dao
interface ItemDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addItem(item: Item)

    @Update
    suspend fun updateItem(item: Item)

    @Delete
    suspend fun deleteItem(item: Item)

    @Query("DELETE FROM item_table")
    fun deleteAllItems()

    @Query("SELECT * FROM item_table ORDER BY id ASC")
    fun readAllData():LiveData<List<Item>>
}