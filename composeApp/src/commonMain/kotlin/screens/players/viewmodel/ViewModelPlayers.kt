package screens.players.viewmodel

import com.fortunetiasasger.exampale.data.models.Person
import data.repository.StaticDataApi
import data.repository.StaticDate
import dev.icerock.moko.mvvm.livedata.MutableLiveData
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import screens.choosestones.view.ScreenChooseStones
import screens.startsession.view.ScreenStartSession


class ViewModelPlayers(val date: StaticDataApi) : ViewModel() {
    val titleNow = MutableLiveData(if(StaticDate.personNow== Person.ONE){
        date.nameFirst //viewModel.textPlayerOne.observeAsState("").value
    }else{
        date.nameSecond //  viewModel.textPlayerTwo.observeAsState("").value
    })

  private  fun changePlayerOne(newText:String){
        date.nameFirst = if(date.nameFirst == "First person")
        {""}
        else
        {newText}
     titleNow.value =  date.nameFirst
    }

  private  fun changePlayerSecond(newText:String){
        date.nameSecond = if(date.nameSecond == "Second person")
        {""}
        else
        {newText}
        titleNow.value =  date.nameSecond
    }

    val changeNameNow = {
        str:String ->
        if(StaticDate.personNow == Person.ONE){
            changePlayerOne(str)
        }else{
            changePlayerSecond(str)

        }
    }


    fun clickedStart(){
        if(date.personNow == Person.ONE) {
            StaticDate.navigator.push(ScreenStartSession)
        }else{
            //RootComponent.navigation.pushNew(RootComponent.Configuration.actionPlayersToChooseStone)
            StaticDate.navigator.push(ScreenChooseStones)
        }
        }
}