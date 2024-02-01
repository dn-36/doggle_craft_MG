package screens.winning_a_move.viewmodel


import com.fortunetiasasger.exampale.data.models.Person
import data.repository.StaticDate
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import screens.game_person_first.view.ScreenGamePersonFirst
import screens.winning_game.view.ScreenWinningGame
import utils.whoWin


class ViewModelWinMove(): ViewModel() {

  //  var goToScreenWinMove = true
    fun goToOtherScreen(){
        StaticDate.listCardsPersonFirst.remove(StaticDate.cardImgDropedPersonFirst)
        StaticDate.listCardsPersonSecond.remove(StaticDate.cardImgDropedPersonSecond)
        val personWin =
            whoWin(StaticDate.cardImgDropedPersonFirst, StaticDate.cardImgDropedPersonSecond)
        when (personWin) {
            Person.ONE -> ++StaticDate.pointsCardsFirst
            Person.TWO -> ++StaticDate.pointsCardsSecond
            else -> {
                ++StaticDate.pointsCardsFirst
                ++StaticDate.pointsCardsSecond
            }
        }



     CoroutineScope(Dispatchers.Main).launch {
     delay(6000L)
            if(StaticDate.listCardsNow().size>0) {
                StaticDate.navigator.push(ScreenGamePersonFirst)
            }else{
                StaticDate.navigator.push(ScreenWinningGame)
            }
        }
    }

}
