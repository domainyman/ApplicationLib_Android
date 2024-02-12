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
import com.app.applicationlib.presentation.util.bottomappbar.BottomNavigationBar

@Composable
fun SuccessScreen(
    navController: NavController,
    viewModel : SuccessViewModel =  hiltViewModel()
){
    viewModel.currentUser?.let {
        FirebaseUserUtils.initialize(firebaseUser = it)
    }

    Scaffold(
//        topBar = { TopBar() },
        bottomBar = { BottomNavigationBar(navController) },
        content = {
                padding -> // We have to pass the scaffold inner padding to our content. That's why we use Box.
            Box(modifier = Modifier.padding(padding))
            {
                Image(
                painter = painterResource(id = R.drawable.bg),
                contentDescription = "background",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 50.dp,start = 30.dp, end = 30.dp),
            ){
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ){
                    Text(text = "Success Screen",
                        color = Color.White)

                }
            } }
        }
    )
}
