package cautiousExplorerActors;

import it.unibo.supports2021.ActorBasicJava;
import it.unibo.supports2021.IssWsHttpJavaSupport;
import org.json.JSONObject;

public class CautiousActor extends ActorBasicJava {

    protected enum State {INIT, EXPLORE, TURN_1, BACK, TURN_2, HALT};

    protected IssWsHttpJavaSupport support;
    protected ExplorationStrategy strategy;
    protected State state;
    protected StringBuilder path;
    protected String reversedPath;

    public CautiousActor(String name, IssWsHttpJavaSupport support, ExplorationStrategy strategy) {
        super(name);
        this.support = support;
        this.strategy = strategy;
        this.state = State.INIT;
        this.support.registerActor(this);
        this.path = new StringBuilder();
        this.reversedPath = null;
    }

    @Override
    protected void handleInput(String s) {
        System.out.println("handle input --> " + s);
        if (s.equals("start")) {
            this.automaton(true);
        } else {
            JSONObject message = new JSONObject(s);
            if (message.has("endmove")) this.automaton(Boolean.parseBoolean(message.getString("endmove")));
            else {
                System.out.println("handle input --> discard");
            }
        }
    }

    protected void automaton(boolean input) {
        switch(this.state) {
            case INIT:
                System.out.println("automaton --> state init");
                this.strategy.moveWithStrategy(this);
                this.state = State.EXPLORE;
                break;
            case EXPLORE:
                if (input == true) {
                    this.strategy.moveWithStrategy(this);
                    this.state = State.EXPLORE;
                } else { // input == false
                    this.turnLeft();
                    this.state = State.TURN_1;
                }
                break;
            case TURN_1:
                this.reversePath(this.path);
                this.turnLeft();
                this.state = State.BACK;
                break;
            case BACK:
                boolean done = moveWithPath();
                if (!done) {
                    this.state = State.BACK;
                } else {
                    this.turnLeft();
                    this.state = State.TURN_2;
                }
                break;
            case TURN_2:
                this.turnLeft();
                this.state = State.HALT;
            case HALT:
                System.out.println("automaton --> state halt");
                break;
        }
    }

    protected boolean moveWithPath() {
        boolean done = this.reversedPath.length() == 0;
        System.out.println("MVP --> " + reversedPath + ", " + done);
        if (!done) {
            char move = this.reversedPath.charAt(0);
            this.reversedPath = this.reversedPath.substring(1);
            if (move == 'W') this.moveForward();
            else if (move == 'L') this.turnLeft();
            else if (move == 'R') this.turnRight();
        }
        return done;
    }

    protected void moveForward() {
        support.forward("{\"robotmove\":\"moveForward\", \"time\": 350}");
        this.delay(1000);
    }

    protected void turnLeft() {
        support.forward("{\"robotmove\":\"turnLeft\", \"time\": 300}");
        this.delay(500);
    }

    protected void turnRight() {
        support.forward("{\"robotmove\":\"turnRight\", \"time\": 300}");
        this.delay(500);
    }

    protected void reversePath(StringBuilder path) {
        String back = path.reverse().toString();
        back = back.replace('L', 'X');
        back = back.replace('R', 'L');
        back = back.replace('X', 'R');
        this.reversedPath = back;
    }

}
