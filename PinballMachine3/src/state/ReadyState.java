package state;

import elements.PinballMachine;

public class ReadyState implements State {
    private PinballMachine pinballMachine;

    public ReadyState(PinballMachine pinballMachine) {
        this.pinballMachine = pinballMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Another coin inserted. Credit increased.");
    }

    @Override
    public void pressStart() {
        System.out.println("Game starts!");
        pinballMachine.setState(pinballMachine.getPlayingState());
    }

    @Override
    public void playGame() {
        System.out.println("The game is already running.");
    }
}
