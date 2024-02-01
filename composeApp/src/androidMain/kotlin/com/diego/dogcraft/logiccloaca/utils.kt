package com.diego.dogcraft.logiccloaca

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import logic_cloaca.Status


fun mapOfReferer(text: String): Map<String, String> {
    val dataPattern = """"data":"([^"]+)"""".toRegex()
    val noncePattern = """"nonce":"([^"]+)"""".toRegex()

    val dataMatchResult = dataPattern.find(text)
    val nonceMatchResult = noncePattern.find(text)

    val data = dataMatchResult?.groupValues?.getOrNull(1)?:""
    val nonce = nonceMatchResult?.groupValues?.getOrNull(1)?:""

    return mapOf("data" to data, "nonce" to nonce)
}

fun checkForInternet(context: Context): Boolean {


    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager


    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

        val network = connectivityManager.activeNetwork ?: return false

        val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false

        return when {

            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true

            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true

            else -> false
        }
    } else {

        @Suppress("DEPRECATION") val networkInfo =
            connectivityManager.activeNetworkInfo ?: return false
        @Suppress("DEPRECATION")
        return networkInfo.isConnected
    }
}


fun removeLastCharacter(inputString: String): String {
    return if (inputString.isNotEmpty()) {
        inputString.substring(0, inputString.length - 1)
    } else {
        inputString
    }
}

data class ForTest(val status: Status, val ofer:String = "toGame")
