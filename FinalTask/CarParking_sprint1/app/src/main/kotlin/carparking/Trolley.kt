package carparking

import it.unibo.actor0.ActorBasicKotlin
import it.unibo.actor0.ApplMessage
import it.unibo.robotService.ApplMsgs
import it.unibo.robotService.BasicStepRobotActor
import kotlinx.coroutines.delay

class Trolley : ActorBasicKotlin("trolley") {

    private val robot = BasicStepRobotActor("robot", this, scope, "localhost")
    private val planner = DirectionalPlanner("parkingMap")

    private val home = arrayOf("0", "0", "S")
    private val parking = arrayOf("1", "1", "E")
    private val indoor = arrayOf("6", "0", "N")
    private val outdoor = arrayOf("6", "4", "S")
    private val sequence = arrayOf(indoor, parking, home, parking, outdoor, home)

    private var step = 0;

    override suspend fun handleInput(msg: ApplMessage) {
        val move = planner.getNextPlannedMove()
        if (move.isEmpty() && step < sequence.size) {
            delay(1000)
            planFor(sequence[step])
            step++
        }
        if (move.isNotEmpty()) doMove(move)
    }

    private suspend fun planFor(place: Array<String>) {
        planner.planForGoal(place[0], place[1], place[2])
        autoMsg(ApplMsgs.startAny(name))
    }

    private fun doMove(move: String) {
        when (move) {
            "w" -> robot.send(ApplMsgs.stepRobot_w(name))
            "l" -> robot.send(ApplMsgs.stepRobot_l(name))
            "r" -> robot.send(ApplMsgs.stepRobot_r(name))
        }
        planner.updateMap(move)
    }

}
