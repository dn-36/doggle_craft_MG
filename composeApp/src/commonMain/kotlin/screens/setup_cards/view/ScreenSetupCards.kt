package screens.setup_cards.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import cafe.adriel.voyager.core.screen.Screen
import screens.setup_cards.viewmodel.ViewModelSetup
import data.repository.StaticDate
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

object ScreenSetupCards:Screen {
      val viewModel  = ViewModelSetup()


    @OptIn(ExperimentalResourceApi::class)
    @Composable
    override fun Content() {
        Image(
            painter = painterResource(
                res ="background.png"
            ),
            contentDescription = "",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
            , verticalArrangement = Arrangement.SpaceAround
            , horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(res ="setup_cards.png"),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .fillMaxHeight(0.11f)
            )
            viewModel.selectedCard.value = StaticDate.selectedCard
            Image(
                painter = painterResource(
                    res = viewModel.selectedCard.value
                ),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxHeight(0.5f)
                    .fillMaxWidth(0.65f)
            )
            Image(
                painter = painterResource(res = "back.png"),
                contentDescription = "",
                modifier = Modifier
                    .clickable {
                        viewModel.clickBack()
                    }
                    .fillMaxHeight(0.25f)
                    .fillMaxWidth(0.9f)
            )
        }}
}
