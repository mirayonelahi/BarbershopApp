package com.example.barbershopapp.Fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.barbershopapp.R
import com.example.barbershopapp.Models.ViewAppointmentViewModel
import com.example.barbershopapp.databinding.ViewAppointmentFragmentBinding

class ViewAppointmentFragment : Fragment() {

    private val args: ViewAppointmentFragmentArgs by navArgs()

    private lateinit var viewModel: ViewAppointmentViewModel
    private lateinit var binding: ViewAppointmentFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ViewAppointmentFragmentBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(ViewAppointmentViewModel::class.java)
        viewModel.makeAPICall(args.searchByContact)

        viewModel.liveDataList.observe(viewLifecycleOwner, {

            if (it != null) {
                if (it.size != 0) {
                    binding.textViewAppointmrnt.setText(
                        "Barber Name: " + it.get(0).name + "\n" +
                                "User Name: " + it[0].appointment[0].name + "\n" +
                                "User Contact: " + it[0].appointment[0].contact + "\n" +
                                "Appointment Time: " + it[0].appointment[0].datetime + "\n"
                    )

                } else {
                    binding.textViewAppointmrnt.setText("No Appointment Found")
                }
            }

        })



        return binding.root
    }


}