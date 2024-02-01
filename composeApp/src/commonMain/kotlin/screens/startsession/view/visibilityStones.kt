package screens.startsession.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.models.Stone
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource


@Composable
fun visibilityStones(listStones:List<Stone>, visibility: Boolean) {
    AnimatedVisibility(
        visible = visibility,
        modifier = Modifier
            .height(350.dp)
            .width(350.dp),
        enter = slideInVertically() + expandVertically() + fadeIn()
    ) {
        Box(
            modifier = Modifier
                .height(350.dp)
                .width(350.dp),
            contentAlignment = Alignment.Center
        ) {




            StoneInfo(
                img = listStones[0].img,
                count = listStones[0].count,
                weight = 240,
                height = 170,
                bottom = 100,
                end = 170)

            StoneInfo(
                img = listStones[1].img,
                count = listStones[1].count,
                weight = 70,
                height = 170,
                bottom = 100,
                start = 10)

            StoneInfo(
                img = listStones[1].img,
                count = listStones[1].count,
                weight = 260,
                height = 170,
                bottom = 100,
                start = 190)

            StoneInfo(
                img = listStones[3].img,
                count = listStones[3].count,
                weight = 260,
                height = 170,
                top = 80,
                start = 10)

            StoneInfo(
                img = listStones[3].img,
                count = listStones[3].count,
                weight = 80,
                height = 170,
                top = 80,
                start = 10)

            StoneInfo(
                img = listStones[5].img,
                count = listStones[5].count,
                weight = 260,
                height = 170,
                top = 80,
                start = 190)
        }
        }
    }

@OptIn(ExperimentalResourceApi::class)
@Composable
fun StoneInfo(
    img:String,
    count:Int,
    height:Int,
    weight: Int,
    start:Int= 0,
    end:Int = 0,
    bottom:Int = 0,
    top:Int = 0


){
    Box(
        modifier = Modifier
        .height(height.dp)
        .width(weight.dp)
            .padding(
                bottom = bottom.dp,
                top = top.dp,
                end = end.dp,
                start = start.dp
            )
    ) {
        Box(
            modifier = Modifier
                .width(70.dp)
                .height(70.dp),
            contentAlignment = Alignment.BottomEnd
        ) {
            Image(
                painter = painterResource(res = img),
                contentDescription = "",
                modifier = Modifier
                    .width(70.dp)
                    .height(70.dp)
            )

            Text(
                text = count.toString(),
                fontSize = 15.sp,
                color = Color.White,
                modifier = Modifier
                    .wrapContentSize()
            )
        }
    }
}
