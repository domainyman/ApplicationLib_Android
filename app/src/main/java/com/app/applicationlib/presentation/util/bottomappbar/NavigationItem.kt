package com.app.applicationlib.presentation.util.bottomappbar

import com.app.applicationlib.R

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Home : NavigationItem("home", R.drawable.ic_home_24, "Home")
    object Package : NavigationItem("package", R.drawable.ic_person_24, "Package")
    object Setting : NavigationItem("setting", R.drawable.ic_settings_24, "Setting")

}