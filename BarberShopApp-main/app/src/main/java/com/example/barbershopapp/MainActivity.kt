package com.example.barbershopapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getDelegate().setLocalNightMode(
            AppCompatDelegate.MODE_NIGHT_YES
        );
        setContentView(R.layout.activity_main)


    }
}