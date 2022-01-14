package com.example.barbershopapp.Models

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.barbershopapp.Entities.GetSingleAppointment
import com.example.barbershopapp.Entities.GetSingleBarber
import com.example.barbershopapp.retrofit.RetroInstance
import com.example.barbershopapp.retrofit.RetroServiceInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AdminAddBarberViewModel : ViewModel() {

    fun makeAPICallAddAppointment(body: GetSingleBarber) {
        val retroInstance = RetroInstance.getRetroInstance()
        val retroService = retroInstance.create(RetroServiceInterface::class.java)
        val call = retroService.addSingleBarber(body)
        call.enqueue(object : Callback<Any> {
            override fun onFailure(call: Call<Any>, t: Throwable) {
                Log.i("failure add barber ", "failed")
            }

            override fun onResponse(
                call: Call<Any>,
                response: Response<Any>
            ) {
                Log.i("response add barber ", "aaaaa")
                // liveDataList?.postValue(response.body() as GetAllBarberItem?)
            }
        })


    }
}