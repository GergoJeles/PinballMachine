package elements;

import commands.Command;
import visitor.*;
import commands.*;
import display.*;
import elements.*;
import mediator.*;
import visitor.*;
import state.*;


public class Kicker extends PinballElement {
    private int points; // Point value for this kicker

    public Kicker(Command command, int points) {
        super(command);
        this.points = points;
    }



    @Override
    public void hit() {
        super.hit();
        System.out.println("Kicker hit! Awarded " + points + " points.");
        if (this.pointsVisitor != null) {
            this.pointsVisitor.visit(this);
        }
    }




    @Override
    public void close() {
        // Implementation for closing the kicker (if needed)
    }

    @Override
    public int getPassThroughCount() {
        return 0; // Implementation for pass-through count (if needed)
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this); // Implement the visit method for the Visitor pattern
    }

    public int getPoints() {
        return points;
    }
}
