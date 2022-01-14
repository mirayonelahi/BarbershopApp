package com.example.barbershopapp.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.barbershopapp.Adapters.BarbersAdapter
import com.example.barbershopapp.Models.AllBarberViewModel
import com.example.barbershopapp.databinding.AllBarberFragmentBinding
import retrofit2.*

class AllBarberFragment : Fragment(), BarbersAdapter.ListItemListener {

    private lateinit var binding: AllBarberFragmentBinding
    private lateinit var viewModel: AllBarberViewModel
    private lateinit var adapter: BarbersAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(AllBarberViewModel::class.java)
        binding = AllBarberFragmentBinding.inflate(inflater, container, false)


        with(binding.recyclerView) {
            setHasFixedSize(true) // all rows would have a fix size regardless of its contents

            // to create a divider to separate each row
            val divider = DividerItemDecoration(context, LinearLayoutManager(context).orientation)
            addItemDecoration(divider)
        }

        viewModel.makeAPICall()
        viewModel.liveDataList.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                adapter = BarbersAdapter(it, this@AllBarberFragment)
                binding.recyclerView.adapter = adapter
                binding.recyclerView.layoutManager = LinearLayoutManager(activity)
            } else {
                Log.i("error", "no data found")
            }


        })



        return binding.root
    }

    override fun onItemClick(noteId: String) {
        val action =
            AllBarberFragmentDirections.actionAllBarberFragmentToAddAppointmentFragment(noteId)
        findNavController().navigate(action)
    }


}