package com.example.crudpersonas.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val baseUrl = "https://martaasp.azurewebsites.net/api/";

    private fun getInstance() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val personasAPI : PersonasAPI = getInstance().create(PersonasAPI::class.java)

}