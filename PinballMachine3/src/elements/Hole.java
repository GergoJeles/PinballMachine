package elements;

import commands.Command;
import visitor.*;

public class Hole extends PinballElement {
    private int points; // Point value for this hole

    public Hole(Command command, int points) {
        super(command);
        this.points = points;
    }

    @Override
    public void hit() {
        super.hit();
        System.out.println("Ball entered the hole! Awarded " + points + " points.");
        if (this.pointsVisitor != null) {
            this.pointsVisitor.visit(this);
        }
        // Update the pointsVisitor or add points directly to the score
        // pointsVisitor.visit(this); // Update points using the Visitor pattern
    }



    @Override
    public void close() {
        // Implementation for closing the hole (if needed)
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
