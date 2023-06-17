package org.assesment2.stockquantityapp.fragments.list

import android.view.LayoutInflater
<<<<<<< HEAD
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import org.assesment2.stockquantityapp.databinding.CustomRowBinding
=======
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.custom_row.view.*
import org.assesment2.stockquantityapp.R
>>>>>>> 5c6f7f2d07083d30287225b5301def476d446798
import org.assesment2.stockquantityapp.model.Item

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
    private var itemList = emptyList<Item>()

<<<<<<< HEAD
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
=======
    fun setData(item:List<Item>)
    {
        this.itemList = item
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View =  LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder:MyViewHolder, position: Int) {
        var currentItem  = itemList[position]
        holder.idTxtView.text = currentItem.id.toString()
        holder.productNameTextView.text = currentItem.productName
        holder.priceTextView.text = currentItem.price.toString()
        holder.quantityTextView.text = currentItem.quantity.toString()

        holder.itemView.rowLayout.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        if(itemList.isNotEmpty())
            return itemList.size
        else return 0

    }
    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        var idTxtView : TextView
        var productNameTextView : TextView
        var priceTextView : TextView
        var quantityTextView : TextView

        init {
            idTxtView = itemView.findViewById(R.id.id_txtV)
            productNameTextView = itemView.findViewById(R.id.productName_txtV)
            priceTextView = itemView.findViewById(R.id.price_txtV)
            quantityTextView = itemView.findViewById(R.id.quantity_txtV)
        }
    }
}
>>>>>>> 5c6f7f2d07083d30287225b5301def476d446798
