package com.app.applicationlib.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.app.applicationlib.R

val popp = FontFamily(
    Font(R.font.poppins_black, FontWeight.Black),
    Font(R.font.poppins_bold, FontWeight.Bold),
    Font(R.font.poppins_extrabold, FontWeight.ExtraBold),
    Font(R.font.bebasneue_regular, FontWeight.Normal),
    Font(R.font.poppins_thin, FontWeight.Thin),
    Font(R.font.poppins_extralight, FontWeight.ExtraLight),
    Font(R.font.poppins_light, FontWeight.Light),
    Font(R.font.poppins_semibold, FontWeight.SemiBold),
    Font(R.font.poppins_medium, FontWeight.Medium)
)
// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = popp,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
    ),
    bodyMedium = TextStyle(
        fontFamily = popp,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,

    ),
    bodySmall = TextStyle(
        fontFamily = popp,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
    ),
    titleSmall = TextStyle(
        fontFamily = popp,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
    ),
    titleMedium= TextStyle(
        fontFamily = popp,
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    titleLarge = TextStyle(
        fontFamily = popp,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
    ),
    labelSmall = TextStyle(
        fontFamily = popp,
        fontWeight = FontWeight.Medium,
        fontSize = 10.sp,
    ),
    labelMedium= TextStyle(
        fontFamily = popp,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,

    ),
    labelLarge = TextStyle(
        fontFamily = popp,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
    ),
    displayMedium = TextStyle(
        fontFamily = popp,
        fontWeight = FontWeight.Black,
        fontSize = 10.sp,
    ),
    displaySmall = TextStyle(
        fontFamily = popp,
        fontWeight = FontWeight.Black,
        fontSize = 8.sp,
    ),
    displayLarge = TextStyle(
        fontFamily = popp,
        fontWeight = FontWeight.Black,
        fontSize = 12.sp,
    ),
)
