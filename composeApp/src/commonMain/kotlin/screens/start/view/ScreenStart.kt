package screens.start.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale

import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import data.repository.StaticDate


import screens.start.viewmodel.ViewModelStart
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource


internal object ScreenStart : Screen{
    val viewModel = ViewModelStart()
    @OptIn(ExperimentalResourceApi::class)
    @Composable
    override fun Content(){
    Box(
    modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(res = "background.png"),
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier
                    .fillMaxHeight(0.5f)
                    .fillMaxWidth(0.8f)
                    .clickable { /* Handle logo click */ },
                painter = painterResource(res = "logo_main.png"),
                contentDescription = "logo",
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .fillMaxHeight(0.15f)
                .align(Alignment.BottomCenter)
                .clickable {
                    viewModel.clickStart()
                },
        ) {
            Image(
                painter = painterResource(res = "click_to_start.png"),
                contentDescription = ""
            )
        }
    }
}


}





