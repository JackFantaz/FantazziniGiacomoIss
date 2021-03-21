package iss2021_resumablebw.experiments;

import it.unibo.supports.RobotApplicationStarter;

public class MyExperimentalLauncher {

    public static void main(String[] args) {
        MySimpleDispatcher dispatcher = (MySimpleDispatcher) RobotApplicationStarter.createInstance(MySimpleDispatcher.class);
        new MyConsoleGui(dispatcher);
    }

}
