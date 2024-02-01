package logic_cloaca

import androidx.compose.runtime.Composable


@Composable
fun logic(link:String,
          goGame:@Composable ()->Unit,
          goOffer:@Composable ()->Unit,
 )

          {


        if(link.isBlank()){
            goGame()
            return
        }else{
           goOffer()
        }

    }


