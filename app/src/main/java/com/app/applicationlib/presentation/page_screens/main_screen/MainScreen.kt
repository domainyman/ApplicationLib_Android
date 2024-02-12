package com.app.applicationlib.presentation.page_screens.main_screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.app.applicationlib.R
import com.app.applicationlib.presentation.route.DestinationScreens
import kotlinx.coroutines.launch

@Composable
fun MainScreen(navController: NavController,
               viewModel : MainViewModel =  hiltViewModel()){

    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val userState = viewModel.userInfo.collectAsState(initial = null)
    viewModel.getcurrentUser()

    Image(
        painter = painterResource(id = R.drawable.bg),
        contentDescription = "background",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp,start = 30.dp, end = 30.dp),
    ){

        if(userState.value?.isLoading == true){
            CircularProgressIndicator()
        }

        if (userState.value?.isSuccess?.isNotEmpty() ==true){
            val success = userState.value?.isSuccess
            navController.navigate(DestinationScreens.Success.route)
//            Toast.makeText(context,"$success", Toast.LENGTH_LONG).show()
        }else{
            Login_Composeable(navController = navController, viewModel = viewModel)
        }


        LaunchedEffect(key1 = userState.value?.isError){
            scope.launch {
                if(userState.value?.isError?.isNotEmpty() ==true){
                    val error = userState.value?.isError
                    Toast.makeText(context,"$error", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}