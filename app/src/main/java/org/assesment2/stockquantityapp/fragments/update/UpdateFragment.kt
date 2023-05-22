package org.assesment2.stockquantityapp.fragments.update

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*
import org.assesment2.stockquantityapp.R
import org.assesment2.stockquantityapp.model.Item

class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()

    private lateinit var mItemViewModel:ItemViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view:View = inflater.inflate(R.layout.fragment_update, container, false)

        mItemViewModel = ViewModelProvider(this).get(ItemViewModel::class.java)
        view.updateproductName_edt.setText(args.currentUser.productName)
        view.updateprice_edt.setText(args.currentUser.price.toString())
        view.updatequantity_edt.setText(args.currentUser.quantity.toString())

        view.update_btn.setOnClickListener {
            updateItem()
        }
        //add menu
        setHasOptionsMenu(true)
        return view
    }

    private fun updateItem()
    {
        val productName = updateproductName_edt.text.toString()
        val price = Integer.parseInt(updateprice_edt.text.toString())
        val quantity = Integer.parseInt(updatequantity_edt.text.toString())

        try
        {
            if(inputCheck(productName, updateprice_edt.text, updatequantity_edt.text))
            {
                val updatedItem = Item(args.currentUser.id,productName,price,quantity)

                mItemViewModel.updateItem(updatedItem)
                Toast.makeText(requireContext(),"Successfully Updated",Toast.LENGTH_LONG).show()
                findNavController().navigate(R.id.action_updateFragment_to_listFragment)
            }
        }
        catch (e:Exception){
            Toast.makeText(requireContext(),"Please fill all the fields",Toast.LENGTH_LONG).show()
        }

    }

    private fun inputCheck(productName:String, price:Editable, quantity: Editable):Boolean {
        return !(TextUtils.isEmpty(productName) && price.isEmpty() && quantity.isEmpty())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        inflater.inflate(R.menu.delete_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == R.id.menu_delete){
            deleteItem()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteItem() {
        var builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes"){_,_ ->
            mItemViewModel.deleteItem(args.currentUser)
            Toast.makeText(requireContext(),
                "Successfully Deleted : ${args.currentUser.productName}",
                Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }
        builder.setNegativeButton("No"){_,_ ->

        }
        builder.setTitle("Delete ${args.currentUser.productName}?")
        builder.setMessage("Are you sure you want to delete ${args.currentUser.productName}?")
        builder.create().show()
    }
}