package elements;

import commands.Command;
import mediator.FlipperMediator;
import visitor.Visitor;

public class Target extends PinballElement {
    private static int counter = 0;
    private final int id;
    private boolean isDown = false;
    private FlipperMediator mediator;
    private int points; // Point value for this Target

    public Target(Command command, FlipperMediator mediator, int points) {
        super(command);
        this.mediator = mediator;
        this.id = ++counter;
        this.points = points;
    }

    @Override
    public void hit() {
        super.hit();
        isDown = true;
        mediator.targetHit(this);
        // Award points when the Target is hit
        PinballMachine.getInstance().addToTotalScore(points);
    }

    public boolean isDown() {
        return isDown;
    }

    public void reset() {
        isDown = false;
        System.out.println("Target reset");
    }

    public void setMediator(FlipperMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public String toString() {
        return "Target " + id;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this); // If you're using the Visitor pattern
    }

    @Override
    public void close() {
        // Implementation for closing the Target (if needed)
    }

    @Override
    public int getPassThroughCount() {
        return 0; // Implementation for pass-through count (if needed)
    }

    public int getPoints() {
        return points;
    }

    public int getHitCount() {
        return counter;
    }
}
