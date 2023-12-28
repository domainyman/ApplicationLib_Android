package com.app.applicationlib.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.app.applicationlib.R
import com.app.applicationlib.ui.AppViewModel
import com.app.applicationlib.views.DestinationScreens

@Composable
fun MainScreen(navController: NavController,viewModel : AppViewModel){
    Image(
        painter = painterResource(id = R.drawable.bg),
        contentDescription = "background",
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxSize()
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 100.dp)
    ){
        Text(
            text = "Wellcome",
            color = Color.White,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
            )
        Spacer(modifier = Modifier.height(80.dp))
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(50.dp))
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(Color(0xffffd700), Color.White, Color(0xffffd700))
                    )
                )
        ){
            Button(
                onClick = {navController.navigate(DestinationScreens.Signup.route)},
                colors = ButtonDefaults.buttonColors(
                    Color.Transparent),
                modifier = Modifier.width(300.dp)
            ) {
              Text(
                  text = "Sign Up",
                  color = Color.Black,
                  fontSize = 30.sp,
                  fontWeight = FontWeight.Bold
              )
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(50.dp))
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(Color(0xffffd700), Color.White, Color(0xffffd700))
                    )
                )
        ){
            Button(
                onClick = {navController.navigate(DestinationScreens.Login.route)},
                colors = ButtonDefaults.buttonColors(
                    Color.Transparent),
                modifier = Modifier.width(300.dp)
            ) {
                Text(
                    text = "Login",
                    color = Color.Black,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}