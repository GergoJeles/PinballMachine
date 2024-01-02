package commands;

public class IncompatibleBumperCommand implements IncompatibleCommand {
    @Override
    public void specialExecute() {
        System.out.println("Incompatible Bumper Command executed");
    }
}
