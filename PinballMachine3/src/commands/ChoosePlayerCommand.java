package commands;

public class ChoosePlayerCommand implements Command {
    // This implementation randomly selects a player and awards extra points.
    @Override
    public void execute() {
        int playerNumber = (int) (Math.random() * 3) + 1; // Selects a number between 1 and 3
        System.out.println("Player " + playerNumber + " selected. Extra points!");
    }
}
