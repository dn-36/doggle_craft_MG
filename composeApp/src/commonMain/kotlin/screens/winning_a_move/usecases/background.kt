package screens.winning_a_move.usecases

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale

import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun backgroundWin(){
    Image(
        painter = painterResource(res ="background.png"),
        modifier = Modifier
            .fillMaxSize(),
        contentScale = ContentScale.Crop,
        contentDescription = "back"
    )
}