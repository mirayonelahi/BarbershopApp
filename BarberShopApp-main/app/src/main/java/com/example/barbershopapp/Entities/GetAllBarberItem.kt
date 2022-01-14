package com.example.barbershopapp.Entities

data class GetAllBarberItem(
    val _id: Id,
    val appointment: List<Appointment>?,
    val contact: String,
    val email: String,
    val name: String
)