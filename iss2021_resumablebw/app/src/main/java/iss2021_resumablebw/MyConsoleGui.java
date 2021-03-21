package iss2021_resumablebw;

import it.unibo.supports.RobotApplicationStarter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyConsoleGui extends JFrame implements ActionListener {

    private MySimpleDispatcher dispatcher;
    private JButton stopButton;
    private JButton resumeButton;

    public MyConsoleGui(MySimpleDispatcher dispatcher) {
        super("Console GUI");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispatcher = dispatcher;
        this.getContentPane().setLayout(new GridLayout(2, 1));
        this.stopButton = new JButton("Stop");
        this.getContentPane().add(this.stopButton);
        this.stopButton.addActionListener(this);
        this.resumeButton = new JButton("Resume");
        this.getContentPane().add(this.resumeButton);
        this.resumeButton.addActionListener(this);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.resumeButton) {
            this.dispatcher.goForward();
        } else if (e.getSource() == this.stopButton) {
            this.dispatcher.turnLeft();
        }
    }

}
