package org.assesment2.stockquantityapp.fragments.add

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import org.assesment2.stockquantityapp.R
import org.assesment2.stockquantityapp.databinding.FragmentAddBinding
import org.assesment2.stockquantityapp.model.Item
import org.assesment2.stockquantityapp.viewmodel.ItemViewModel
import org.assesment2.stockquantityapp.viewmodel.SharedViewModel

class AddFragment : Fragment() {

    private lateinit var binding: FragmentAddBinding
    private lateinit var mItemViewModel: ItemViewModel
    private lateinit var sharedViewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentAddBinding.inflate(inflater, container, false)
        val view = binding.root
        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        mItemViewModel = ViewModelProvider(this).get(ItemViewModel::class.java)
        binding.addBtn.setOnClickListener {
            insertDataToDatabase()
        }
        return view
    }
    private fun insertDataToDatabase() {
        val productNames = binding.productNameEdt.text.toString()
        val price = binding.priceEdt.text.toString()
        val quantity = binding.quantityEdt.text.toString()
        val totalQuantity = Integer.parseInt(quantity)
        val totalPrice = totalQuantity * Integer.parseInt(price)

        sharedViewModel.totalPrice.value = totalPrice
        sharedViewModel.productName.value = productNames
        sharedViewModel.quantity.value = totalQuantity

        try {
            if (inputCheck(productNames, price, quantity)) {
                val item = Item(
                    0,
                    productNames,
                    totalPrice,
                    totalQuantity
                )
                mItemViewModel.addItem(item)
                Toast.makeText(requireContext(), "Successfully added", Toast.LENGTH_LONG).show()
                findNavController().navigate(R.id.action_addFragment_to_listFragment)
            }
        } catch (e: Exception) {
            Toast.makeText(requireContext(), "Please fill all the fields", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(productName: String, price: String, quantity: String): Boolean {
        return !(TextUtils.isEmpty(productName) || price.isEmpty() || quantity.isEmpty())
    }
}
