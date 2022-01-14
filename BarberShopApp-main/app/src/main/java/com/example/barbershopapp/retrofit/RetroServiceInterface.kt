package com.example.barbershopapp.retrofit


import com.example.barbershopapp.Entities.*
import retrofit2.Call
import retrofit2.http.*

interface RetroServiceInterface {

    @GET("getAll")
    fun getAllBarberlist(): Call<List<GetAllBarberItem>>

    @GET("getSingle/{id}")
    fun getSingleBarber(
        @Path("id") id: String
    ): Call<GetAllBarberItem>

    @GET("getSingleAppointment/{id}")
    fun getSingleAppointment(
        @Path("id") id: String
    ): Call<GetAllAppointment>

    @GET("getSingleAppointmentByContact/{id}")
    fun getSingleAppointmentByContact(
        @Path("id") id: String
    ): Call<List<GetSingleAppointmentByContact>>

    @PUT("update/{id}")
    fun updateSingleBarber(
        @Path("id") id: String
    ): Call<GetAllBarberItem>

    @POST("add")
    @Headers("Accept:application/json", "Content-Type:application/json")
    fun addSingleBarber(@Body params: GetSingleBarber): Call<Any>

    @POST("messageus")
    @Headers("Accept:application/json", "Content-Type:application/json")
    fun addMessage(@Body params: AddMessage): Call<Any>

    @PATCH("patch/{id}")
    @Headers("Accept:application/json", "Content-Type:application/json")
    fun addAppointment(@Path("id") id: String, @Body params: GetSingleAppointment): Call<Any>

}