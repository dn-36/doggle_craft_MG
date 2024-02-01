package screens.players.view


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import com.fortunetiasasger.exampale.data.models.Person


import screens.players.viewmodel.ViewModelPlayers
import data.repository.StaticDate
import dev.icerock.moko.mvvm.livedata.compose.observeAsState
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource


object ScreenPlayers:Screen {
    val viewModel = ViewModelPlayers(StaticDate)
    @Composable
    override fun Content(){

        viewModel.titleNow.value = if(StaticDate.personNow== Person.ONE){
            StaticDate.nameFirst
        }else{
            StaticDate.nameSecond
        }

            val playerNow =viewModel.titleNow.observeAsState().value


       ScreenLogic(
            textPlayer = playerNow ?: "",

        )
    }

    @OptIn(ExperimentalResourceApi::class)
    @Composable
    fun ScreenLogic(
        textPlayer: String,

    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(res = "background.png"),
                contentDescription = "",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

     Image(
            painter = painterResource(res =  "enter_name_title.png"),
            contentDescription = "",
            modifier = Modifier
                .alpha(1f)
                .padding(top = 50.dp)
                .align(Alignment.TopCenter)
                .fillMaxWidth(0.7f)
                .fillMaxHeight(0.12f)
        )

        Image(
            painter = painterResource(res =  "enter_name_for_player_name.png"),
            contentDescription = "",
            modifier = Modifier

                .align(Alignment.TopCenter)
                .padding(top = 250.dp)
                .fillMaxWidth(0.8f)
                .fillMaxHeight(0.1f)
        )

        Image(
            painter = painterResource(res =  "click_to_start.png"),
            contentDescription = "painter",
            modifier = Modifier
                .padding(bottom = 50.dp)
                .align(Alignment.BottomCenter)
                .fillMaxWidth(0.8f)
                .fillMaxHeight(0.09f)
                .clickable {
                   viewModel.clickedStart()
                }
        )

        TextField(
            value = textPlayer,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 250.dp)
                .fillMaxWidth(0.68f)
                .fillMaxHeight(0.11f),
            textStyle = TextStyle(fontSize = 20.sp),
            onValueChange = { newText ->
                viewModel.changeNameNow(newText)
            }
        )
    }
}
}


