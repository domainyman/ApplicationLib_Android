package com.app.applicationlib.presentation.main_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.app.applicationlib.R
import com.app.applicationlib.views.DestinationScreens

@Composable
fun Login_Composeable(navController: NavController,
                      viewModel : MainViewModel =  hiltViewModel()
) {

    Image(
        painter = painterResource(id = R.drawable.logo),
        contentDescription = "logo")
    Text(
        text = stringResource(id = R.string.main_logo_name),
        color = Color.Gray,
        style = MaterialTheme.typography.titleLarge
    )
    Spacer(modifier = Modifier.height(200.dp))

    Button(
        onClick =
        {navController.navigate(DestinationScreens.Login.route)},
        modifier = Modifier
            .width(200.dp)
            .padding(top = 20.dp, start = 30.dp, end = 30.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Black,
            contentColor = Color.White),
        shape = RoundedCornerShape(15.dp)
    ) {
        Text(text = "Login",
            color = Color.White,
            style = MaterialTheme.typography.bodyLarge
        )
    }
    Spacer(modifier = Modifier.height(30.dp))
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(50.dp))
            .background(Color.Black)

    ){
//            Button(
//                onClick = {navController.navigate(DestinationScreens.Login.route)},
//                colors = ButtonDefaults.buttonColors(
//                    Color.Transparent),
//                modifier = Modifier.width(200.dp)
//            ) {
//                Text(
//                    text = "Google Login",
//                    color = Color.White,
//                    style = MaterialTheme.typography.bodyLarge
//                )
//            }
    }

    Spacer(modifier = Modifier.height(30.dp))
}