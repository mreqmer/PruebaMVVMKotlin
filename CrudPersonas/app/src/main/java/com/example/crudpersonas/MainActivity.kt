package com.example.crudpersonas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.crudpersonas.ui.theme.CrudPersonasTheme
import com.example.crudpersonas.views.ViewListadoPersonas
import com.example.crudpersonas.vm.VMListadoPersonas

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            CrudPersonasTheme {
                NavHost(
                    navController = navController,
                    startDestination = "listado_personas"
                ) {
                    composable(route="listado_personas") { ViewListadoPersonas(VMListadoPersonas(), navController) }
                    //composable(route="nueva_persona") { ViewNuevaPersona(VMListadoPersonas(), navController) }
            }
        }
    }
}
}