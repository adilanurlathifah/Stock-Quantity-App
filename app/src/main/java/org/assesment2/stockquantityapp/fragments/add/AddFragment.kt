package org.assesment2.stockquantityapp.fragments.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
<<<<<<< HEAD
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import org.assesment2.stockquantityapp.R
import org.assesment2.stockquantityapp.databinding.FragmentAddBinding
=======
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import org.assesment2.stockquantityapp.R
>>>>>>> 5c6f7f2d07083d30287225b5301def476d446798
import org.assesment2.stockquantityapp.model.Item
import org.assesment2.stockquantityapp.viewmodel.ItemViewModel

class AddFragment : Fragment() {

<<<<<<< HEAD
    private lateinit var binding: FragmentAddBinding
    private lateinit var mItemViewModel: ItemViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddBinding.inflate(inflater, container, false)
        val view = binding.root

        mItemViewModel = ViewModelProvider(this).get(ItemViewModel::class.java)
        binding.addBtn.setOnClickListener {
            insertDataToDatabase()
=======
    private lateinit var mItemViewModel : ItemViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        mItemViewModel = ViewModelProvider(this).get(ItemViewModel::class.java)
        view.findViewById<Button>(R.id.add_btn).setOnClickListener{
            insertDataToDatabase(view);
>>>>>>> 5c6f7f2d07083d30287225b5301def476d446798
        }
        return view
    }

<<<<<<< HEAD
    private fun insertDataToDatabase() {
        val productNames = binding.productNameEdt.text.toString()
        val price = binding.priceEdt.text
        val quantity = binding.quantityEdt.text

        try {
            if (inputCheck(productNames, price, quantity)) {
                val item = Item(
                    0,
                    productNames,
                    Integer.parseInt(price.toString()),
                    Integer.parseInt(quantity.toString())
                )
                //add data to database
                mItemViewModel.addItem(item)
                Toast.makeText(requireContext(), "Successfully added", Toast.LENGTH_LONG).show()
                findNavController().navigate(R.id.action_addFragment_to_listFragment)
            }
        } catch (e: Exception) {
            Toast.makeText(requireContext(), "Please fill all the fields", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(productName: String, price: Editable, quantity: Editable): Boolean {
        return !(TextUtils.isEmpty(productName) && price.isEmpty() && quantity.isEmpty())
    }
}
=======
    private fun insertDataToDatabase(view :View) {

        val productNames = view.findViewById<EditText>(R.id.productName_edt).text.toString()
        val price = view.findViewById<EditText>(R.id.price_edt).text
        val quantity = view.findViewById<EditText>(R.id.quantity_edt).text

        try {
            if(inputCheck(productNames,price, quantity))
            {
                val item = Item(0,productNames,Integer.parseInt(price.toString()), Integer.parseInt(quantity.toString()) )
                //add data to database
                mItemViewModel.addItem(item)
                Toast.makeText(requireContext(),"Successfully added", Toast.LENGTH_LONG).show()
                findNavController().navigate(R.id.action_addFragment_to_listFragment)
            }
        }
        catch (e:Exception)
        {
            Toast.makeText(requireContext(),"Please fill all the fields",Toast.LENGTH_LONG).show()
        }

    }

    private fun inputCheck(productName:String, price:Editable, quantity: Editable):Boolean {
        return !(TextUtils.isEmpty(productName) && price.isEmpty() && quantity.isEmpty())
    }
}
>>>>>>> 5c6f7f2d07083d30287225b5301def476d446798
