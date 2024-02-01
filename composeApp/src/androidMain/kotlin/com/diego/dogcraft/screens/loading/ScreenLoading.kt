package com.diego.dogcraft.screens.loading

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource


@OptIn(ExperimentalResourceApi::class)

object ScreenLoading {

val viewModel = ViewModelLoading()
    @Composable
    fun Content() {

         viewModel.actionGoState()
        Box(
            modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            Image(
                contentScale = ContentScale.Crop,
                painter = painterResource(res = "background.png"),
                contentDescription = "backGround"
            )

            Column(
                modifier = Modifier
                    .fillMaxHeight(0.5f)
                    .fillMaxWidth(0.5f),
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxHeight(0.5f)
                        .fillMaxWidth(),
                    painter = painterResource(res = "logo.png"),
                    contentDescription = "logo",
                )
                Box(
                    modifier = Modifier
                        .fillMaxHeight(0.25f)
                        .fillMaxWidth(1f),
                    contentAlignment = Alignment.Center

                ) {
                    Text(
                        "Loading...",
                        color = Color.White,
                        fontStyle = FontStyle.Normal,
                        fontSize = 25.sp
                    )
                }
            }
        }
    }
}





