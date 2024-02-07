package com.app.applicationlib.presentation.main_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.applicationlib.presentation.login_screen.SignInState
import com.app.applicationlib.views.DestinationScreens
import com.app.applicationlib.views.repository.AuthRepository
import com.app.applicationlib.views.util.Resource
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: AuthRepository): ViewModel(){

    val _userInfo = Channel<MainState>()
    val userInfo = _userInfo.receiveAsFlow()

    fun getcurrentUser() = viewModelScope.launch {
        repository.getCurrentUser().collect{result ->
            when(result){
                is Resource.Success ->{
                    _userInfo.send(MainState(isSuccess = "Login Success"))
                }
                is Resource.Loading ->{
                    _userInfo.send(MainState(isLoading = true))
                }
                is Resource.Error ->{
                    _userInfo.send(MainState(isError = result.message))
                }
            }
        }
    }

}

