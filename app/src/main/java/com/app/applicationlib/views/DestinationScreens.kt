package com.app.applicationlib.views

sealed class DestinationScreens (val route:String){
    object Main : DestinationScreens("main")
    object Signup : DestinationScreens("signup")
    object Login : DestinationScreens("login")
    object Success : DestinationScreens("success")
}