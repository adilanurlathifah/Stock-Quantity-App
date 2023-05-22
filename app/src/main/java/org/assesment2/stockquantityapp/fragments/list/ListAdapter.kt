package org.assesment2.stockquantityapp.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.custom_row.view.*
import org.assesment2.stockquantityapp.R
import org.assesment2.stockquantityapp.model.Item

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
    private var itemList = emptyList<Item>()

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