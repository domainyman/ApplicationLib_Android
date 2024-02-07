package com.app.applicationlib.presentation.success

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.applicationlib.presentation.signup_screen.SignUpState
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
class SuccessViewModel @Inject constructor(private val repository: AuthRepository): ViewModel(){
    val _successstate = Channel<SuccessState>()
    val successState = _successstate.receiveAsFlow()

    val currentUser: FirebaseUser?
        get() = repository.currentUser
}