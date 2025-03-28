package com.example.crudpersonas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.crudpersonas.ui.theme.CrudPersonasTheme
import com.example.crudpersonas.views.ViewListadoPersonas
import com.example.crudpersonas.views.ViewLogin
import com.example.crudpersonas.vm.VMListadoPersonas
import com.example.crudpersonas.vm.VMLogin
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            CrudPersonasTheme {
                NavHost(
                    navController = navController,
                    startDestination = "login"
                ) {
                    // Pantalla Login (con Hilt)
                    composable(route = "login") {
                        val vm: VMLogin = hiltViewModel() // ViewModel con inyección
                        ViewLogin(vm, navController)
                    }

                    composable(route="listado_personas") { ViewListadoPersonas(VMListadoPersonas(), navController) }
                }
            }
        }
    }
}
