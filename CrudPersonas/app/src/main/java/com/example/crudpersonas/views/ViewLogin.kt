package com.example.crudpersonas.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.crudpersonas.vm.VMLogin

@Composable
fun ViewLogin(vm: VMLogin, navController: NavHostController){
    Box(){
        LoginScreen(vm, navController)
    }
}

@Composable
fun LoginScreen(vm: VMLogin, navController: NavHostController) {
    val context = LocalContext.current
    val email by vm.Email.observeAsState("")
    val password by vm.Password.observeAsState("")
    var isPasswordVisible = vm.EsPasswordVisible.observeAsState().value ?: false

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Login", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        EmailField(email, {vm.OnLoginChanged(it, password)})

        Spacer(modifier = Modifier.height(8.dp))

        PasswordField(password, {vm.OnLoginChanged(email, it)},isPasswordVisible)

        Spacer(modifier = Modifier.height(16.dp))

        BtnLogin(vm ,email, password, navController)

        Spacer(modifier = Modifier.height(8.dp))
    }
}


@Composable
fun BtnLogin(vm: VMLogin, email: String, password: String, navController: NavHostController){
    Button(
        onClick = { /*TODO*/},
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("Login")
    }

}
@Composable
fun EmailField(email: String, onTextChanged: (String) -> Unit){

    OutlinedTextField(
        value = email,
        onValueChange = {onTextChanged(it)},
        label = { Text("Username") },
        modifier = Modifier.fillMaxWidth()
    )
}
@Composable
fun PasswordField(password: String, onTextChanged: (String) -> Unit, isPasswordVisible: Boolean){
    OutlinedTextField(
        value = password,
        onValueChange =  {onTextChanged(it)},
        label = { Text("Password") },
        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions.Default,
        modifier = Modifier.fillMaxWidth()
    )

}