package com.app.applicationlib.presentation.content_screen.setting_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.applicationlib.views.repository.AuthRepository
import com.app.applicationlib.views.util.Resource
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(
    private val repository: AuthRepository): ViewModel(){

    fun logout() {
        repository.logOutUser()
    }
}