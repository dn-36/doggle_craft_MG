package screens.screen_util.check_animation.viewmodel

import com.fortunetiasasger.exampale.data.models.Person


data class CheckCardsState(
    var img:String = "rubashka_kart",
    var person: Person = Person.ONE,
    var screenHeight: Int,
    var ofSetX: Int,
    var offSetY: Int,
    var rotation:Float = 0f,
    var visibility: Boolean = false,
    var alpha:Float = 0f,
    var height:Int = 270,
    var widht:Int = 225,
    var rotationDrop:Float = 0f
)
