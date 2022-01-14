package com.example.barbershopapp.Entities

data class GetSingleAppointmentByContact(
    val name: String,
    val appointment: List<Appointment>

)