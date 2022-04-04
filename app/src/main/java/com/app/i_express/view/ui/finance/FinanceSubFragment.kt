package com.app.i_express.view.ui.finance

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.i_express.R
import com.app.i_express.databinding.FragmentFinanceMainBinding
import com.app.i_express.databinding.FragmentFinanceSubBinding
import com.app.i_express.view.adapter.ARG_OBJECT
import com.app.i_express.view.adapter.AdapterFinance
import com.app.i_express.view.adapter.AdapterNotification
import com.app.i_express.viewmodel.DataViewModel

class FinanceSubFragment : Fragment() {

    private lateinit var dataViewModel: DataViewModel
    private var _binding: FragmentFinanceSubBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    // TODO: Rename and change types of parameters
    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_OBJECT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        dataViewModel =
            ViewModelProvider(this).get(DataViewModel::class.java)

        _binding = FragmentFinanceSubBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvFinance.adapter = AdapterFinance(requireContext())
        binding.rvFinance.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvFinance.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                LinearLayoutManager.VERTICAL
            )
        )

    }

    companion object {
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FinanceSubFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_OBJECT, param1)
                }
            }
    }
}