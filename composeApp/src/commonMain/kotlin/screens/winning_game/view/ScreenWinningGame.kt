package screens.winning_game.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import screens.winning_game.viewmodel.ViewModelWinningGame
import data.repository.StaticDate
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

object ScreenWinningGame:Screen {

    val viewModel = ViewModelWinningGame()
    @OptIn(ExperimentalResourceApi::class)
    @Composable
    override fun Content() {
        var rotationState = remember { mutableStateOf(0f) }
        var scaleState = remember { mutableStateOf(0.5f) }

        LaunchedEffect(Unit) {
            var turnCount = 0
            if (turnCount < 4) {
                for (angle in 0..720) {
                    rotationState.value = angle.toFloat()
                    scaleState.value = 0.5f + 0.5f * (angle.toFloat() / 720f)


                    delay(2L)
                }
                turnCount++
            }
        }
        Image(
            painter = painterResource(res = "background.png"),
            contentDescription = "Background",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxSize()
        )
        Column(modifier = Modifier.fillMaxSize()
            , verticalArrangement = Arrangement.SpaceAround
            , horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                titleWin() + "\nWIN! ", fontSize = 54.sp, color = Color(0xFFFDFDFD),
                fontWeight = FontWeight.Bold,
          //      fontFamily = fontFamaly,
                textAlign = TextAlign.Center,
                modifier = Modifier
            )
            Text((StaticDate.pointsCardsFirst.toString() + ":" + StaticDate.pointsCardsSecond.toString()),
                fontSize = 44.sp,
               // fontFamily = fontFamaly,
                color = Color(0xFFFDFDFD),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 50.dp))

            Image(
                painter = painterResource(res = "logo.png"),
                contentDescription = "Avatar",
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .padding(bottom = 80.dp)
                    .graphicsLayer(
                        rotationY = rotationState.value,
                        scaleX = scaleState.value,
                        scaleY = scaleState.value
                    )
            )
            Image(
                        painter = painterResource(res = "reset.png"),
                contentDescription = "Back",
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .clickable {
                        viewModel.goOtherScreen()
                    }

            )
        }
    }
    private fun titleWin()=when{
        StaticDate.pointsCardsFirst>StaticDate.pointsCardsSecond ->StaticDate.nameFirst
        StaticDate.pointsCardsFirst<StaticDate.pointsCardsSecond ->StaticDate.nameSecond
        else ->"draw"
    }
}
