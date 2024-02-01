package screens.startsession.viewmodel


import com.fortunetiasasger.exampale.data.models.Person
import data.repository.StaticDate
import dev.icerock.moko.mvvm.livedata.LiveData
import dev.icerock.moko.mvvm.livedata.MutableLiveData
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import screens.choosestones.view.ScreenChooseStones


class ViewModelStartSession(): ViewModel() {

    private val _clickedStartState = MutableLiveData<Boolean>(false)
    val startAnimationsState: LiveData<Boolean> = _clickedStartState

    fun goToChoseStonePersoSecond(){
       if(StaticDate.personNow == Person.TWO) {
           _clickedStartState.value = true
           CoroutineScope(Dispatchers.Main).launch {
               delay(1500L)
               StaticDate.navigator.push(ScreenChooseStones)
           }
       }
    }
    fun clickToStartSession(){
        _clickedStartState.value = true
        CoroutineScope(Dispatchers.Main).launch {
          delay(1500L)
            StaticDate.navigator.push(ScreenChooseStones)
        }

    }



}