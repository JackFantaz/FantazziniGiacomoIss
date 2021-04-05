package cautiousExplorerActors;

public interface ExplorationStrategy {

    public void moveWithStrategy(CautiousActor actor);

}

class WhateverStrategy implements ExplorationStrategy {

    @Override
    public void moveWithStrategy(CautiousActor actor) {
        actor.moveForward();
        actor.path.append("W");
    }

}