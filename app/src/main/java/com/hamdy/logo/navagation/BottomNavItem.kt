package com.hamdy.logo.navagation

import com.hamdy.logo.R

typealias ResDrawable = R.drawable

sealed class BottomNavItem(var icon: Int, val routes: String) {
    object HomeScreen : BottomNavItem(ResDrawable.ic_home, "home_screen")
    object RestaurantScreen :
        BottomNavItem(ResDrawable.ic_bottom_restaurant, "restaurant_screen")

    object PercentScreen : BottomNavItem(ResDrawable.ic_percent, "percent_screen")
    object GroupScreen : BottomNavItem(ResDrawable.ic_group, "group_screen")
    object ProfileScreen : BottomNavItem(ResDrawable.ic_profile, "Profile_screen")
    object Splash : BottomNavItem(ResDrawable.ic_profile, "splash_screen")
    object MainScreen : BottomNavItem(ResDrawable.ic_profile, "main_screen")
}