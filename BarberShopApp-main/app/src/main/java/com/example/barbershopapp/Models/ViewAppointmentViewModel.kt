package com.example.barbershopapp.Models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.barbershopapp.Entities.GetAllAppointment
import com.example.barbershopapp.Entities.GetAllBarberItem
import com.example.barbershopapp.Entities.GetSingleAppointmentByContact
import com.example.barbershopapp.retrofit.RetroInstance
import com.example.barbershopapp.retrofit.RetroServiceInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewAppointmentViewModel : ViewModel() {
    lateinit var liveDataList: MutableLiveData<List<GetSingleAppointmentByContact>?>

    init {
        liveDataList = MutableLiveData()
    }


    fun makeAPICall(id: String) {
        val retroInstance = RetroInstance.getRetroInstance()
        val retroService = retroInstance.create(RetroServiceInterface::class.java)
        val call = retroService.getSingleAppointmentByContact(id)
        call.enqueue(object : Callback<List<GetSingleAppointmentByContact>> {
            override fun onFailure(call: Call<List<GetSingleAppointmentByContact>>, t: Throwable) {
                liveDataList.postValue(null)
            }

            override fun onResponse(
                call: Call<List<GetSingleAppointmentByContact>>,
                response: Response<List<GetSingleAppointmentByContact>>
            ) {
                liveDataList?.postValue(response.body())
            }
        })


    }
}