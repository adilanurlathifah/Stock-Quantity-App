package org.assesment2.stockquantityapp.fragments.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import org.assesment2.stockquantityapp.databinding.CustomRowBinding
import org.assesment2.stockquantityapp.model.Item

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
    private var itemList = emptyList<Item>()

    fun setData(item: List<Item>) {
        this.itemList = item
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = CustomRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.bind(currentItem)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class MyViewHolder(private val binding: CustomRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {
            binding.idTxtV.text = item.id.toString()
            binding.productNameTxtV.text = item.productName
            binding.priceTxtV.text = item.price.toString()
            binding.quantityTxtV.text = item.quantity.toString()

            binding.rowLayout.setOnClickListener {
                val action = ListFragmentDirections.actionListFragmentToUpdateFragment(item)
                it.findNavController().navigate(action)
            }
        }
    }
}
