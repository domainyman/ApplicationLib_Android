package com.app.applicationlib.presentation.route

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.applicationlib.presentation.content_screen.home_screen.HomeScreen
import com.app.applicationlib.presentation.content_screen.home_screen.HomeViewModel
import com.app.applicationlib.presentation.content_screen.package_screen.PackageScreen
import com.app.applicationlib.presentation.content_screen.package_screen.PackageViewModel
import com.app.applicationlib.presentation.content_screen.setting_screen.SettingScreen
import com.app.applicationlib.presentation.content_screen.setting_screen.SettingViewModel
import com.app.applicationlib.presentation.page_screens.login_screen.LogInViewModel
import com.app.applicationlib.presentation.page_screens.login_screen.LoginScreen
import com.app.applicationlib.presentation.page_screens.main_screen.MainScreen
import com.app.applicationlib.presentation.page_screens.signup_screen.SignupScreen
import com.app.applicationlib.presentation.page_screens.success.SuccessScreen
import com.app.applicationlib.presentation.page_screens.main_screen.MainViewModel
import com.app.applicationlib.presentation.page_screens.signup_screen.SignUpViewModel
import com.app.applicationlib.presentation.page_screens.success.SuccessViewModel


@Composable
fun AppLibNavControllerRoute() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = DestinationScreens.Main.route){
        composable(DestinationScreens.Main.route){
            MainScreen(navController = navController, viewModel = hiltViewModel<MainViewModel>())
        }
        composable(DestinationScreens.Signup.route){
            SignupScreen(navController = navController, viewModel = hiltViewModel<SignUpViewModel>())
        }
        composable(DestinationScreens.Login.route){
            LoginScreen(navController = navController, viewModel = hiltViewModel<LogInViewModel>())
        }
        composable(DestinationScreens.Success.route){
            SuccessScreen(navController = navController, viewModel = hiltViewModel<SuccessViewModel>())
        }
        composable(DestinationScreens.Home.route){
            HomeScreen(navController = navController, viewModel = hiltViewModel<HomeViewModel>())
        }
        composable(DestinationScreens.Package.route){
            PackageScreen(navController = navController, viewModel = hiltViewModel<PackageViewModel>())
        }
        composable(DestinationScreens.Setting.route){
            SettingScreen(navController = navController, viewModel = hiltViewModel<SettingViewModel>())
        }
    }
}