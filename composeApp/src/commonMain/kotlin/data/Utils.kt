package utils
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.fortunetiasasger.exampale.data.models.Person
import data.models.Stone


fun generateListWithMaxSum(): List<Int> {
    val erorrRandomCountStone = listOf(
        listOf(1, 2, 1, 4, 2, 2),
        listOf(3, 1, 1, 2, 3, 2),
        listOf(4, 4, 1, 1, 1, 1),
        listOf(2, 2, 2, 2, 1, 3),
        listOf(3, 2, 1, 3, 2, 1),
        listOf(4, 1, 4, 3, 3, 1),
        listOf(1, 4, 2, 1, 2, 2),
        listOf(3, 1, 4, 2, 1, 1),
        listOf(1, 3, 2, 3, 1, 2),
        listOf(4, 2, 1, 4, 1, 2),
        listOf(2, 3, 1, 1, 4, 1),
        listOf(3, 4, 2, 1, 1, 1),
        listOf(1, 2, 3, 4, 1, 1),
        listOf(4, 3, 4, 3, 1, 1),
        listOf(2, 1, 1, 2, 3, 3),
        listOf(3, 4, 2, 3, 1, 1),
        listOf(1, 3, 1, 2, 4, 1),
        listOf(4, 2, 4, 1, 1, 2),
        listOf(2, 1, 3, 3, 2, 1),
        listOf(3, 4, 1, 2, 1, 1),
        listOf(1, 2, 4, 3, 3, 1),
        listOf(4, 3, 3, 1, 2, 1),
        listOf(2, 1, 2, 4, 1, 2),
        listOf(3, 4, 1, 2, 1, 1),
        listOf(1, 2, 3, 2, 3, 1),
        listOf(4, 1, 4, 2, 3, 2),
        listOf(2, 3, 1, 1, 2, 3),
        listOf(3, 4, 2, 4, 1, 1),
        listOf(1, 3, 1, 2, 3, 1),
        listOf(4, 2, 4, 1, 3, 1),
        listOf(2, 1, 3, 3, 1, 1),
        listOf(3, 4, 1, 2, 1, 2),
        listOf(1, 2, 4, 3, 4, 0),
        listOf(4, 3, 3, 1, 2, 1),
        listOf(2, 1, 2, 4, 2, 1),
        listOf(3, 4, 1, 3, 1, 1),
        listOf(1, 2, 3, 2, 1, 3),
        listOf(4, 1, 4, 2, 3, 2),
        listOf(2, 3, 1, 1, 2, 3),
        listOf(3, 4, 2, 4, 1, 1),
        listOf(1, 3, 1, 2, 2, 2),
        listOf(4, 2, 4, 1, 3, 1),
        listOf(2, 1, 3, 3, 1, 1),
        listOf(3, 4, 1, 2, 1, 2),
        listOf(1, 2, 4, 3, 3, 1),
        listOf(4, 3, 3, 1, 2, 1),
        listOf(2, 1, 2, 4, 3, 0),
        listOf(3, 4, 1, 3, 1, 1),
        listOf(1, 2, 3, 2, 3, 1)
    )
    return erorrRandomCountStone.random()
}

fun listStonesCategoryFirst():List<Stone>{

    val listCategryStone = listOf(
        "blue.png",
        "light_purple.png",
        "yellow.png",
        "purple.png",
        "green.png",
        "orange.png",
        )
    val listCountStones = generateListWithMaxSum()

  return  listOf<Stone>(
        Stone(
            listCategryStone.random(),
            listCountStones[0]
    ),
        Stone(
            listCategryStone.random(),
            listCountStones[1]
        ),
        Stone(
            listCategryStone.random(),
            listCountStones[2]
        ),
        Stone(
            listCategryStone.random(),
            listCountStones[3]
        ),
        Stone(
            listCategryStone.random(),
            listCountStones[4]
        ),
        Stone(
            listCategryStone.random(),
            listCountStones[5]
        )
  )
}

