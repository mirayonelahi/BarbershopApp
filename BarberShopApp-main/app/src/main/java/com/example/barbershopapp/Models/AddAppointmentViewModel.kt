package com.example.barbershopapp.Models

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.barbershopapp.Entities.Appointment
import com.example.barbershopapp.Entities.GetAllBarberItem
import com.example.barbershopapp.Entities.GetSingleAppointment
import com.example.barbershopapp.retrofit.RetroInstance
import com.example.barbershopapp.retrofit.RetroServiceInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddAppointmentViewModel : ViewModel() {
    lateinit var liveDataList: MutableLiveData<GetAllBarberItem?>

    init {
        liveDataList = MutableLiveData()
    }


    fun getLiveDataObserver(): MutableLiveData<GetAllBarberItem?>? {
        return liveDataList
    }

    fun makeAPICall(id: String) {
        val retroInstance = RetroInstance.getRetroInstance()
        val retroService = retroInstance.create(RetroServiceInterface::class.java)
        val call = retroService.getSingleBarber(id)
        call.enqueue(object : Callback<GetAllBarberItem> {
            override fun onFailure(call: Call<GetAllBarberItem>, t: Throwable) {
                liveDataList.postValue(null)
            }

            override fun onResponse(
                call: Call<GetAllBarberItem>,
                response: Response<GetAllBarberItem>
            ) {
                liveDataList?.postValue(response.body())
            }
        })


    }

    fun makeAPICallAddAppointment(id: String, body: GetSingleAppointment) {
        val retroInstance = RetroInstance.getRetroInstance()
        val retroService = retroInstance.create(RetroServiceInterface::class.java)
        val call = retroService.addAppointment(id, body)
        call.enqueue(object : Callback<Any> {
            override fun onFailure(call: Call<Any>, t: Throwable) {
                liveDataList.postValue(null)
            }

            override fun onResponse(
                call: Call<Any>,
                response: Response<Any>
            ) {
                Log.i("response ", response.body() as String)
                // liveDataList?.postValue(response.body() as GetAllBarberItem?)
            }
        })


    }
}