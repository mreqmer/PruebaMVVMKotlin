package com.example.crudpersonas.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.crudpersonas.dto.DTOPersona
import java.time.LocalDateTime

class VMListadoPersonas : ViewModel() {

    //region Propiedades
    private val listaPersonas = MutableLiveData<List<DTOPersona>>()
    private val personaSeleccionada = MutableLiveData<DTOPersona>()
    //endregion

    //region Atributos
    public val ListaPersonas : MutableLiveData<List<DTOPersona>> = listaPersonas
    public val PersonaSeleccionada : MutableLiveData<DTOPersona> = personaSeleccionada
    //endregion

    //region Constructor
    init{
        listaPersonas.value = cargaPersonas()
    }
    //endregion

    //region Metodos

    private fun cargaPersonas() : List<DTOPersona> {
        val imageUrl = "https://thispersondoesnotexist.com/"
        //Lista temporal, hasta que luego se obtenga de la API
        return listOf(
            DTOPersona(1, "Juan", "Pérez", "123456789", "Calle Mayor 1", imageUrl, LocalDateTime.now(), 1),
            DTOPersona(2, "Ana", "García", "987654321", "Avenida Central 2", imageUrl, LocalDateTime.now(), 2),
            DTOPersona(3, "Carlos", "López", "654321987", "Plaza del Sol 3", imageUrl, LocalDateTime.now(), 3),
            DTOPersona(4, "María", "Martínez", "111222333", "Calle Luna 4", imageUrl, LocalDateTime.now(), 1),
            DTOPersona(5, "Pedro", "Rodríguez", "444555666", "Avenida Libertad 5", imageUrl, LocalDateTime.now(), 2),
            DTOPersona(6, "Laura", "Sánchez", "777888999", "Calle del Río 6", imageUrl, LocalDateTime.now(), 3),
            DTOPersona(7, "Javier", "Fernández", "999000111", "Plaza Mayor 7", imageUrl, LocalDateTime.now(), 1),
            DTOPersona(8, "Isabel", "Díaz", "222333444", "Calle Ancha 8", imageUrl, LocalDateTime.now(), 2),
            DTOPersona(9, "Miguel", "González", "555666777", "Avenida del Mar 9", imageUrl, LocalDateTime.now(), 3),
            DTOPersona(10, "Sofía", "Ruiz", "888999000", "Calle Estrecha 10", imageUrl, LocalDateTime.now(), 1)
        )
    }

    //endregion

}