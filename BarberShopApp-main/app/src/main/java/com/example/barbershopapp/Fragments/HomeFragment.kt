package com.example.barbershopapp.Fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.barbershopapp.R
import com.example.barbershopapp.databinding.HomeFragmentBinding
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : Fragment() {

    private lateinit var binding: HomeFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomeFragmentBinding.inflate(inflater, container, false)
        binding.buttonUser.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_userHomeFragment)
        }
        binding.buttonAdmin.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_adminAddBarberFragment)
        }

        return binding.root
    }


}