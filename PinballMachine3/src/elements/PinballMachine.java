package elements;

import state.State;
import state.EndState;
import state.NoCreditState;
import state.PlayingState;
import state.ReadyState;

public class PinballMachine {

    private static PinballMachine instance;

    private State noCreditState;
    private State readyState;
    private State playingState;
    private State endState;
    private State state;
    private int credit = 0;
    private int lostBalls = 0;
    private int totalScore = 0; // Add a property to track total score
    private int currentBall = 1;

    public State getCurrentState() {
        return state;
    }

    private PinballMachine() {
        noCreditState = new NoCreditState(this);
        readyState = new ReadyState(this);
        playingState = new PlayingState(this);
        endState = new EndState(this);
        state = noCreditState; // Set initial state
    }

    public static PinballMachine getInstance() {
        if (instance == null) {
            instance = new PinballMachine();
        }
        return instance;
    }

    public void insertCoin() {
        credit++;
        state.insertCoin();
    }

    public void useCredit() {
        if (this.credit > 0) {
            this.credit--; // deduct one credit
            System.out.println("Credit used. Remaining Credits: " + this.credit);
        }
    }

    public void pressStart() {
        if (credit > 0) {
            credit--;
            state.pressStart();
        } else {
            System.out.println("Not enough Credits.");
        }
    }



    public void playGame() {
        state.playGame();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void loseBall() {
        lostBalls++;
        if (lostBalls >= 3) {
            System.out.println("All balls lost. Game over!");
            setState(getEndState());
            lostBalls = 0;
        }
    }

    public State getNoCreditState() {
        return noCreditState;
    }

    public State getReadyState() {
        return readyState;
    }

    public State getPlayingState() {
        return playingState;
    }

    public State getEndState() {
        return endState;
    }

    public int getCredit() {
        return credit;
    }

    // Add methods to handle scoring
    public void addToTotalScore(int score) {
        totalScore += score;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public int getCurrentBallNumber() {
        return currentBall;
    }
    public void nextBall() {
        currentBall++;
        // You might want to check if the current ball exceeds the total ball count and take action accordingly
    }
}
