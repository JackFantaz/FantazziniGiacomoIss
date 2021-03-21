package iss2021_resumablebw;

import it.unibo.supports.IssCommSupport;
import it.unibo.wenv.RobotInputController;
import org.json.JSONObject;

public class MyRobotInputController extends RobotInputController {

    private boolean running;
    private JSONObject nextCommand;

    public MyRobotInputController(IssCommSupport support) {
        super(support, true, false);
        this.running = false;
        this.nextCommand = null;
    }

    @Override
    public String doBoundary(){
        this.running = true;
        return super.doBoundary();
    }

    @Override
    public synchronized void  handleInfo(JSONObject infoJson) {
        System.out.println("MyAdvancedRobotInputController | handleInfo: " + infoJson.toString());
        if (infoJson.has("robotcmd")) handleRobotCommand(infoJson);
        else if (running) {
            super.handleInfo(infoJson);
        } else if (infoJson.has("endmove")) {
            this.nextCommand = infoJson;
        }
    }

    protected void handleRobotCommand(JSONObject info){
        String answer = info.get("robotcmd").toString();
        //System.out.println("MyAdvancedRobotInputController | handleRobotCmd: " + answer);
        if (answer.equals("RESUME")) {
            if (!running) {
                if (this.nextCommand != null) {
                    this.running = true;
                    this.handleInfo(this.nextCommand);
                } else new MyServiceThread(this).start();
            }
        } else if (answer.equals("STOP")) {
            this.running = false;
        } else {
            throw new IllegalArgumentException("info=" + answer);
        }
    }

}

class MyServiceThread extends Thread {

    private MyRobotInputController controller;
    public MyServiceThread(MyRobotInputController controller) {
        super();
        this.controller = controller;
    }

    @Override
    public void run() {
        this.controller.doBoundary();
    }

}
