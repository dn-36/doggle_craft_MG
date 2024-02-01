package screens.startsession.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import screens.startsession.viewmodel.ViewModelStartSession
import data.repository.StaticDate
import dev.icerock.moko.mvvm.livedata.compose.observeAsState
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource


object ScreenStartSession: Screen {

   private val viewModel = ViewModelStartSession()

    @Composable
    override fun Content() {
        viewModel.goToChoseStonePersoSecond()
       val startAnimationsState = viewModel.startAnimationsState.observeAsState().value
        LoginScreen(
            visibility = startAnimationsState
        )

    }

    @OptIn(ExperimentalResourceApi::class)
    @Composable
   private fun LoginScreen(visibility: Boolean) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(res = "background.png"),
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                contentDescription = ""
            )

            Image(
                painter = painterResource(res = "baraban_three.png"),
                modifier = Modifier
                    .height(350.dp)
                    .width(350.dp),
                contentDescription = ""
            )

            if (!visibility) {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Image(
                        painter = painterResource(res =  "reset.png"),
                        modifier = Modifier
                            .fillMaxWidth(0.3f)
                            .fillMaxHeight(0.15f)
                            .padding(bottom = 20.dp)
                            .clickable {
                                viewModel.clickToStartSession()
                            },
                        contentDescription = ""
                    )
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.TopCenter
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .fillMaxHeight(0.15f)
                        .padding(top = 50.dp),
                    painter = painterResource(res ="start_session.png"),
                    contentDescription = ""
                )
            }

            visibilityStones(StaticDate.listStonesCategory, visibility)
        }
    }


    }



