package com.app.applicationlib.presentation.main_screen

data class MainState (
    val isLoading : Boolean = false,
    val isSuccess :String? ="",
    val isError :String? =""
)