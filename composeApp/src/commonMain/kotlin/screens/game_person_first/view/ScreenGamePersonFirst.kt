package screens.game_person_first.view

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import com.fortunetiasasger.exampale.data.models.Person


import screens.game_person_first.usecase.Background_First
import screens.screen_util.check_animation.model.CardsDate
import data.repository.StaticDate
import screens.screen_util.orientation_cards.Orientation_cards


object ScreenGamePersonFirst:Screen {

  @Composable
  override fun Content() {
      StaticDate.personNow = Person.ONE
      Background_First()

        Orientation_cards(
            Person.ONE,
            CardsDate.FIRST.action
        )
}



}
