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
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import coil.compose.AsyncImage
import com.example.crudpersonas.dto.DTOPersona
import com.example.crudpersonas.vm.VMListadoPersonas
import java.time.LocalDateTime

@Composable
fun ViewListadoPersonas(viewModel: VMListadoPersonas){

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* Acción del FAB */ },
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Text("+") // Puedes cambiarlo por un ícono
            }
        }
    ) { paddingValues ->
        Box(
            Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color.Black),
        ) {
            CrudPersonas(viewModel)
        }
    }
}


@Composable
fun CrudPersonas(viewModel: VMListadoPersonas) {

    val listaPersonas :List<DTOPersona> = viewModel.ListaPersonas.observeAsState().value ?: emptyList()

    LazyColumn {
        items(listaPersonas) { persona ->
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






