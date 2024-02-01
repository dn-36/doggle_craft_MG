package screens.screen_util.orientation_cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fortunetiasasger.exampale.data.models.Person
import com.fortunetiasasger.exampale.presentation.screens.screen_util.check_animation.model.OffSetX
import data.repository.StaticDate
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import screens.screen_util.check_animation.view.checkCardsAnimation


@OptIn(ExperimentalResourceApi::class)
@Composable
fun Orientation_cards(person:Person,actionClickDrop:()->Unit) {
    BoxWithConstraints(
        Modifier
            .fillMaxSize()

    ) {
        // maxWidth
        val height = maxHeight

        var visibility by remember {
            mutableStateOf(true)
        }



        LaunchedEffect(true) {
            delay(1000)
            visibility = false
        }

        val cardsListNow = if (person == Person.ONE) {
            StaticDate.listCardsPersonFirst
        } else {
            StaticDate.listCardsPersonSecond

        }
        Box(
            modifier = Modifier
                .fillMaxSize(), contentAlignment = Alignment.TopCenter
        ) {


            Text(
                text = "First persone 's move",
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(30.dp)
                    .focusable(),
                textAlign = TextAlign.Center,
                fontSize = 30.sp,
                color = Color.White,
                //  fontFamily = fontFamaly
            )
        }
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            Image(
                modifier = Modifier
                    .fillMaxHeight(0.5f)
                    .fillMaxWidth(0.8f)
                    .alpha(0f),
                painter = painterResource(res = "all_cards0.png"),
                contentDescription = "logo",
            )
            println( "cardImgDroped2: ${StaticDate.listCardsNow()[0]}")

            if (cardsListNow.size >= 1) {
                checkCardsAnimation(
                    img = StaticDate.listCardsNow()[0],
                    person = person,
                    height = height.value.dp,
                    ofSetXDefault = OffSetX.one,
                    actionDrop = actionClickDrop
                )
            }

            if (cardsListNow.size >= 2) {
                checkCardsAnimation(
                    StaticDate.listCardsNow()[1],
                    person = person,
                    height = height.value.dp,
                    ofSetXDefault = OffSetX.two,
                    actionDrop = actionClickDrop
                )
            }

            if (cardsListNow.size >= 3) {
                checkCardsAnimation(
                    StaticDate.listCardsNow()[2],
                    person = person,
                    height = height.value.dp,
                    ofSetXDefault = OffSetX.three,
                    actionDrop = actionClickDrop
                )
            }

            if (cardsListNow.size >= 4) {
                checkCardsAnimation(
                    StaticDate.listCardsNow()[3],
                    person = person,
                    height = height.value.dp,
                    ofSetXDefault = OffSetX.foure,
                    actionDrop = actionClickDrop
                )
            }

            if (cardsListNow.size >= 5) {
                checkCardsAnimation(
                    StaticDate.listCardsNow()[4],
                    person = person,
                    height = height.value.dp,
                    ofSetXDefault = OffSetX.five,
                    actionDrop = actionClickDrop
                )
            }

            if (cardsListNow.size >= 6) {
                checkCardsAnimation(
                    StaticDate.listCardsNow()[5],
                    person = person,
                    height = height.value.dp,
                    ofSetXDefault = OffSetX.six,
                    actionDrop = actionClickDrop
                )
            }

        }
    }
    }