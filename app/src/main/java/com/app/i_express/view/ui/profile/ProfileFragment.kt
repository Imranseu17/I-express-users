package com.app.i_express.view.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.app.i_express.R
import com.app.i_express.databinding.FragmentProfileBinding
import com.app.i_express.view.adapter.ProfileViewPagerAdapter
import com.app.i_express.view.ui.profile.basic_info.BasicInfoFragment
import com.app.i_express.view.ui.profile.payment.PaymentFragment
import com.app.i_express.view.ui.profile.security.SecurityFragment
import com.app.i_express.viewmodel.DataViewModel
import com.google.android.material.tabs.TabLayoutMediator

class ProfileFragment : Fragment() {

    private lateinit var dataViewModel: DataViewModel
    private var _binding: FragmentProfileBinding? = null

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

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listTitle: List<Any> = listOf("Shop", "Basic info", "Security", "Payments")
        val listIcon: List<Int> = listOf(
            R.drawable.ic_outline_shopping_bag_24,
            R.drawable.ic_outline_person_24,
            R.drawable.ic_outline_security_24,
            R.drawable.ic_outline_payment_24
        )
        val listFragment : List<Fragment> = listOf(
            ShopFragment(),
            BasicInfoFragment(),
            SecurityFragment(),
            PaymentFragment()
        )
        binding.viewPager.adapter = ProfileViewPagerAdapter(this, listFragment)

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = listTitle.get(position).toString()
            tab.icon = requireContext().getDrawable(listIcon.get(position))

        }.attach()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}