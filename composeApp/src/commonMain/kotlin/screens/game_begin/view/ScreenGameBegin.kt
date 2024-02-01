package screens.game_begin.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import dev.icerock.moko.mvvm.livedata.compose.observeAsState
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import screens.game_begin.viewmodel.ViewModelBegin

object ScreenGameBegin:Screen {

    private val viewModel = ViewModelBegin()
    @OptIn(ExperimentalResourceApi::class)
    @Composable
    override fun Content() {

        Image(
            painter = painterResource(
                res ="background.png"
            ), contentDescription = "",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center){
            Image(
                painter = painterResource(
                    res ="bar_for_windows.png"
                ), contentDescription = "", modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .fillMaxHeight(0.4f)
            )}
        Box(modifier = Modifier.fillMaxSize()
            , contentAlignment = Alignment.Center){
            Image(
                painter = painterResource(
                    res ="go.png"
                ), contentDescription = "", modifier = Modifier
                    .fillMaxWidth(0.4f)
                    .fillMaxHeight(0.4f)
                    .padding(top=160.dp)
                    .clickable {
                        viewModel.isClickedBeginState()
                        //MainActivity.navController.navigate(Screen.ScreenGame.route)
                    }
            )}
        Box(modifier = Modifier
            .fillMaxSize()
            , contentAlignment = Alignment.Center

        ) {
            Text(
                text = "LET THE GAME BEGINS",
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .fillMaxHeight(0.3f)
                    .padding(bottom = 50.dp)
                // .fillMaxSize(),
                ,textAlign = TextAlign.Center,
                fontSize = 41.sp,
                color = Color.White,
            )
        }


    }
}
