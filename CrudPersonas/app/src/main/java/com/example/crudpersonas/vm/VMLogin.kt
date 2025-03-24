package com.example.crudpersonas.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class VMLogin : ViewModel() {

    private val email : MutableLiveData<String> = MutableLiveData("")
    private val password : MutableLiveData<String> = MutableLiveData("")
    private val esPasswordVisible : MutableLiveData<Boolean> = MutableLiveData(false)

    public val Email : MutableLiveData<String> = email
    public val Password : MutableLiveData<String> = password
    public val EsPasswordVisible : MutableLiveData<Boolean> = esPasswordVisible

    init {
    }

    fun OnLoginChanged(email: String, password: String){
        this.email.value = email
        this.password.value = password
    }

    //Patterns.EMAIL_ADDRESS.matcher(email).matches()
}