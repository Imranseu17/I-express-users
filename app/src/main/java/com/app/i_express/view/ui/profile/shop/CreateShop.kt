package com.app.i_express.view.ui.profile.shop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.app.i_express.R
import com.app.i_express.databinding.FragmentCreateShopBinding

class CreateShop : DialogFragment() {

    private var _binding: FragmentCreateShopBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NORMAL, R.style.Theme_Iexpress_FullScreenDialog);
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreateShopBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbarClose.setOnClickListener {
            this.dismiss()
        }

        binding.btnCreateShop.setOnClickListener {
            this.dismiss()
        }

    }
}