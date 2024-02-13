package com.app.applicationlib.presentation.content_screen.package_screen

data class PackageState(
    val isLoading : Boolean = false,
    val isSuccess :String? ="",
    val isError :String? =""
)