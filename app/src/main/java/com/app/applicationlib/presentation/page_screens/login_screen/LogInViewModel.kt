package com.app.applicationlib.presentation.page_screens.login_screen


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.applicationlib.data.repository.AuthRepository
import com.app.applicationlib.di.resource.Resource
import com.google.firebase.auth.AuthCredential
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LogInViewModel @Inject constructor(
    private val repository: AuthRepository
):ViewModel(){

    val _logInstate = Channel<LogInState>()
    val logInState = _logInstate.receiveAsFlow()

    fun loginUser(email:String,password:String) = viewModelScope.launch {
        repository.loginUser(email,password).collect{result ->
            when(result){
                is Resource.Success ->{
                    _logInstate.send(LogInState(isSuccess = "Sign In Success"))
                }
                is Resource.Loading ->{
                    _logInstate.send(LogInState(isLoading = true))
                }
                is Resource.Error ->{
                    _logInstate.send(LogInState(isError = result.message))
                }
            }
        }
    }

    fun firebaseAuthWithGoogle(credential: AuthCredential) = viewModelScope.launch {
        repository.firebaseSignInWithGoogle(credential).collect{result ->
            when(result){
                is Resource.Success ->{
                    _logInstate.send(LogInState(isSuccess = "Sign In Success"))
                }
                is Resource.Loading ->{
                    _logInstate.send(LogInState(isLoading = true))
                }
                is Resource.Error ->{
                    _logInstate.send(LogInState(isError = result.message))
                }
            }
        }
    }




}