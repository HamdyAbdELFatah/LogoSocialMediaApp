package com.hamdy.logo.navagation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.BrushPainter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.hamdy.logo.R

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        BottomNavItem.HomeScreen,
        BottomNavItem.RestaurantScreen,
        BottomNavItem.PercentScreen,
        BottomNavItem.GroupScreen,
        BottomNavItem.ProfileScreen
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    BottomNavigation(
        backgroundColor = colorResource(id = R.color.white),
        elevation = 16.dp
    ) {
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Box(modifier = Modifier
                        .padding(4.dp)
                        .fillMaxSize(), contentAlignment = Alignment.Center) {
                        if (currentRoute == item.routes) {
                            Icon(
                                ImageVector.vectorResource(id = R.drawable.ic_bottom_selecte),
                                contentDescription = null,
                                modifier = Modifier
                                    .matchParentSize(),
                                tint = Color.Unspecified
                            )
                        }
                        Icon(
                            ImageVector.vectorResource(id = item.icon),
                            contentDescription = stringResource(
                                id = R.string.bottom_navigation_bar_action
                            ),
                            tint = if (currentRoute == item.routes) {
                                Color.White
                            } else {
                                    Color.Unspecified
                            },
                            modifier = Modifier.padding(bottom = 4.dp)

                        )
                    }
                },
                selected = currentRoute == item.routes,
                onClick = {
                    navController.navigate(item.routes)
                }
            )
        }
    }
}
@Preview
@Composable
fun PreviewBottomNavigationBar() {
    BottomNavigationBar(rememberNavController())
}