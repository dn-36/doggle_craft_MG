package screens.choosestones.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import data.repository.StaticDate
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import utils.getCard


@OptIn(ExperimentalFoundationApi::class, ExperimentalResourceApi::class)
@Composable
fun PagerStone(listImg: List<String>,id:String,side: SidesStone){
    val pagerState = rememberPagerState(pageCount = {
        listImg.size
    })
    VerticalPager(
        modifier = Modifier
            .width(120.dp)
            .height(180.dp)
            .layoutId(id),
        state = pagerState) { page ->
        if(side == SidesStone.Lefr) {
            StaticDate.stoneLeft = listImg[page]
        }else{
            StaticDate.stoneRight = listImg[page]
        }
        StaticDate.selectedCard = getCard(StaticDate.stoneLeft,StaticDate.stoneRight)


        Image(
            painter = painterResource(
                res = listImg[page]),
            contentDescription = null,
            modifier = Modifier
                .width(100.dp)
                .height(150.dp)
                .padding(top = 20.dp)

        )
    }
}

enum class SidesStone(){
    Lefr,Right
}
