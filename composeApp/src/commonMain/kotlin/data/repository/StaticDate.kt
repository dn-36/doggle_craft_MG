package data.repository

import cafe.adriel.voyager.navigator.Navigator
import com.fortunetiasasger.exampale.data.models.Person
import utils.allStones
import utils.leftStones
import utils.listStonesCategoryFirst
import utils.rightStones


object StaticDate : StaticDataApi {

    lateinit var navigator:Navigator
    var goToScreenWinMove = true
    override var nameFirst = "First person"
    override var nameSecond = "Second person"
    override var selectedCard: String = ""

    var cardImgDropedPersonFirst = ""
    var cardImgDropedPersonSecond = ""
    var pointsCardsFirst = 0
    var pointsCardsSecond = 0

    var clickedCraftOrPreview = Click.CRAFT
    override var listCardsPersonFirst = mutableListOf<String>()
    var listCardsPersonSecond = mutableListOf<String>()
    override var listStonesCategory = listStonesCategoryFirst()
    override var stoneLeft = ""
    override var stoneRight = ""
    override var cardsLevel = 0
    override var personNow = Person.ONE

    override var listStoneLeftPersonOne = leftStones(allStones(listStonesCategory))
    override var listStoneRightPersonOne: MutableList<String> = rightStones(allStones(listStonesCategory))

    override var listStoneLeftPersonTwo = leftStones(allStones(listStonesCategory))
    override var listStoneRightPersonTwo = rightStones(allStones(listStonesCategory))

    fun listCardsNow() = if (Person.ONE == personNow) {
        listCardsPersonFirst
    } else {
        listCardsPersonSecond
    }

    fun listCardsAdd(img: String) = if (Person.ONE == personNow) {
        listCardsPersonFirst.add(img)
    } else {
        listCardsPersonSecond.add(img)
    }

    override fun listStoneLeftNow() = if (Person.ONE == personNow) {
        listStoneLeftPersonOne
    } else {
        listStoneLeftPersonTwo
    }

    override fun listStoneRightNow() = if (Person.ONE == personNow) {
        listStoneRightPersonOne
    } else {
        listStoneRightPersonTwo
    }

    fun reboot() {

        nameFirst = "First person"
        nameSecond = "Second person"
        selectedCard = ""

        cardImgDropedPersonFirst = ""
        cardImgDropedPersonSecond = ""
        pointsCardsFirst = 0
        pointsCardsSecond = 0


        listCardsPersonFirst = mutableListOf()
        listCardsPersonSecond = mutableListOf()
        listStonesCategory = listStonesCategoryFirst()
        stoneLeft = ""
        stoneRight = ""
        cardsLevel = 0
        personNow = Person.ONE

        listStoneLeftPersonOne = leftStones(allStones(listStonesCategory))
        listStoneRightPersonOne = rightStones(allStones(listStonesCategory))

        listStoneLeftPersonTwo = leftStones(allStones(listStonesCategory))
        listStoneRightPersonTwo = rightStones(allStones(listStonesCategory))

    }

}

enum class Click{
    CRAFT,PREVIEW
}




