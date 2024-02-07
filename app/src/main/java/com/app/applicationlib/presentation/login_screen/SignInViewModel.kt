package com.app.applicationlib.presentation.login_screen


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.applicationlib.views.repository.AuthRepository
import com.app.applicationlib.views.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val repository: AuthRepository):ViewModel(){

    val _signInstate = Channel<SignInState>()
    val signInState = _signInstate.receiveAsFlow()

    fun loginUser(email:String,password:String) = viewModelScope.launch {
        repository.loginUser(email,password).collect{result ->
            when(result){
                is Resource.Success ->{
                    _signInstate.send(SignInState(isSuccess = "Sign In Success"))
                }
                is Resource.Loading ->{
                    _signInstate.send(SignInState(isLoading = true))
                }
                is Resource.Error ->{
                    _signInstate.send(SignInState(isError = result.message))
                }
            }
        }
    }

}