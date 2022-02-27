package com.hamdy.logo.navagation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hamdy.logo.screens.*

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomNavItem.HomeScreen.routes) {
        composable(BottomNavItem.HomeScreen.routes) {
            HomeScreen()
        }
        composable(BottomNavItem.RestaurantScreen.routes) {
            RestaurantScreen()
        }
        composable(BottomNavItem.PercentScreen.routes) {
            PercentScreen()
        }
        composable(BottomNavItem.GroupScreen.routes) {
            GroupScreen()
        }
        composable(BottomNavItem.ProfileScreen.routes) {
            ProfileScreen()
        }
    }
}