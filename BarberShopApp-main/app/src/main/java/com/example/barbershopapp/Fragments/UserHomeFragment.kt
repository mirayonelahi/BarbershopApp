package com.example.barbershopapp.Fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.barbershopapp.R
import com.example.barbershopapp.databinding.UserHomeFragmentBinding

class UserHomeFragment : Fragment() {

    private lateinit var binding: UserHomeFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = UserHomeFragmentBinding.inflate(inflater, container, false)
        binding.buttonGetAll.setOnClickListener {
            findNavController().navigate(R.id.action_userHomeFragment_to_allBarberFragment)
        }
        binding.buttonPricing.setOnClickListener {
            findNavController().navigate(R.id.action_userHomeFragment_to_pricingFragment)
        }
        binding.buttonAboutUs.setOnClickListener {
            findNavController().navigate(R.id.action_userHomeFragment_to_aboutUsFragment)
        }

        binding.buttonViewAppointment.setOnClickListener {
            findNavController().navigate(R.id.action_userHomeFragment_to_searchAppointmentFragment)
        }
        binding.buttonMessageUs.setOnClickListener {
            findNavController().navigate(R.id.action_userHomeFragment_to_messageUsFragment)
        }

        return binding.root
    }


}