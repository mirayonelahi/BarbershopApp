package com.example.barbershopapp.Models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.barbershopapp.Entities.GetAllBarberItem
import com.example.barbershopapp.retrofit.RetroInstance
import com.example.barbershopapp.retrofit.RetroServiceInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AllBarberViewModel : ViewModel() {

    lateinit var liveDataList: MutableLiveData<List<GetAllBarberItem>?>

    init {
        liveDataList = MutableLiveData()
    }


    fun getLiveDataObserver(): MutableLiveData<List<GetAllBarberItem>?> {
        return liveDataList
    }

    fun makeAPICall() {
        val retroInstance = RetroInstance.getRetroInstance()
        val retroService = retroInstance.create(RetroServiceInterface::class.java)
        val call = retroService.getAllBarberlist()
        call.enqueue(object : Callback<List<GetAllBarberItem>> {
            override fun onFailure(call: Call<List<GetAllBarberItem>>, t: Throwable) {
                liveDataList.postValue(null)
            }

            override fun onResponse(
                call: Call<List<GetAllBarberItem>>,
                response: Response<List<GetAllBarberItem>>
            ) {
                liveDataList.postValue(response.body())
            }
        })


    }

}