package com.app.i_express.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.app.i_express.databinding.FragmentDashboardBinding
import com.app.i_express.view.ui.parcel.CreateParcel
import com.app.i_express.viewmodel.DataViewModel

class DashboardFragment : Fragment() {

    private lateinit var dataViewModel: DataViewModel
    private var _binding: FragmentDashboardBinding? = null

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

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fabCreateParcel.setOnClickListener {
            Toast.makeText(requireContext(), "under development", Toast.LENGTH_SHORT).show()
        }

        binding.fabCreateParcel.setOnClickListener {
            CreateParcel().show(requireActivity().supportFragmentManager, "PickAreaFragment")
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}