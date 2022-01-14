package com.example.barbershopapp.Fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.barbershopapp.Entities.GetSingleBarber
import com.example.barbershopapp.Models.AdminAddBarberViewModel
import com.example.barbershopapp.R
import com.example.barbershopapp.databinding.AdminAddBarberFragmentBinding

class AdminAddBarberFragment : Fragment() {

    private lateinit var viewModel: AdminAddBarberViewModel
    private lateinit var binding: AdminAddBarberFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AdminAddBarberFragmentBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(AdminAddBarberViewModel::class.java)


        binding.buttonAddBarber.setOnClickListener {
            val barberName = binding.editTextTextBarberName.text.toString()
            val barberContact = binding.editTextTextBarberContact.text.toString()
            val barberEmail = binding.editTextBarberEmail.text.toString()

            val singleBarberBody = GetSingleBarber(barberName, barberEmail, barberContact)

            viewModel.makeAPICallAddAppointment(singleBarberBody)

            findNavController().navigate(R.id.action_adminAddBarberFragment_to_userHomeFragment)
        }

        return binding.root
    }


}