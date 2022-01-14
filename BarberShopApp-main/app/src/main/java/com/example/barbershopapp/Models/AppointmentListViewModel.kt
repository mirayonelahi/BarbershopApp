package com.example.barbershopapp.Models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.barbershopapp.Entities.Appointment
import com.example.barbershopapp.Entities.GetAllAppointment
import com.example.barbershopapp.Entities.GetAllBarberItem
import com.example.barbershopapp.retrofit.RetroInstance
import com.example.barbershopapp.retrofit.RetroServiceInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AppointmentListViewModel : ViewModel() {
    lateinit var liveDataList: MutableLiveData<GetAllAppointment?>

    init {
        liveDataList = MutableLiveData()
    }


    fun getLiveDataObserver(): MutableLiveData<GetAllAppointment?> {
        return liveDataList
    }

    fun makeAPICall(id: String) {
        val retroInstance = RetroInstance.getRetroInstance()
        val retroService = retroInstance.create(RetroServiceInterface::class.java)
        val call = retroService.getSingleAppointment(id)
        call.enqueue(object : Callback<GetAllAppointment> {
            override fun onFailure(call: Call<GetAllAppointment>, t: Throwable) {
                liveDataList.postValue(null)
            }

            override fun onResponse(
                call: Call<GetAllAppointment>,
                response: Response<GetAllAppointment>
            ) {
                liveDataList?.postValue(response.body())
            }
        })


    }
}