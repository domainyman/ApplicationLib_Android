package com.app.applicationlib.presentation.content_screen.package_screen

import androidx.lifecycle.ViewModel
import com.app.applicationlib.data.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PackageViewModel @Inject constructor(
    private val repository: AuthRepository
): ViewModel(){


}