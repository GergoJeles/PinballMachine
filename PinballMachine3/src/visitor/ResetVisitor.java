package visitor;

import elements.*;

public class ResetVisitor implements Visitor {
    @Override
    public void visit(Target target) {
        target.reset();
    }

    @Override
    public void visit(Ramp ramp) {
        ramp.close();
    }

    @Override
    public void visit(SlingShot slingShot) {
        // Reset logic for SlingShot
    }

    @Override
    public void visit(PinballElement element) {
        // Generic reset logic for PinballElement, if applicable
    }

    @Override
    public void visit(Kicker kicker) {
        // Reset logic for Kicker
    }

    @Override
    public void visit(Bumper bumper) {
        // Reset logic for Bumper
    }

    @Override
    public void visit(Hole hole) {
        // Reset logic for Hole
    }


    // ... and so on for other elements like Hole, etc.
}
