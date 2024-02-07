package com.app.applicationlib.presentation.signup_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.app.applicationlib.presentation.signup_screen.SignUpState
import com.app.applicationlib.views.repository.AuthRepository
import com.app.applicationlib.views.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val repository: AuthRepository
): ViewModel(){

    val _signUpstate = Channel<SignUpState>()
    val signUpState = _signUpstate.receiveAsFlow()

    fun registerUser(email:String,password:String) = viewModelScope.launch {
        repository.registerUser(email,password).collect{result ->
            when(result){
                is Resource.Success ->{
                    _signUpstate.send(SignUpState(isSuccess = "Sign Up Success"))
                }
                is Resource.Loading ->{
                    _signUpstate.send(SignUpState(isLoading = true))
                }
                is Resource.Error ->{
                    _signUpstate.send(SignUpState(isError = result.message))
                }
            }
        }
    }


}