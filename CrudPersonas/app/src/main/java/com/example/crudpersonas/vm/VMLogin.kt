package com.example.crudpersonas.vm

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class VMLogin : ViewModel() {

    private val email : MutableLiveData<String> = MutableLiveData("")
    private val password : MutableLiveData<String> = MutableLiveData("")
    private val esPasswordVisible : MutableLiveData<Boolean> = MutableLiveData(false)


    public val Email : MutableLiveData<String> = email
    public val Password : MutableLiveData<String> = password
    public val EsPasswordVisible : MutableLiveData<Boolean> = esPasswordVisible


    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    private val _user = MutableStateFlow<FirebaseUser?>(null)
    val user: StateFlow<FirebaseUser?> = _user

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    init {
    }

    fun OnLoginChanged(email: String, password: String){
        this.email.value = email
        this.password.value = password
    }

    fun signIn(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                viewModelScope.launch {
                    if (task.isSuccessful) {
                        Log.d("FirebaseAuth", "signInWithEmail:success")
                        _user.value = auth.currentUser
                    } else {
                        Log.w("FirebaseAuth", "signInWithEmail:failure", task.exception)
                        _error.value = "Error: ${task.exception?.message}"
                    }
                }
            }
    }


    //Patterns.EMAIL_ADDRESS.matcher(email).matches()

}