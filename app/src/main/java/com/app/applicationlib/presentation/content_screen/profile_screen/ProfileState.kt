package com.app.applicationlib.presentation.content_screen.profile_screen

data class ProfileState(
    val isLoading : Boolean = false,
    val isSuccess :String? ="",
    val isError :String? =""
)