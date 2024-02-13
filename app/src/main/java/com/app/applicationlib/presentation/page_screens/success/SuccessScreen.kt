package com.app.applicationlib.presentation.page_screens.success

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.app.applicationlib.R
import com.app.applicationlib.di.user.FirebaseUserUtils
import com.app.applicationlib.presentation.route.DestinationScreens
import com.app.applicationlib.presentation.util.bottomappbar.BottomNavigationBar

@Composable
fun SuccessScreen(
    navController: NavController,
    viewModel : SuccessViewModel =  hiltViewModel()
){
    viewModel.currentUser?.let {
        FirebaseUserUtils.initialize(firebaseUser = it)
    }
    navController.navigate(DestinationScreens.Home.route)
}
