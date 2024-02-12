package com.app.applicationlib.presentation.content_screen.setting_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.app.applicationlib.R
import com.app.applicationlib.presentation.route.DestinationScreens
import com.app.applicationlib.presentation.util.User_Composable
import com.app.applicationlib.presentation.util.bottomappbar.BottomNavigationBar
import kotlinx.coroutines.launch


@Composable
fun SettingScreen(
    navController: NavController,
    viewModel: SettingViewModel =  hiltViewModel()
){
    val scope = rememberCoroutineScope()

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
                    verticalArrangement = Arrangement.Top,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 50.dp, start = 30.dp, end = 30.dp),
                ){
                    Text(text = "Your account",
                        color = Color.White,
                        textAlign = TextAlign.Center
                        )
                    Divider(
                        color = Color.Gray.copy(alpha = 0.3f),
                        thickness = 1.dp,
                        modifier = Modifier.padding(top = 5.dp)
                    )
                    Spacer(modifier = Modifier.height(15.dp))

                    User_Composable()

                    Button(
                        onClick = {
                            scope.launch {
                                viewModel.logout()
                                }.invokeOnCompletion{
                                navController.navigate(DestinationScreens.Main.route)
                            }
                        },
                        modifier = Modifier
                            .width(200.dp)
                            .padding(top = 20.dp, start = 30.dp, end = 30.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Black,
                            contentColor = Color.White),
                        shape = RoundedCornerShape(15.dp)
                    ) {
                        Text(text = "Logout",
                            color = Color.White,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
//    SettingScreen()
}