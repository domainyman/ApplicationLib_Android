package com.app.applicationlib.presentation.route

sealed class DestinationScreens (val route:String){
    object Main : DestinationScreens("main")
    object Signup : DestinationScreens("signup")
    object Login : DestinationScreens("login")
    object Success : DestinationScreens("success")
    object Home : DestinationScreens("home")
    object Package : DestinationScreens("package")
    object Setting : DestinationScreens("setting")
}