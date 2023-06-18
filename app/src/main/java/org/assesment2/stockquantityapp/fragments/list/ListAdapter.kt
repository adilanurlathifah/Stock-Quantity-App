package org.assesment2.stockquantityapp.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import org.assesment2.stockquantityapp.databinding.ListItemBinding
import org.assesment2.stockquantityapp.model.Item

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
    private var itemList = emptyList<Item>()

    fun setData(item: List<Item>) {
        this.itemList = item
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.bind(currentItem)

        holder.binding.dividerView.visibility = if (position >= itemCount - 1) View.VISIBLE else View.VISIBLE
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class MyViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {
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
