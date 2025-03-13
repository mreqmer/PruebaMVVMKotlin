package com.example.crudpersonas.api

import com.example.crudpersonas.dto.DTOPersona
import retrofit2.Response
import retrofit2.http.GET

interface PersonasAPI {

    @GET("personas")
    suspend fun getPersonas(): Response<List<DTOPersona>>

}