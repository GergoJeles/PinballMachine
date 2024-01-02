// ASCIIArtFactoryB.java
package display;

public class ASCIIArtFactoryB implements ASCIIArtFactory {
    private static ASCIIArtFactoryB instance;

    private ASCIIArtFactoryB() {}

    public static ASCIIArtFactoryB getInstance() {
        if (instance == null) {
            instance = new ASCIIArtFactoryB();
        }
        return instance;
    }

    @Override
    public String getPressStartArt() {
        // ASCII art for "Press Start" in Style A
        return "  _____                         _____  _                _   \n" +
                " |  __ \\                       / ____|| |              | |  \n" +
                " | |__) |_ __  ___  ___  ___  | (___  | |_  __ _  _ __ | |_ \n" +
                " |  ___/| '__|/ _ \\/ __|/ __|  \\___ \\ | __|/ _` || '__|| __|\n" +
                " | |    | |  |  __/\\__ \\\\__ \\  ____) || |_| (_| || |   | |_ \n" +
                " |_|    |_|   \\___||___/|___/ |_____/  \\__|\\__,_||_|    \\__|\n" +
                "                                                            \n" +
                "                                                            ";
    }

    @Override
    public String getGameOverArt() {
        // ASCII art for "Game Over" in Style A
        return "   _____                            ____                    \n" +
                "  / ____|                          / __ \\                   \n" +
                " | |  __   __ _  _ __ ___    ___  | |  | |__   __ ___  _ __ \n" +
                " | | |_ | / _` || '_ ` _ \\  / _ \\ | |  | |\\ \\ / // _ \\| '__|\n" +
                " | |__| || (_| || | | | | ||  __/ | |__| | \\ V /|  __/| |   \n" +
                "  \\_____| \\__,_||_| |_| |_| \\___|  \\____/   \\_/  \\___||_|   \n" +
                "                                                            \n" +
                "                                                            ";
    }

    @Override
    public String getBallArt(int ballNumber) {
        // ASCII art for "Ball" in Style A
        return "  ____          _  _ \n" +
                " |  _ \\        | || |\n" +
                " | |_) |  __ _ | || |\n" +
                " |  _ <  / _` || || |\n" +
                " | |_) || (_| || || |\n" +
                " |____/  \\__,_||_||_|\n" +
                "                     \n" +
                "                      " + ballNumber;
    }

    // Add more methods if needed for different game messages
}
