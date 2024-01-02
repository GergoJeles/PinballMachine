package elements;

import commands.Command;
import visitor.*;

public abstract class PinballElement {
    private Command command;
    protected PointsVisitor pointsVisitor; // Reference to the PointsVisitor

    public PinballElement(Command command) {
        this.command = command;
    }

    // Pass the PointsVisitor instance to the PinballElement
    public void setPointsVisitor(PointsVisitor pointsVisitor) {
        this.pointsVisitor = pointsVisitor;
    }

    public void hit() {
        if (command != null) {
            command.execute();
        }

        // Update points when the element is hit
        if (pointsVisitor != null) {
            pointsVisitor.visit(this);
        }
    }

    // Make the accept method abstract to force concrete subclasses to implement it
    public abstract void accept(Visitor visitor);

    public abstract void close();

    public abstract int getPassThroughCount();
}
