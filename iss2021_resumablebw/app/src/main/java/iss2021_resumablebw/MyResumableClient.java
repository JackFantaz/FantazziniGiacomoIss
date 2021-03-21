package iss2021_resumablebw;

import it.unibo.annotations.ArilRobotSpec;
import it.unibo.consolegui.ConsoleGui;
import it.unibo.interaction.IssOperations;
import it.unibo.supports.IssCommSupport;
import it.unibo.supports.RobotApplicationStarter;
import it.unibo.wenv.RobotInputController;

@ArilRobotSpec
public class MyResumableClient {

    private IssCommSupport support;
    private RobotInputController controller;
    private ConsoleGui console;

    public MyResumableClient(IssOperations operations) {
        this.support = (IssCommSupport) operations;
        this.controller = new MyRobotInputController(support);
        this.support.registerObserver(controller);
    }

    public void start() {
        this.console = new ConsoleGui(this.controller);
    }

    public static void main(String[] args) {
        MyResumableClient application = (MyResumableClient) RobotApplicationStarter.createInstance(MyResumableClient.class);
        if (application != null) application.start();
    }

}
