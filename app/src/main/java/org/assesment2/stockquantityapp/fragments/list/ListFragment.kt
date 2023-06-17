package org.assesment2.stockquantityapp.fragments.list

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
<<<<<<< HEAD
import org.assesment2.stockquantityapp.R
import org.assesment2.stockquantityapp.databinding.FragmentListBinding
=======
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.assesment2.stockquantityapp.R
>>>>>>> 5c6f7f2d07083d30287225b5301def476d446798
import org.assesment2.stockquantityapp.viewmodel.ItemViewModel

class ListFragment : Fragment() {

<<<<<<< HEAD
    private lateinit var binding: FragmentListBinding
    private lateinit var mItemViewModel: ItemViewModel
=======
    private lateinit var mItemViewModel : ItemViewModel
>>>>>>> 5c6f7f2d07083d30287225b5301def476d446798

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
<<<<<<< HEAD
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)
        val view = binding.root

        val adapter = ListAdapter()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        mItemViewModel = ViewModelProvider(this).get(ItemViewModel::class.java)
        mItemViewModel.readAllData.observe(viewLifecycleOwner, Observer { item ->
            adapter.setData(item)
        })

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        // Add menu
=======
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        val adapter = ListAdapter()
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        mItemViewModel = ViewModelProvider(this).get(ItemViewModel::class.java)
        mItemViewModel.readAllData.observe(viewLifecycleOwner, Observer {
                item -> adapter.setData(item)

        })

        view.findViewById<FloatingActionButton>(R.id.floatingActionButton).setOnClickListener{
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        //Add menu
>>>>>>> 5c6f7f2d07083d30287225b5301def476d446798
        setHasOptionsMenu(true)

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
<<<<<<< HEAD
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_delete) {
=======
        inflater.inflate(R.menu.delete_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if( item.itemId == R.id.menu_delete)
        {
>>>>>>> 5c6f7f2d07083d30287225b5301def476d446798
            deleteAllItems()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteAllItems() {
<<<<<<< HEAD
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _, _ ->
            mItemViewModel.deleteAllItem()
            Toast.makeText(requireContext(), "Successfully Deleted Everything", Toast.LENGTH_LONG).show()
        }
            builder.setNegativeButton("No") { _, _ ->
=======
        var builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes"){_,_ ->
            mItemViewModel.deleteAllItem()
            Toast.makeText(requireContext(),
                "Successfully Deleted Everything ",
                Toast.LENGTH_LONG).show()
        }

        builder.setNegativeButton("No"){_,_ ->

>>>>>>> 5c6f7f2d07083d30287225b5301def476d446798
        }
        builder.setTitle("Delete everything?")
        builder.setMessage("Are you sure you want to delete everything?")
        builder.create().show()
    }
<<<<<<< HEAD
}
=======


}
>>>>>>> 5c6f7f2d07083d30287225b5301def476d446798
