package screens.game_begin.viewmodel

import data.repository.StaticDate
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import screens.game_person_first.view.ScreenGamePersonFirst

class ViewModelBegin() : ViewModel() {



   fun isClickedBeginState(){
       StaticDate.navigator.push(ScreenGamePersonFirst)
    }

}


