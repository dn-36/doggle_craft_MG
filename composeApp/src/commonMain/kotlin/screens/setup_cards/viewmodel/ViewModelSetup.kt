package screens.setup_cards.viewmodel


import com.fortunetiasasger.exampale.data.models.Person
import data.repository.Click
import data.repository.StaticDate
import dev.icerock.moko.mvvm.livedata.LiveData
import dev.icerock.moko.mvvm.livedata.MutableLiveData
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import screens.choosestones.view.ScreenChooseStones
import screens.game_begin.view.ScreenGameBegin
import screens.players.view.ScreenPlayers
import utils.allStones
import utils.leftStones
import utils.listStonesCategorySecond
import utils.rightStones


class ViewModelSetup(): ViewModel() {

    val selectedCard: MutableLiveData<String> = MutableLiveData(StaticDate.selectedCard)
    fun clickBack() {
        if (StaticDate.clickedCraftOrPreview == Click.CRAFT) {
            StaticDate.listCardsAdd(StaticDate.selectedCard)
            println(StaticDate.listCardsNow().size)
            if (StaticDate.listCardsNow().size == 6) {
                if (
                    StaticDate.personNow == Person.ONE
                ) {
                    StaticDate.personNow = Person.TWO
                    StaticDate.navigator.push(ScreenPlayers)
                    StaticDate.cardsLevel = 0
                    StaticDate.listStonesCategory = listStonesCategorySecond()
                    StaticDate.listStoneLeftPersonTwo =
                        leftStones(allStones(StaticDate.listStonesCategory))
                    StaticDate.listStoneRightPersonTwo =
                        rightStones(allStones(StaticDate.listStonesCategory))
                    return
                } else {
                  //  MainActivity.navController.navigate(Screen.ScreenGameBegin.route)
                    StaticDate.navigator.push(ScreenGameBegin)
                }
            } else {

                StaticDate.navigator.pop()

            }
        }else{
            StaticDate.navigator.pop()

        }
    }

}