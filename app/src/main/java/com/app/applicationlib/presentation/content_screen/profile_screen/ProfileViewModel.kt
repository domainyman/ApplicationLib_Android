package com.app.applicationlib.presentation.content_screen.profile_screen

import androidx.lifecycle.ViewModel
import com.app.applicationlib.views.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val repository: AuthRepository
): ViewModel(){


}