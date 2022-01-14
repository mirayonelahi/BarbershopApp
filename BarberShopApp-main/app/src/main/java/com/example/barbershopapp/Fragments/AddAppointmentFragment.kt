package com.example.barbershopapp.Fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.barbershopapp.Entities.Appointment
import com.example.barbershopapp.Entities.GetSingleAppointment
import com.example.barbershopapp.Models.AddAppointmentViewModel
import com.example.barbershopapp.databinding.AddAppointmentFragmentBinding
import kotlinx.android.synthetic.main.add_appointment_fragment.*

class AddAppointmentFragment : Fragment() {

    private val args: AddAppointmentFragmentArgs by navArgs()
    private lateinit var binding: AddAppointmentFragmentBinding
    private lateinit var viewModel: AddAppointmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AddAppointmentFragmentBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(AddAppointmentViewModel::class.java)
        var barberName:String ="X";
        viewModel.makeAPICall(args.selectedData)

        viewModel.liveDataList.observe(viewLifecycleOwner, {
            if (it != null) {
                binding.textViewBarberName.setText("Barber name: " + it.name)
                barberName=it.name
            }
        })


        binding.buttonAddAppointment.setOnClickListener {
            val paymentStatus: String
            if (binding.checkBoxPayment.isChecked)
                paymentStatus = "Paid"
            else
                paymentStatus = "Unpaid"

            val customerName = editTextTextCustomerName.text.toString()
            val customerContact = editTextTextCustomerContact.text.toString()
            val customerAppointment = editTextTimeOfAppointment.text.toString()
            val appointmentBody =
                Appointment(customerName, customerContact, customerAppointment, paymentStatus)
            val getSingleAppointment = GetSingleAppointment(appointmentBody)
            viewModel.makeAPICallAddAppointment(args.selectedData, getSingleAppointment)

            val action = AddAppointmentFragmentDirections.actionAddAppointmentFragmentToAppointmentListFragment(args.selectedData,barberName)
              findNavController().navigate(action)


        }


        return binding.root
    }


}

