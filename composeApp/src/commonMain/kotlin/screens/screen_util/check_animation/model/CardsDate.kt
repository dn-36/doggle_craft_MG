package screens.screen_util.check_animation.model

import data.repository.StaticDate
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import screens.game_person_second.view.ScreenGamePersonSecond
import screens.winning_a_move.view.ScreenWinMove


enum class CardsDate(val rotate:Int, val  action:()->Unit){
    FIRST( 10, action = {
        kotlinx.coroutines.CoroutineScope(Dispatchers.Main).launch {
            kotlinx.coroutines.delay(1200L)
            StaticDate.navigator.push(ScreenGamePersonSecond)
        }

       // StaticDate.navigator.pop()
    }),
    SECOND(-10, action = {
        kotlinx.coroutines.CoroutineScope(Dispatchers.Main).launch {
            kotlinx.coroutines.delay(1200L)
            StaticDate.navigator.push(ScreenWinMove)
        }
    })
}