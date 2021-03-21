package iss2021_resumablebw.experiments;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyConsoleGui extends JFrame implements ActionListener {

    private MySimpleDispatcher dispatcher;
    private JButton leftButton;
    private JButton forwardButton;

    public MyConsoleGui(MySimpleDispatcher dispatcher) {
        super("Console GUI");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispatcher = dispatcher;
        this.getContentPane().setLayout(new GridLayout(2, 1));
        this.leftButton = new JButton("Turn left");
        this.getContentPane().add(this.leftButton);
        this.leftButton.addActionListener(this);
        this.forwardButton = new JButton("Go forward");
        this.getContentPane().add(this.forwardButton);
        this.forwardButton.addActionListener(this);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.forwardButton) {
            this.dispatcher.goForward();
        } else if (e.getSource() == this.leftButton) {
            this.dispatcher.turnLeft();
        }
    }

}
