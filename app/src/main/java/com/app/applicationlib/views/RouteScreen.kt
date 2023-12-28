package com.app.applicationlib.views

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.applicationlib.Screen.LoginScreen
import com.app.applicationlib.Screen.MainScreen
import com.app.applicationlib.Screen.SignupScreen
import com.app.applicationlib.Screen.SuccessScreen
import com.app.applicationlib.ui.AppViewModel

@Composable
fun AppLibNavControllerRoute() {
    val viewModel = hiltViewModel<AppViewModel>()
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = DestinationScreens.Main.route){
        composable(DestinationScreens.Main.route){
            MainScreen(navController = navController, viewModel = viewModel)
        }
        composable(DestinationScreens.Signup.route){
            SignupScreen(navController = navController, viewModel = viewModel)
        }
        composable(DestinationScreens.Login.route){
            LoginScreen(navController = navController, viewModel = viewModel)
        }
        composable(DestinationScreens.Success.route){
            SuccessScreen(navController = navController, viewModel = viewModel)
        }
    }
}