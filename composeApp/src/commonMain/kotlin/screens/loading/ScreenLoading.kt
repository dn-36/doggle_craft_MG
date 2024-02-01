package screens.loading

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
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import data.repository.StaticDate
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import logic_cloaca.StaticVariables
import logic_cloaca.Status
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import screens.black.ScreenBlack
import screens.start.view.ScreenStart


@OptIn(ExperimentalResourceApi::class)

internal object ScreenA:Screen {

var goToStartState = true

    @Composable
    override fun Content() {
        StaticDate.navigator = LocalNavigator.currentOrThrow
        if (ScreenA.goToStartState) {
            ScreenA.goToStartState = false
            if (StaticVariables.status == Status.WHITE) {
                StaticDate.navigator.push(ScreenStart)
            } else {
                StaticDate.navigator.push(ScreenBlack)
            }
            }
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





