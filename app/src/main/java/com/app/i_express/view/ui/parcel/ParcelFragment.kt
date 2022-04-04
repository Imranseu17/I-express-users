package com.app.i_express.view.ui.parcel

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.i_express.databinding.FragmentParcelBinding
import com.app.i_express.view.adapter.AdapterParcel
import com.app.i_express.viewmodel.DataViewModel

class ParcelFragment : Fragment() {

    private lateinit var dataViewModel: DataViewModel
    private var _binding: FragmentParcelBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataViewModel =
            ViewModelProvider(this).get(DataViewModel::class.java)

        _binding = FragmentParcelBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvParcel.adapter = AdapterParcel(requireContext())
        binding.rvParcel.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvParcel.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                LinearLayoutManager.VERTICAL
            )
        )

        binding.fabCreateParcel.setOnClickListener {
            CreateParcel().show(requireActivity().supportFragmentManager, "PickAreaFragment")
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}