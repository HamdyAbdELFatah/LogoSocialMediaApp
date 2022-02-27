package com.hamdy.logo.navagation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hamdy.logo.screens.*
import com.hamdy.logo.viewmodel.MainViewModel

@Composable
fun NavigationGraph(navController: NavHostController,viewModel: MainViewModel) {
    NavHost(navController = navController, startDestination = BottomNavItem.Splash.routes) {
        composable(BottomNavItem.HomeScreen.routes) {
            HomeScreen(viewModel)
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
        composable(route = BottomNavItem.Splash.routes) { SplashScreen(navController) }

    }
}