package com.app.applicationlib.presentation.success

data class SuccessState(
    val isLoading : Boolean = false,
    val isSuccess :String? ="",
    val isError :String? =""
)