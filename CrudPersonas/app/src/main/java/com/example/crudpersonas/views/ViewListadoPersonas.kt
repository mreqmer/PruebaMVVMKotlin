package com.example.crudpersonas.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.crudpersonas.dto.DTOPersona
import java.time.LocalDateTime

@Preview(showBackground = true)
@Composable
fun ViewListadoPersonas(){

    Box(
        Modifier
            .fillMaxSize()
            .padding(20.dp)
            .background(Color.Black),
    ){
        CrudPersonas()
    }

}

@Composable
fun CrudPersonas() {
    LazyColumn {
        items(ListaPersonas()) { persona ->
            ItemPersona(persona)
        }
    }
}

@Composable
fun ItemPersona(persona: DTOPersona) {

    Row(
        Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically // Centra los elementos en el eje vertical
    ) {
        AsyncImage(
            model = persona.foto,
            contentDescription = persona.nombre,
            modifier = Modifier
                .height(80.dp)
                .width(80.dp)
        )

        Column(
            Modifier
                .padding(start = 16.dp) // Espaciado entre la imagen y el texto
        ) {
            Text(text = "${persona.nombre} ${persona.apellidos}")
            Text(text = persona.direccion)
            Text(text = persona.telefono)
            Text(text = persona.fechaNacimiento.toString())
            Text(text = persona.idDepartamento.toString())
        }

    }

}

fun ListaPersonas() : List<DTOPersona> {
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




