package com.app.applicationlib.presentation.content_screen.home_screen

data class HomeState(
    val isLoading : Boolean = false,
    val isSuccess :String? ="",
    val isError :String? =""
)