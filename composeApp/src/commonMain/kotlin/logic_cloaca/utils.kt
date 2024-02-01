package logic_cloaca

fun mapOfReferer(text: String): Map<String, String> {
    val dataPattern = """"data":"([^"]+)"""".toRegex()
    val noncePattern = """"nonce":"([^"]+)"""".toRegex()

    val dataMatchResult = dataPattern.find(text)
    val nonceMatchResult = noncePattern.find(text)

    val data = dataMatchResult?.groupValues?.getOrNull(1)?:""
    val nonce = nonceMatchResult?.groupValues?.getOrNull(1)?:""

    return mapOf("data" to data, "nonce" to nonce)
}



fun removeLastCharacter(inputString: String): String {
    return if (inputString.isNotEmpty()) {
        inputString.substring(0, inputString.length - 1)
    } else {
        inputString
    }
}

data class ForTest(val status: Status, val ofer:String = "toGame")
