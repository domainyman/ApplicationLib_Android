package com.app.applicationlib.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(val auth:FirebaseAuth):ViewModel(){

    val signedIn = mutableStateOf(false)
    val inProcess = mutableStateOf(false)
    val popupNotification = mutableStateOf(false)

    fun onSignup(email:String,password:String){
        inProcess.value = true

        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener {
                if(it.isSuccessful){
                    signedIn.value = true
                } else{

                }
                inProcess.value = false
            }
    }

    fun login(email: String,password: String){
        inProcess.value = true

        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener {
                if(it.isSuccessful){
                    signedIn.value = true
                }else {

                }
                inProcess.value = false
            }
    }
}