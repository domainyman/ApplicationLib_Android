package com.app.applicationlib.presentation.util

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.app.applicationlib.di.user.FirebaseUserUtils

@Composable
fun User_Composable() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Text(
            text = "Name: ${FirebaseUserUtils.display}",
            color = Color.White
        )

        Text(
            text = "Email: ${FirebaseUserUtils.email}",
            color = Color.White
        )

        Text(
            text = "ID: ${FirebaseUserUtils.userId}",
            color = Color.White
        )

        Text(
            text = if (FirebaseUserUtils.emailVerified) "Verified" else "Not Verified",
            color = Color.White
        )
    }
}