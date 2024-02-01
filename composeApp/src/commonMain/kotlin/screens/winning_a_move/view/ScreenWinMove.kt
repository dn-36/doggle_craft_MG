package screens.winning_a_move.view

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import screens.winning_a_move.usecases.AnimationWin
import screens.winning_a_move.usecases.backgroundWin
import screens.winning_a_move.viewmodel.ViewModelWinMove
import data.repository.StaticDate
import utils.whoWin


object ScreenWinMove : Screen {

    val viewModel = ViewModelWinMove()
    @Composable
    override fun Content(
    ) {
        if(StaticDate.goToScreenWinMove) {
            viewModel.goToOtherScreen()
            StaticDate.goToScreenWinMove = false
        }
        backgroundWin()
        AnimationWin(
            cardPersonOne = StaticDate.cardImgDropedPersonFirst,
            cardPersonTwo = StaticDate.cardImgDropedPersonSecond,
            winPerson =  whoWin(StaticDate.cardImgDropedPersonFirst,StaticDate.cardImgDropedPersonSecond)
        )
        //animateInvisibilityBottomCard()

    }


}
