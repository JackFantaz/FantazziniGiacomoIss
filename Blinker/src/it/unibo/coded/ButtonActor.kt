package it.unibo.coded

import it.unibo.kactor.ActorBasic
import it.unibo.kactor.ApplMessage
import java.awt.event.ActionListener
import java.awt.event.ActionEvent
import kotlinx.coroutines.runBlocking

class ButtonActor(name: String) : ActorBasic(name), ActionListener {
	
	init {
		val frame = javax.swing.JFrame()
		val button = javax.swing.JButton("Click me!")
        button.font = java.awt.Font(button.font.name, button.font.style, 32)
		button.addActionListener(this)
        frame.title = "Button"
        frame.contentPane.add(button)
		frame.defaultCloseOperation = javax.swing.WindowConstants.EXIT_ON_CLOSE
   		frame.setSize(300, 200)
   		frame.setLocation(30, 30)
    	frame.isVisible = true
	}

    override suspend fun actorBody(msg: ApplMessage) { }

	@kotlinx.coroutines.ObsoleteCoroutinesApi
	@kotlinx.coroutines.ExperimentalCoroutinesApi
	override fun actionPerformed(e: ActionEvent?) {
		runBlocking {
			forward("click", "click(0)", "blinker_actor")
		}
    }

}
