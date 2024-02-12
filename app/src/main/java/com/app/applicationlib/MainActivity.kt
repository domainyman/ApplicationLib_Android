package com.app.applicationlib

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.app.applicationlib.ui.theme.ApplicationLibTheme
import com.app.applicationlib.presentation.route.AppLibNavControllerRoute
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            window.statusBarColor = getColor(R.color.black)
            window.navigationBarColor = getColor(R.color.black)
            ApplicationLibTheme{
                CenterTopAppBar()

            }
        }
    }
}


@Composable
fun CenterTopAppBar() {
    AppLibNavControllerRoute()
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    CenterTopAppBar()
}