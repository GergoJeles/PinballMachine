package visitor;

import elements.*;

public interface Visitor {

    void visit(PinballElement element);
    void visit(Target target);
    void visit(Ramp ramp);
    void visit(SlingShot slingShot);
    void visit(Bumper bumper);
    void visit(Kicker kicker);
    void visit(Hole hole);
    // Add other visit methods for any additional elements
}
