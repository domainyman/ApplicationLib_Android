package com.app.applicationlib.presentation.page_screens.success

import androidx.lifecycle.ViewModel
import com.app.applicationlib.data.repository.AuthRepository
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

@HiltViewModel
class SuccessViewModel @Inject constructor(private val repository: AuthRepository): ViewModel(){
    val _successstate = Channel<SuccessState>()
    val successState = _successstate.receiveAsFlow()

    val currentUser: FirebaseUser?
        get() = repository.currentUser
}