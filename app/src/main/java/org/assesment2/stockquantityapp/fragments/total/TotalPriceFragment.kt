package org.assesment2.stockquantityapp.fragments.total

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import org.assesment2.stockquantityapp.R
import org.assesment2.stockquantityapp.databinding.FragmentTotalpriceBinding
import org.assesment2.stockquantityapp.viewmodel.SharedViewModel


class totalPriceFragment : Fragment() {
    private lateinit var binding: FragmentTotalpriceBinding
    private lateinit var sharedViewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTotalpriceBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        val view = binding.root

        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        val totalPrice = sharedViewModel.totalPrice.value

        binding.Hasiltotalnilai.text = totalPrice.toString()
        binding.bagikanBtn.setOnClickListener { shareData() }
        binding.bagikanBtn.visibility = View.VISIBLE
        return view
    }

    private fun shareData() {
        val totalPrice = binding.Hasiltotalnilai.text.toString()

        val message = getString(
            R.string.bagikan_template,
            sharedViewModel.productName.value,
            totalPrice
        )
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_TEXT, message)
        if (shareIntent.resolveActivity(requireActivity().packageManager) != null) {
            startActivity(shareIntent)
        }
    }
}