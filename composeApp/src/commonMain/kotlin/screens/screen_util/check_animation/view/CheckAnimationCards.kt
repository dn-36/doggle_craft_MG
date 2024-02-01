package screens.screen_util.check_animation.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.Dp

import androidx.compose.ui.unit.dp
import com.fortunetiasasger.exampale.data.models.Person

import com.fortunetiasasger.exampale.presentation.screens.screen_util.check_animation.model.OffSetX
import data.repository.StaticDate
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun checkCardsAnimation(
    img:String,
    ofSetXDefault: Int,
    person: Person,
    height: Dp,
    actionDrop:()->Unit
) {

    val DEFAULT_WIDTH = 150
    val DEFAULT_HEIGHT = 270
    val ANIMATE_WIDTH = 225
    val ANIMATE_HEIGHT = 305

    val screenHeight = height.value.toInt()

    val animDropY = (screenHeight-(DEFAULT_HEIGHT/2))/-2
    val animCheckY = -(DEFAULT_HEIGHT+10)


    //   var animated by remember { mutableStateOf(false) }
    var _img by remember { mutableStateOf("rubashka_kart.png") }
    val rotation = remember { Animatable(initialValue = 360f) }

    var click by remember {
        mutableStateOf(ClickedCard.DON_T_CLICKED)
    }

    val alpha by animateIntAsState(
        targetValue = when(click){
            ClickedCard.DON_T_CLICKED ->0
            ClickedCard.CHECK_CLICKED -> 1
            ClickedCard.DROP_CLICKED ->1
        }
    )

    val offSetY = animateIntAsState(
        when(click){
            ClickedCard.DON_T_CLICKED ->0
            ClickedCard.CHECK_CLICKED -> animCheckY
            ClickedCard.DROP_CLICKED -> animDropY
        }
    )

    val offSetX = animateIntAsState(
        when(click){
            ClickedCard.DON_T_CLICKED -> ofSetXDefault
            ClickedCard.CHECK_CLICKED -> ofSetXDefault
            ClickedCard.DROP_CLICKED -> 0
        }
    )

    val height = animateIntAsState(
        when(click){
            ClickedCard.DON_T_CLICKED -> DEFAULT_HEIGHT
            ClickedCard.CHECK_CLICKED -> DEFAULT_HEIGHT
            ClickedCard.DROP_CLICKED ->  ANIMATE_HEIGHT
        }
    )


    val widht = animateIntAsState(
        when(click){
            ClickedCard.DON_T_CLICKED -> DEFAULT_WIDTH
            ClickedCard.CHECK_CLICKED -> DEFAULT_WIDTH
            ClickedCard.DROP_CLICKED ->  ANIMATE_WIDTH
        }
    )

    if(click == ClickedCard.DROP_CLICKED){
        LaunchedEffect(true) {
            delay(660L)
            actionDrop()
        }

    }

    val rotationDrop by animateIntAsState(
        targetValue = when(click){
            ClickedCard.DON_T_CLICKED ->0
            ClickedCard.CHECK_CLICKED -> 0
            ClickedCard.DROP_CLICKED -> if(person == Person.ONE) -10 else 10

        }
    )

    if (click == ClickedCard.CHECK_CLICKED) {
        LaunchedEffect(true) {
            delay(160L)
            _img = img
        }
    } else if(click == ClickedCard.DROP_CLICKED){
       // LaunchedEffect(true) {
      //  }
    }else if(click == ClickedCard.DON_T_CLICKED){
        LaunchedEffect(true) {
            delay(160L)
            _img = "rubashka_kart.png"


        }
    }
    if (click == ClickedCard.CHECK_CLICKED) {
        LaunchedEffect(true) {
            rotation.animateTo(
                targetValue = 360f,
                animationSpec = tween(durationMillis = 500),
            )
        }
    }else if(click == ClickedCard.DROP_CLICKED){
        LaunchedEffect(true) {
            rotation.animateTo(
                targetValue = 360f,
                animationSpec = tween(durationMillis = 500),
            )
        }

    }else if(click == ClickedCard.DON_T_CLICKED){
        LaunchedEffect(true) {
            rotation.animateTo(
                targetValue = 180f,
                animationSpec = tween(durationMillis = 500),
            )
        }
    }

    Box(
        modifier = Modifier
            .height(height.value.dp)
            .rotate(0f)
            .width(widht.value.dp)

            .offset(x = offSetX.value.dp, y = offSetY.value.dp)
            .graphicsLayer {
                rotationY = rotation.value
            }
    ) {
        Image(
            modifier = Modifier
                .height(height.value.dp)
                .rotate(rotationDrop.toFloat())
                .width(widht.value.dp)
                .clickable {

                    if(click == ClickedCard.CHECK_CLICKED){
                        click = ClickedCard.DON_T_CLICKED

                    }else{
                        click = ClickedCard.CHECK_CLICKED
                    }
                },
            painter = painterResource(res = _img),
            contentDescription = "",
        )

        AnimatedVisibility(
            visible = when(click){
                ClickedCard.DON_T_CLICKED ->false
                ClickedCard.CHECK_CLICKED ->true
                ClickedCard.DROP_CLICKED ->false
            },
            modifier = Modifier
                .fillMaxSize()


        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 10.dp, end = 10.dp),
                contentAlignment = Alignment.BottomCenter,

                ) {
                Image(
                    painter = painterResource(res = "drop.png"),
                    contentDescription = null,
                    modifier = Modifier
                        .wrapContentSize()
                        .alpha(alpha.toFloat())
                        .clickable {
                            click = ClickedCard.DROP_CLICKED
                            StaticDate.goToScreenWinMove = true
                            if(person == Person.ONE) {
                                StaticDate.cardImgDropedPersonFirst = img
                            }else{
                                StaticDate.cardImgDropedPersonSecond = img
                            }

                            actionDrop()
                        }

                )
            }
        }
    }
}

 enum class ClickedCard{
    DON_T_CLICKED,CHECK_CLICKED,DROP_CLICKED
}

