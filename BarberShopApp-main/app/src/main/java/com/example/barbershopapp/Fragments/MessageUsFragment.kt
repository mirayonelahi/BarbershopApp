package com.example.barbershopapp.Fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.barbershopapp.Entities.AddMessage
import com.example.barbershopapp.Entities.GetSingleBarber
import com.example.barbershopapp.Models.MessageUsViewModel
import com.example.barbershopapp.R
import com.example.barbershopapp.databinding.MessageUsFragmentBinding

class MessageUsFragment : Fragment() {

    private lateinit var binding: MessageUsFragmentBinding
    private lateinit var viewModel: MessageUsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(MessageUsViewModel::class.java)
        binding =  MessageUsFragmentBinding.inflate(inflater,container, false)


        binding.buttonSubmit.setOnClickListener {
            val userEmail = binding.editTextTextEmail.text.toString()
            val userMessage = binding.editTextTextMultiLine.text.toString()

            val messageBody = AddMessage(userEmail, userMessage)

            viewModel.makeAPICallAddAppointment(messageBody)

            findNavController().navigate(R.id.action_messageUsFragment_to_userHomeFragment)
        }



        return binding.root
    }


}