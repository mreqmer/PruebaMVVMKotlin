package com.example.crudpersonas.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun prueba(){
    Column(
        Modifier.fillMaxSize().padding(16.dp)

    ){
        Text(text = "Hola")
    }
}