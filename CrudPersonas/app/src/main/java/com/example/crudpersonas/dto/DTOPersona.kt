package com.example.crudpersonas.dto

import java.time.LocalDateTime

data class DTOPersona(
    val id: Int = 0,
    val nombre: String = "",
    val apellidos: String = "",
    val telefono: String = "",
    val direccion: String ="",
    val foto: String = "",
    val fechaNacimiento: String = "",
    val idDepartamento: Int = 0){
}
