package screens.choosestones.viewmodel


import data.repository.Click
import data.repository.StaticDataApi
import data.repository.StaticDate
import dev.icerock.moko.mvvm.livedata.MutableLiveData
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import screens.setup_cards.view.ScreenSetupCards

class ViewModelChooseStone(val date: StaticDataApi) : ViewModel() {

     private val LEVEL_LOADING = 52

    val  listStoneLeft: MutableLiveData<MutableList<String>> = MutableLiveData(StaticDate.listStoneLeftNow())
    val  listStoneRight: MutableLiveData<MutableList<String>> = MutableLiveData(StaticDate.listStoneRightNow())
    val  levelLoadingState: MutableLiveData<Int> = MutableLiveData(StaticDate.cardsLevel)

    fun clickToCraft() {

        StaticDate.clickedCraftOrPreview = Click.CRAFT
        StaticDate.cardsLevel += LEVEL_LOADING
        levelLoadingState.value = StaticDate.cardsLevel

        CoroutineScope(Dispatchers.Main).launch {
            delay(120L)
            date.listStoneLeftNow().remove(StaticDate.stoneLeft)
            date.listStoneRightNow().remove(StaticDate.stoneRight)
               StaticDate.navigator.push(ScreenSetupCards)
        }
    }
        fun clickToPreview(){
                StaticDate.clickedCraftOrPreview = Click.PREVIEW
            StaticDate.navigator.push(ScreenSetupCards)

        }

   }
