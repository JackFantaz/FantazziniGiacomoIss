package iss2021_resumablebw.experiments;

import it.unibo.annotations.ArilRobotSpec;
import it.unibo.interaction.IssObserver;
import it.unibo.interaction.IssOperations;
import it.unibo.interaction.MsgRobotUtil;
import it.unibo.supports.IssCommSupport;
import org.json.JSONObject;

@ArilRobotSpec
public class MySimpleDispatcher implements IssObserver {

    private IssCommSupport support;

    public MySimpleDispatcher(IssOperations operations) {
        System.out.println("Simple dispatcher --> Creating object...");
        this.support = (IssCommSupport) operations;
        this.support.registerObserver(this);
    }

    public void goForward() {
        System.out.println("Simple dispatcher --> Going forward...");
        support.request(MsgRobotUtil.wMsg);
    }

    public void turnLeft() {
        System.out.println("Simple dispatcher --> Turning left...");
        support.request(MsgRobotUtil.lMsg);
    }

    @Override
    public void handleInfo(String info) {
        System.out.println("Simple dispatcher --> Printing message...");
        System.out.println("                   -> " + info);
    }

    @Override
    public void handleInfo(JSONObject info) {
        this.handleInfo(info.toString());
    }

}
