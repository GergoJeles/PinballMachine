import java.util.Scanner;
import java.util.Random;


import commands.*;
import display.*;
import elements.*;
import mediator.FlipperMediator;
import visitor.*;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        ASCIIArtFactory factoryA = ASCIIArtFactoryA.getInstance();
        ASCIIArtFactory factoryB = ASCIIArtFactoryB.getInstance();
        ASCIIArtFactory currentFactory = factoryA;  // default to factoryA

        PinballMachine machine = PinballMachine.getInstance();
        MacroCommand holeCommands = MacroCommand.getInstance();

        // Instantiate elements (Hole, Bumper, Ramp, SlingShot, Kicker)
        Hole hole = new Hole(holeCommands, 100);
        Bumper bumper = new Bumper(new ScoreCommand(5), 50); // Replace ScoreCommand with appropriate command
        Ramp ramp = new Ramp(new ScoreCommand(10), 50); // Replace ScoreCommand with appropriate command
        SlingShot slingShot = new SlingShot(new ScoreCommand(3), 50); // Replace ScoreCommand with appropriate command
        Kicker kicker = new Kicker(new ScoreCommand(7), 50); // Replace ScoreCommand with appropriate command

        // Instantiate and configure the mediator
        FlipperMediator mediator = new FlipperMediator(new ArrayList<>(), ramp); // Replace with actual targets list

        // Add targets to the mediator and configure them
        mediator.registerTarget(new Target(new ScoreCommand(8), mediator, 50)); // Replace ScoreCommand with appropriate command
        mediator.registerTarget(new Target(new ScoreCommand(6), mediator, 50)); // Replace ScoreCommand with appropriate command

        // Initialize the PointsVisitor
        PointsVisitor pointsVisitor = new PointsVisitor();

        // Set pointsVisitor for each element
        hole.setPointsVisitor(pointsVisitor);
        bumper.setPointsVisitor(pointsVisitor);
        ramp.setPointsVisitor(pointsVisitor);
        slingShot.setPointsVisitor(pointsVisitor);
        kicker.setPointsVisitor(pointsVisitor);


        Scanner scanner = new Scanner(System.in);
        String command;
        System.out.println("Welcome to Interactive Pinball Machine! Type 'help' for commands.");

        while (true) {
            System.out.print("> ");
            command = scanner.nextLine().trim().toLowerCase();

            switch (command) {
                case "insertcoin":
                    machine.insertCoin();
                    System.out.println("Coin inserted. Credits: " + machine.getCredit());
                    break;
                case "pressstart":
                    if (machine.getCredit() > 0) {
                        machine.pressStart();
                        System.out.println("Game started. Choose your font style: (1) for Style A, (2) for Style B");
                        String fontChoice = scanner.nextLine().trim();
                        if ("1".equals(fontChoice)) {
                            currentFactory = factoryA;
                        } else if ("2".equals(fontChoice)) {
                            currentFactory = factoryB;
                        } else {
                            System.out.println("Invalid choice, defaulting to Style A");
                        }
                        System.out.println(currentFactory.getPressStartArt());
                    } else {
                        System.out.println("Not enough credits. Please insert coin.");
                    }
                    break;
                case "hit":
                    if (machine.getCredit() > 0) {
                        String[] elements = {"hole", "bumper", "ramp", "slingShot", "kicker"};
                        Random random = new Random();
                        String element = elements[random.nextInt(elements.length)];
                        int currentBallNumber = machine.getCurrentBallNumber();
                        System.out.println(currentFactory.getBallArt(currentBallNumber));
                        System.out.println("The ball hit the " + element + "!");


                        // Now, based on the randomly selected element, perform the hit and accept
                    switch (element) {
                        case "hole":
                            hole.hit();
                            hole.accept(pointsVisitor);
                            break;
                        case "bumper":
                            bumper.hit();
                            bumper.accept(pointsVisitor);
                            break;
                        case "ramp":
                            ramp.hit();
                            ramp.accept(pointsVisitor);
                            break;
                        case "slingshot":
                            slingShot.hit();
                            slingShot.accept(pointsVisitor);
                            break;
                        case "kicker":
                            kicker.hit();
                            kicker.accept(pointsVisitor);
                            break;
                    }


                        machine.useCredit(); // Deduct a credit after each hit
                    } else {
                        System.out.println("Out of credits. Please 'insertcoin' or 'quit'.");
                    }
                    break;
                case "score":
                    System.out.println("Total points: " + pointsVisitor.getTotalPoints());
                    break;
                case "reset":
                    ResetVisitor resetVisitor = new ResetVisitor();
                    // Reset each element
                    hole.accept(resetVisitor);
                    bumper.accept(resetVisitor);
                    ramp.accept(resetVisitor);
                    slingShot.accept(resetVisitor);
                    kicker.accept(resetVisitor);
                    // Add any additional elements or game state resets as needed
                    System.out.println("Game has been reset.");
                    break;

                case "help":
                    System.out.println("Commands: insertcoin, pressstart, hit, score, reset, quit");
                    break;
                case "quit":
                    // Display the Game Over ASCII Art based on the selected font style before quitting
                    System.out.println(currentFactory.getGameOverArt());
                    System.out.println("Quitting game. Thanks for playing!");
                    scanner.close(); // Close the scanner before quitting
                    return;
                default:
                    System.out.println("Invalid command. Type 'help' for a list of commands.");
                    break;
            }
        }
    }
}
