package com.app.i_express.view.ui.finance

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.app.i_express.R
import com.app.i_express.databinding.FragmentFinanceMainBinding
import com.app.i_express.view.adapter.ViewPagerAdapter
import com.app.i_express.viewmodel.DataViewModel
import com.google.android.material.tabs.TabLayoutMediator

class FinanceMainFragment : Fragment() {

    private lateinit var dataViewModel: DataViewModel
    private var _binding: FragmentFinanceMainBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        dataViewModel =
            ViewModelProvider(this).get(DataViewModel::class.java)

        _binding = FragmentFinanceMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list: MutableList<Any> = mutableListOf("Credit", "Payment")
        binding.viewPager.adapter = ViewPagerAdapter(this, list)

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = list.get(position).toString()
                    tab.icon = requireContext().getDrawable(R.drawable.ic_outline_attach_money_24)
                }
                1 -> {
                    tab.text = list.get(position).toString()
                    tab.icon = requireContext().getDrawable(R.drawable.ic_outline_payment_24)
                }
            }
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}