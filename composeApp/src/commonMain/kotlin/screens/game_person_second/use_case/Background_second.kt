package screens.game_person_second.use_case

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.layout.ContentScale

import androidx.compose.ui.unit.dp
import data.repository.StaticDate
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource


@OptIn(ExperimentalResourceApi::class)
@Composable
fun Background_second() {

    BoxWithConstraints {

        val DEFAULT_WIDTH = 150
        val DEFAULT_HEIGHT = 270
        val ANIMATE_WIDTH = 225
        val ANIMATE_HEIGHT = 305
        val screenHeight = maxHeight.value


        val Y = (screenHeight - (DEFAULT_HEIGHT / 2)) / -2

        Image(
            painter = painterResource(res = "background.png"),
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )

        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            println("cardImgDroped3: ${StaticDate.cardImgDropedPersonFirst}")
            Image(
                painter = painterResource(
                    res =
                    StaticDate.cardImgDropedPersonFirst
                ),
                modifier = Modifier
                    .width(225.dp)
                    .height(305.dp)
                    .offset(y=Y.dp)
                    .rotate(-10f),
                contentScale = ContentScale.Crop,
                contentDescription = null
            )
        }
    }
}