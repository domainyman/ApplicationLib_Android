package com.app.applicationlib.presentation.page_screens.login_screen

data class LogInState(
    val isLoading : Boolean = false,
    val isSuccess :String? ="",
    val isError :String? =""
)