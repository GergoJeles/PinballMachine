package elements;

import commands.Command;
import visitor.*;
import commands.*;
import display.*;
import elements.*;
import mediator.*;
import visitor.*;
import state.*;

public class Bumper extends PinballElement {
    private int points; // Point value for this bumper

    public Bumper(Command command, int points) {
        super(command);
        this.points = points;
    }

    @Override
    public void hit() {
        super.hit();
        System.out.println("Bumper hit! Awarded " + points + " points.");
        if (this.pointsVisitor != null) {
            this.pointsVisitor.visit(this);
        }
    }



    @Override
    public void close() {
        // Implementation for closing the bumper (if needed)
    }

    @Override
    public int getPassThroughCount() {
        return 0; // Implementation for pass-through count (if needed)
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this); // Make sure the visit(Kicker kicker) is defined in Visitor
    }

    public int getPoints() {
        return points;
    }
}
