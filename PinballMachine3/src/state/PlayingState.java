package state;

import elements.PinballMachine;

public class PlayingState implements State {
    private PinballMachine pinballMachine;

    public PlayingState(PinballMachine pinballMachine) {
        this.pinballMachine = pinballMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Coin inserted. Additional credit added.");
    }

    @Override
    public void pressStart() {

        System.out.println("Authors of the software: Gergö JELES and Lukas STUPPACHER.");
    }

    @Override
    public void playGame() {
        System.out.println("Playing...");
    }
}
