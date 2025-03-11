package com.example.crudpersonas.dto

import java.time.LocalDateTime

data class DTOPersona(
    val id: Int = 0,
    val nombre: String = "",
    val apellidos: String = "",
    val telefono: String = "",
    val direccion: String ="",
    val foto: String = "",
    val fechaNacimiento: LocalDateTime = LocalDateTime.of(1900, 1, 1, 0, 0),
    val idDepartamento: Int = 0){
}
