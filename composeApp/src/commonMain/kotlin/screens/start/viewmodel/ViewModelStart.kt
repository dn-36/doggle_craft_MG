package screens.start.viewmodel

import cafe.adriel.voyager.navigator.Navigator
import data.repository.StaticDate

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import screens.players.view.ScreenPlayers


class ViewModelStart(): ViewModel() {
    fun clickStart(){
        StaticDate.navigator.push(ScreenPlayers)
    }

}