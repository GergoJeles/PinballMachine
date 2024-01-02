package state;

import elements.PinballMachine;

public class NoCreditState implements State {
    private PinballMachine pinballMachine;

    public NoCreditState(PinballMachine pinballMachine) {
        this.pinballMachine = pinballMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Coin inserted. Ready to play.");
        pinballMachine.setState(pinballMachine.getReadyState());
    }

    @Override
    public void pressStart() {
        System.out.println("Not enough credit. Please insert coin.");
    }

    @Override
    public void playGame() {
        System.out.println("Game cannot be started. No credit available.");
    }
}
