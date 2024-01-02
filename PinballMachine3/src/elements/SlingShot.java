package elements;

import commands.Command;
import visitor.*;
import commands.*;
import display.*;
import elements.*;
import mediator.*;
import visitor.*;
import state.*;

public class SlingShot extends PinballElement {
    private int points; // Point value for this SlingShot

    public SlingShot(Command command, int points) {
        super(command);
        this.points = points;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this); // If you're using the Visitor pattern
    }

    @Override
    public void close() {
        // Implementation for closing the SlingShot (if needed)
    }

    @Override
    public int getPassThroughCount() {
        return 0; // Implementation for pass-through count (if needed)
    }

    public int getPoints() {
        return points;
    }
}
