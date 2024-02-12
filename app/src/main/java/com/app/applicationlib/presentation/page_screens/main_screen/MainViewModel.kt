package com.app.applicationlib.presentation.page_screens.main_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.applicationlib.data.repository.AuthRepository
import com.app.applicationlib.di.resource.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: AuthRepository
): ViewModel(){

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