fun listStonesCategorySecond():List<Stone>{

    val listCategryStone = listOf(
        "blue.png",
        "purple.png",
        "green.png",
        "orange.png",
        "light_purple.png",
        "yellow.png",

    )
    val listCountStones = generateListWithMaxSum()

    return  listOf<Stone>(
        Stone(
            listCategryStone.random(),
            listCountStones[0]
        ),
        Stone(
            listCategryStone.random(),
            listCountStones[1]
        ),
        Stone(
            listCategryStone.random(),
            listCountStones[2]
        ),
        Stone(
            listCategryStone.random(),
            listCountStones[3]
        ),
        Stone(
            listCategryStone.random(),
            listCountStones[4]
        ),
        Stone(
            listCategryStone.random(),
            listCountStones[5]
        )
    )
}



fun allStones(listStone: List<Stone>):List<String>{
    val finalList = mutableListOf<String>()
    for(i in listStone){
        repeat(i.count){
            finalList.add(i.img)
        }
    }
    return finalList.toList()
}

fun leftStones(list:List<String>):MutableList<String>{
val finalList = mutableListOf<String>()
    finalList.add(list[0])
    finalList.add(list[1])
    finalList.add(list[2])
    finalList.add(list[3])
    finalList.add(list[4])
    finalList.add(list[5])
    return finalList
}

fun rightStones(list:List<String>):MutableList<String>{
    val finalList = mutableListOf<String>()
    finalList.add(list[6])
    finalList.add(list[7])
    finalList.add(list[8])
    finalList.add(list[9])
    finalList.add(list[10])
    finalList.add(list[11])
    return finalList
}



fun getCard(stoneL: String, stoneR: String): String {
    val SERENY ="purple.png"
    val GREEN = "green.png"
    val PINK = "light_purple.png"
    val ORANGE = "orange.png"
    val YELLOW = "yellow.png"
    val BLUE = "blue.png"




    return when {
        (stoneL == SERENY && stoneR == SERENY) -> "all_card.png"
        (stoneL == SERENY && stoneR == GREEN) -> "all_cards0.png"
        (stoneL == SERENY && stoneR == BLUE) -> "all_cards1.png"
        (stoneL == SERENY && stoneR == PINK) -> "all_cards2.png"
        (stoneL == SERENY && stoneR == ORANGE) -> "all_cards3.png"
        (stoneL == SERENY && stoneR == YELLOW) -> "all_cards4.png"
        (stoneL == GREEN && stoneR == GREEN) -> "all_cards_0009.png"
        (stoneL == GREEN && stoneR == BLUE) -> "all_cards_0010.png"
        (stoneL == GREEN && stoneR == PINK) -> "all_cards_0011.png"
        (stoneL == GREEN && stoneR == ORANGE) -> "all_cards_0012.png"
        (stoneL == GREEN && stoneR == YELLOW) -> "all_cards_0013.png"
        (stoneL == GREEN && stoneR == SERENY) -> "all_cards_0014.png"
        (stoneL == PINK && stoneR == GREEN) -> "all_cards_0015.png"
        (stoneL == PINK && stoneR == BLUE) -> "all_cards_0017.png"
        (stoneL == PINK && stoneR == PINK) -> "all_cards_0018.png"
        (stoneL == PINK && stoneR == ORANGE) -> "all_cards_0019.png"
        (stoneL == PINK && stoneR == YELLOW) -> "all_cards_0020.png"
        (stoneL == PINK && stoneR == SERENY) -> "all_cards_0021.png"
        (stoneL == ORANGE && stoneR == GREEN) -> "all_cards_0022.png"
        (stoneL == ORANGE && stoneR == BLUE) -> "all_cards_0024.png"
        (stoneL == ORANGE && stoneR == PINK) -> "all_cards_0025.png"
        (stoneL == ORANGE && stoneR == ORANGE) -> "all_cards_0026.png"
        (stoneL == ORANGE && stoneR == YELLOW) -> "all_cards_0027.png"
        (stoneL == ORANGE && stoneR == SERENY) -> "all_cards_0028.png"
        (stoneL == YELLOW && stoneR == GREEN) -> "all_cards_0029.png"
        (stoneL == YELLOW && stoneR == BLUE) -> "all_cards_0030.png"
        (stoneL == YELLOW && stoneR == PINK) -> "all_cards_0031.png"
        (stoneL == YELLOW && stoneR == ORANGE) -> "all_cards_0032.png"
        (stoneL == YELLOW && stoneR == YELLOW) -> "all_cards_0033.png"
        (stoneL == YELLOW && stoneR == SERENY) -> "all_cards_0034.png"
        (stoneL == BLUE && stoneR == GREEN) -> "all_cards6.png"
        (stoneL == BLUE && stoneR == BLUE) -> "all_cards7.png"
        (stoneL == BLUE && stoneR == PINK) -> "all_cards8.png"
        (stoneL == BLUE && stoneR == ORANGE) -> "all_cards16.png"
        (stoneL == BLUE && stoneR == YELLOW) -> "all_card_23.png"
        (stoneL == BLUE && stoneR == SERENY) -> "all_cards_0035.png"
        else -> "all_card_23.png"

    }
}

