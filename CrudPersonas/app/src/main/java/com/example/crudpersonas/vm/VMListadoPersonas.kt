package com.example.crudpersonas.vm

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.crudpersonas.api.RetrofitInstance
import com.example.crudpersonas.dto.DTOPersona
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.LocalDateTime

class VMListadoPersonas : ViewModel() {

    //region Propiedades
    private val personasApi = RetrofitInstance.personasAPI
    private val listaPersonas = MutableLiveData<List<DTOPersona>>()
    private val personaSeleccionada = MutableLiveData<DTOPersona>()
    private val cargando = MutableLiveData<Boolean>()
    //endregion

    //region Atributos
    public val ListaPersonas : MutableLiveData<List<DTOPersona>> = listaPersonas
    public val PersonaSeleccionada : MutableLiveData<DTOPersona> = personaSeleccionada
    public val Cargando: MutableLiveData<Boolean> = cargando
    //endregion

    //region Constructor
    init{

        cargaPersonas()
    }
    //endregion

    //region Metodos

    private fun cargaPersonas() {

        viewModelScope.launch {
            cargando.value = true
            try {
                val response = personasApi.getPersonas()
                if (response.isSuccessful) {
                    listaPersonas.postValue(response.body())
                    Log.i("OKAY", response.body().toString())
                    cargando.value = false
                } else {
                    Log.i("ERROR", "Error al cargar las personas")
                    cargando.value = false
                }
            } catch (e: Exception) {
                Log.i("ERROR", e.toString())
                cargando.value = false
            }
        }
    }

    //endregion

}