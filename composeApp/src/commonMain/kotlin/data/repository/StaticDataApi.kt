package data.repository

import com.fortunetiasasger.exampale.data.models.Person
import data.models.Stone

interface StaticDataApi {
  var listCardsPersonFirst:MutableList<String>
  val listStonesCategory: List<Stone>
  var nameFirst:String
  var nameSecond:String
  var selectedCard:String
  var stoneLeft:String
  var stoneRight:String
  var personNow:Person

  val listStoneLeftPersonOne:MutableList<String>
  val listStoneRightPersonOne:MutableList<String>
  val listStoneLeftPersonTwo:MutableList<String>
  val listStoneRightPersonTwo:MutableList<String>

  fun listStoneLeftNow():MutableList<String>
  fun listStoneRightNow():MutableList<String>
  var cardsLevel:Int
}