package screens.game_person_second.view

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import com.fortunetiasasger.exampale.data.models.Person
import screens.game_person_second.use_case.Background_second
import data.repository.StaticDate
import screens.screen_util.check_animation.model.CardsDate
import screens.screen_util.orientation_cards.Orientation_cards

object ScreenGamePersonSecond: Screen {
    @Composable
    override fun Content() {
        StaticDate.personNow = Person.TWO
    //    Log.d("test_list_card_second", StaticDate.listCardsNow().toString())

        Background_second()
        Orientation_cards(
            person = Person.TWO,
            CardsDate.SECOND.action
        )
    }

}