fun stoneImgToString(i:String):String = when(i){
    "purple.png" -> "SERENY"
    "green.png" -> "GREEN"
    "light_purple.png" -> "PINK"
    "orange.png" -> "ORANGE"
    "yellow.png" -> "YELLOW"
    "blue.png" -> "BLUE"
        else -> "blue.png"
}

data class PointsCards(val img:String, val attac:Int, val protectetion:Int)

val listCardPointd = listOf(
    PointsCards("all_card.png",4,2),
    PointsCards("all_card_23.png",3,3),
    PointsCards("all_cards0.png",3,5),
    PointsCards("all_cards1.png",1,5),
    PointsCards("all_cards2.png",1,5),
    PointsCards("all_cards3.png",1,4),
    PointsCards("all_cards4.png",4,5),
    PointsCards("all_cards6.png",4,1),
    PointsCards("all_cards7.png",4,6),
    PointsCards("all_cards8.png",6,5),
    PointsCards("all_cards_0009.png",6,4),
    PointsCards("all_cards_0010.png",5,2),
    PointsCards("all_cards_0011.png",5,1),
    PointsCards("all_cards_0012.png",5,6),
    PointsCards("all_cards_0013.png",5,4),
    PointsCards("all_cards_0014.png",3,1),
    PointsCards("all_cards_0015.png",6,1),
    PointsCards("all_cards16.png",6,3),
    PointsCards("all_cards_0018.png",6,2),
    PointsCards("all_cards_0017.png",6,6),
    PointsCards("all_cards_0019.png",5,5),
    PointsCards("all_cards_0020.png",5,3),
    PointsCards("all_cards_0021.png",4,3),
    PointsCards("all_cards_0022.png",4,4),
    PointsCards("all_cards_0024.png",3,6),
    PointsCards("all_cards_0025.png",3,4),
    PointsCards("all_cards_0026.png",3,2),
    PointsCards("all_cards_0027.png",2,1),
    PointsCards("all_cards_0028.png",2,2),
    PointsCards("all_cards_0029.png",2,3),
    PointsCards("all_cards_0030.png",2,4),
    PointsCards("all_cards_0031.png",1,1),
    PointsCards("all_cards_0032.png",1,6),
    PointsCards("all_cards_0033.png",2,6),
    PointsCards("all_cards_0034.png",2,5),
    PointsCards("all_cards_0035.png",1,2)
    )

fun whoWin(imgAttack:String, imgProtection:String):Person {
    val attack = getPointImg(imgAttack)
    val protection = getPointImg(imgProtection)

   return when{
        attack.attac > protection.protectetion -> Person.ONE
        attack.attac > protection.protectetion -> Person.TWO
        attack.attac == protection.protectetion -> Person.BOTH
        else -> Person.TWO
        }
    }



fun getPointImg(img:String): PointsCards {
        listCardPointd.forEach{
            if(it.img == img){
                return it
            }
        }
return PointsCards("",0,0)
}



