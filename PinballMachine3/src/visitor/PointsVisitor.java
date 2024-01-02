package visitor;

import elements.*;

public class PointsVisitor implements Visitor {
    private int points;

    public PointsVisitor() {
        this.points = 0;
    }

    @Override
    public void visit(Target target) {
        points += target.getHitCount() * 10;
    }

    @Override
    public void visit(Ramp ramp) {
        points += ramp.getPassThroughCount() * 20;
    }

    @Override
    public void visit(SlingShot slingShot) {
        points += slingShot.getPoints();
    }

    @Override
    public void visit(Bumper bumper) {
        points += bumper.getPoints();
    }

    @Override
    public void visit(Kicker kicker) {
        points += kicker.getPoints();
    }

    @Override
    public void visit(Hole hole) {
        points += hole.getPoints();
    }

    @Override
    public void visit(PinballElement element) {
        // Handle the visit for a generic PinballElement, if applicable
        // This might not be needed if you only visit specific subclasses of PinballElement
    }


    public int getTotalPoints() {
        return points;
    }

    public void resetPoints() {
        points = 0;
    }
}
