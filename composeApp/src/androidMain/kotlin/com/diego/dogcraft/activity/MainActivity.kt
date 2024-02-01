package com.diego.dogcraft.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavController
import com.diego.dogcraft.logiccloaca.LogicСloaca
import com.diego.dogcraft.nav.Navigation
import com.diego.dogcraft.nav.Screen
import logic_cloaca.StaticVariables
import logic_cloaca.Status


class MainActivity : ComponentActivity() {
//ssdsds
    override fun onBackPressed() {

        //super.onBackPressed()
        StaticVariables.goBack()
    }
    companion object {

        lateinit var navController: NavController
        lateinit var context:MainActivity
         }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this
        setContent {



            Navigation()

                LogicСloaca.fireBaseRemoteConfig( {goGame()}, {goOffer()})
        }
    }


    private fun goGame() {

        StaticVariables.status = Status.WHITE
        navController.navigate(Screen.ScreenMain.route)
    }

    private fun goOffer() {
        StaticVariables. status = Status.BLACK
      navController.navigate(Screen.ScreenMain.route)

    }

}

