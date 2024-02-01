package com.diego.dogcraft.nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.diego.dogcraft.activity.MainActivity
import com.diego.dogcraft.screens.loading.ScreenLoading
import com.diego.dogcraft.screens.main.ScreenMain


@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.ScreenLoading.route) {

        composable(route = Screen.ScreenLoading.route) {

            MainActivity.navController = navController
            ScreenLoading.Content()

        }

        composable(
            route = Screen.ScreenMain.route,
        ) {
            ScreenMain.Content()
        }


    }
}