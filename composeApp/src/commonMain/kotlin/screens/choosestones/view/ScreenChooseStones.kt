package screens.choosestones.view

import androidx.compose.animation.core.animateIntAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale

import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import data.repository.StaticDate
import dev.icerock.moko.mvvm.livedata.compose.observeAsState


import screens.choosestones.viewmodel.ViewModelChooseStone
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource


object ScreenChooseStones :Screen{

    private val viewModel: ViewModelChooseStone = ViewModelChooseStone(StaticDate)

    @OptIn(ExperimentalResourceApi::class)
        @Composable
    override fun Content() {

        val levelLoading = viewModel.levelLoadingState.observeAsState().value
        viewModel.levelLoadingState.value = StaticDate.cardsLevel
        val levelLoadinganimation by animateIntAsState(
            targetValue = levelLoading,
            label = "",
        )

        val listStoneLeft = viewModel.listStoneLeft.observeAsState().value
        val listStoneRight = viewModel.listStoneRight.observeAsState().value
        viewModel.listStoneLeft.value = StaticDate.listStoneLeftNow()
        viewModel.listStoneRight.value = StaticDate.listStoneRightNow()

        Image(
            painter = painterResource(res = "background.png"),
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop,
            contentDescription = "back"
        )

        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ) {



            Box(
                modifier = Modifier
                    .width(320.dp)
                    .height(120.dp)
                    .padding(top = 20.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Image(
                    modifier = Modifier
                        .width(320.dp)
                        .height(130.dp),
                    painter = painterResource(res = "indicator_bar.png"),
                    contentDescription = ""
                )

                Image(
                    modifier = Modifier
                        .width(levelLoadinganimation.dp)
                        .height(33.dp)
                        .padding(start = 7.dp),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(res = "indicator.png"),
                    contentDescription = ""
                )
            }


                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.Center

                ) {

                    Box(
                        modifier = Modifier
                            .height(450.dp)
                            .width(350.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(res = "baraban_2.png"),
                            modifier = Modifier
                                .height(450.dp)
                                .width(350.dp)
                                .padding(top = 100.dp),
                            contentDescription = ""
                        )
                        Row(
                            modifier = Modifier
                                .width(260.dp)
                                .height(280.dp)
                                .padding(top = 100.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            PagerStone(
                                listImg = listStoneLeft?.toList() ?: listOf(),
                                id = "ColumLeft",
                                side = SidesStone.Lefr
                            )
                            PagerStone(
                                listImg = listStoneRight?.toList() ?: listOf(),
                                id = "ColumRight",
                                side = SidesStone.Right
                            )
                        }

                    }
                    Spacer(modifier = Modifier.height(80.dp))

                    Image(
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
                            .clickable { viewModel.clickToCraft() }
                            .height(70.dp),
                        painter = painterResource(res = "craft.png"),
                        contentDescription = ""
                    )

                    Spacer(modifier = Modifier.height(30.dp))

                    Image(
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
                            .height(60.dp)
                            .clickable { viewModel.clickToPreview() },
                        painter = painterResource(res = "previev.png"),
                        contentDescription = ""
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Add other UI elements as needed

                }
            }
        }
    }
