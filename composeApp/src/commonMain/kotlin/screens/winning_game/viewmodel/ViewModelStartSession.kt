package screens.winning_game.viewmodel

import data.repository.StaticDate
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import screens.start.view.ScreenStart


class ViewModelWinningGame(): ViewModel() {



  //  private val _clickedStartState = MutableLiveData<Boolean>(false)
  //  val clickedStartState:LiveData<Boolean> = _clickedStartState

    fun goOtherScreen(){
        StaticDate.reboot()
        //MainActivity.navController.navigate(Screen.ScreenStart.route)
        StaticDate.navigator.push(ScreenStart)
    }



}