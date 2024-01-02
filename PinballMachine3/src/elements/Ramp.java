package elements;

import commands.Command;
import visitor.Visitor;

public class Ramp extends PinballElement {
    private boolean isOpen;
    private int points; // Point value for this ramp

    public Ramp(Command command, int points) {
        super(command);
        this.points = points;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this); // If you're using the Visitor pattern
    }

    @Override
    public void close() {
        if (isOpen) {
            isOpen = false;
            System.out.println("Ramp closed! Awarded " + points + " points.");
            // Update the pointsVisitor or add points directly to the score
            pointsVisitor.visit(this); // Update points using the Visitor pattern
        }
    }

    @Override
    public int getPassThroughCount() {
        return 0; // Implementation for pass-through count (if needed)
    }

    public void open() {
        isOpen = true;
        System.out.println("Ramp opened!");
    }

    public boolean isOpen() {
        return isOpen;
    }

    public int getPoints() {
        return points;
    }
}
