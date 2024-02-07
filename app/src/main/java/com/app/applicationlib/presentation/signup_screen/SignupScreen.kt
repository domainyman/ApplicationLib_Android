package com.app.applicationlib.presentation.signup_screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.app.applicationlib.R
import com.app.applicationlib.views.DestinationScreens
import kotlinx.coroutines.launch

@Composable
fun SignupScreen(
    navController: NavController,
    viewModel : SignUpViewModel =  hiltViewModel()
){
    var email by rememberSaveable {
        mutableStateOf("")
    }
    var password by rememberSaveable {
        mutableStateOf("")
    }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val state = viewModel.signUpState.collectAsState(initial = null)


    Image(
        painter = painterResource(id = R.drawable.bg),
        contentDescription = "background",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 100.dp,start = 30.dp, end = 30.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            text = "Type your credential's to register",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White

            )
        Spacer(modifier = Modifier.height(30.dp))
        TextField(
            value = email,
            onValueChange = {
                email = it },
            modifier = Modifier.fillMaxWidth(),
            textStyle = MaterialTheme.typography.bodyMedium,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                disabledContainerColor = Color(0x30ffffff),
                cursorColor = Color.Red,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent),
            shape = RoundedCornerShape(8.dp),
            singleLine = true,
            placeholder = { Text(text = "Email")}
        )
        Spacer(modifier = Modifier.height(30.dp))
        TextField(
            value = password,
            onValueChange = {
                password = it },
            modifier = Modifier.fillMaxWidth(),
            textStyle = MaterialTheme.typography.bodyMedium,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                disabledContainerColor = Color(0x30ffffff),
                cursorColor = Color.Red,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent),
            shape = RoundedCornerShape(8.dp),
            singleLine = true,
            placeholder = { Text(text = "Password")},
            visualTransformation = PasswordVisualTransformation()

        )
        Button(
            onClick = {
                      scope.launch {
                          viewModel.registerUser(email, password) }
                      },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, start = 30.dp, end = 30.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White),
            shape = RoundedCornerShape(15.dp)
            ) {
            Text(text = "Sign up",
                color = Color.White,
                style = MaterialTheme.typography.bodyLarge
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center)
        {
            if(state.value?.isLoading == true){
                CircularProgressIndicator()
            }
        }
        Text(text = "Already Have an Account? Sign in",
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(text = "or connect with",
            fontWeight = FontWeight.Medium,
            color = Color.Gray
        )
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
            horizontalArrangement = Arrangement.Center) 
        {
//            IconButton(onClick = { /*TODO*/ }) {
//                Icon(
//                    painter = painterResource(id=R.drawable.ic_gmail),
//                    contentDescription = "Google Icon",
//                    modifier = Modifier.size(50.dp),
//                    tint = Color.Unspecified
//                )
//            }
            Spacer(modifier = Modifier.height(30.dp))
        }
        
        LaunchedEffect(key1 = state.value?.isSuccess){
            scope.launch {
                if(state.value?.isSuccess?.isNotEmpty() ==true){
                    val success = state.value?.isSuccess
                    Toast.makeText(context,"$success",Toast.LENGTH_SHORT).show()
                    email = ""
                    password = ""
                    navController.navigate(DestinationScreens.Success.route)
                }
            }
        }

        LaunchedEffect(key1 = state.value?.isError){
            scope.launch {
                if(state.value?.isError?.isNotEmpty() ==true){
                    val error = state.value?.isError
                    Toast.makeText(context,"$error",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}