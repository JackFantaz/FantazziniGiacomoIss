package carparking

import java.awt.Color
import javax.swing.JFrame

public class LedMock(title: String) : JFrame(title) {

    init {
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setSize(300, 200)
        setLocation(30, 250)
        turnOff()
        isVisible = true
    }

    fun turnOff() {
        contentPane.background = Color.BLACK
    }

    fun turnOn() {
        contentPane.background = Color.YELLOW
    }

}
