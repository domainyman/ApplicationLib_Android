package com.app.applicationlib.views.util.bottomappbar

import com.app.applicationlib.R

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Home : NavigationItem("home", R.drawable.ic_home_24, "Home")
    object Profile : NavigationItem("profile", R.drawable.ic_person_24, "Profile")
    object Setting : NavigationItem("setting", R.drawable.ic_settings_24, "Setting")

}