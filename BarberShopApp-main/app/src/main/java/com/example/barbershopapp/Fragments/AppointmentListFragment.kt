package com.example.barbershopapp.Fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.barbershopapp.Adapters.AppintmentListAdapter
import com.example.barbershopapp.Adapters.BarbersAdapter
import com.example.barbershopapp.Models.AppointmentListViewModel
import com.example.barbershopapp.R
import com.example.barbershopapp.databinding.AppointmentListFragmentBinding

class AppointmentListFragment : Fragment() {

    private val args: AppointmentListFragmentArgs by navArgs()
    private lateinit var viewModel: AppointmentListViewModel
    private lateinit var binding: AppointmentListFragmentBinding
    private lateinit var adapter: AppintmentListAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AppointmentListFragmentBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(AppointmentListViewModel::class.java)
        val barberId = args.selectedBarberId
        viewModel.makeAPICall(barberId)
        var output = ""
        binding.textViewBarbername.setText(args.barberName)
        with(binding.recyclerViewAppoint) {
            setHasFixedSize(true) // all rows would have a fix size regardless of its contents

            // to create a divider to separate each row
            val divider = DividerItemDecoration(context, LinearLayoutManager(context).orientation)
            addItemDecoration(divider)
        }

        viewModel.liveDataList.observe(viewLifecycleOwner, {
            if (it != null) {

                adapter = AppintmentListAdapter(it)
                binding.recyclerViewAppoint.adapter = adapter
                binding.recyclerViewAppoint.layoutManager = LinearLayoutManager(activity)

            }
        })
        return binding.root
    }


}