package com.example.barbershopapp.Fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.barbershopapp.databinding.SearchAppointmentFragmentBinding

class SearchAppointmentFragment : Fragment() {


    private lateinit var binding: SearchAppointmentFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SearchAppointmentFragmentBinding.inflate(inflater, container, false)

        binding.buttonShowAppointment.setOnClickListener {
            var searchContact = binding.editTextSearchContact.text.toString()
            val action =
                SearchAppointmentFragmentDirections.actionSearchAppointmentFragmentToViewAppointmentFragment(
                    searchContact
                )
            findNavController().navigate(action)
        }
        return binding.root
    }


}