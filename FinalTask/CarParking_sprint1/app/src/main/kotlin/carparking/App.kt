package carparking

import it.unibo.robotService.ApplMsgs
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val trolley = Trolley()
        val message = ApplMsgs.startAny("main")
        trolley.send(message)
        delay(60000)
    }
}
