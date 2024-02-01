package com.diego.dogcraft.nav

sealed class Screen(val route :String){
    object ScreenLoading : Screen("ScreenLoading")
    object ScreenMain : Screen("ScreenMain")

}
