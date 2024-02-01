package com.diego.dogcraft.screens.main

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition


import screens.loading.ScreenA

object ScreenMain{

    @Composable
    fun Content() {

        Navigator(ScreenA) { navigator ->

          //  StaticVariables.urlFinal = Shared(MainActivity.context).getUrl()
            SlideTransition(navigator)
        }
    }

}

