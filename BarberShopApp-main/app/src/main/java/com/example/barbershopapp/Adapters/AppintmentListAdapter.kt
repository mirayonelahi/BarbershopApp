package com.example.barbershopapp.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.barbershopapp.Entities.Appointment
import com.example.barbershopapp.Entities.GetAllAppointment
import com.example.barbershopapp.Entities.GetAllBarberItem
import com.example.barbershopapp.R
import com.example.barbershopapp.databinding.SingleAppointmentBinding
import com.example.barbershopapp.databinding.SingleBarberBinding

class AppintmentListAdapter(private val notesList: GetAllAppointment) :
    RecyclerView.Adapter<AppintmentListAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val binding = SingleAppointmentBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.single_appointment, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = notesList.appointment.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = notesList.appointment[position]
        with(holder.binding) {
            textViewCustomerName.text = note.name
            textViewCustomerContact.text = note.contact
            textViewAppointmentTime.text = note.datetime
            if (note.payment == "Paid") {
                imageView.setImageResource(R.drawable.ic_paid_24)
            } else imageView.setImageResource(R.drawable.ic_unpaid_24)
            textViewPaymentStatus.text = note.payment

        }
    }

}