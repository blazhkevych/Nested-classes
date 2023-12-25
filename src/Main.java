import Tasks.T1.GameConsole;
import Tasks.T1.Brand;
import Tasks.T2.Game;
import Tasks.T2.Genre;
import Tasks.T5.GameConsoleException;
import Tasks.T5.GameConsoleUpgrade;


public class Main {

    // T1 - GameConsole and Gamepad tests
    public static void testGameConsole() {
        System.out.println("````````````````````````````````````````testGameConsole````````````````````````````````````````");
        GameConsole gameConsole = new GameConsole(Brand.SONY, "PS5", "1234567890");
        System.out.println(gameConsole);
    }

    // T2 - Game tests
    public static void testGame() {
        System.out.println("````````````````````````````````````````testGame````````````````````````````````````````");

        // Creating a physical game (GameDisk)
        Game.GameDisk physicalGame = Game.getDisk("The Witcher 3", Genre.RPG, "Epic RPG game");

        // Displaying information about the physical game
        System.out.println("Physical Game:");
        System.out.println("Name: " + physicalGame.getData().getName());
        System.out.println("Genre: " + physicalGame.getData().getGenre());
        System.out.println("Type: " + physicalGame.getData().getType());
        System.out.println("Description: " + physicalGame.getDescription());
        System.out.println();

        // Creating a virtual game (VirtualGame)
        Game.VirtualGame virtualGame = Game.getVirtualGame("Minecraft", Genre.SIMULATION);

        // Setting a rating for a virtual game
        virtualGame.setRating(4);

        // Displaying information about the virtual game
        System.out.println("Virtual Game:");
        System.out.println("Name: " + virtualGame.getData().getName());
        System.out.println("Genre: " + virtualGame.getData().getGenre());
        System.out.println("Type: " + virtualGame.getData().getType());
        System.out.println("Rating: " + virtualGame.getRating());
    }

    public static void testT5() {
        System.out.println("````````````````````````````````````````testT5````````````````````````````````````````");

        // Creating a physical game (GameDisk)
        System.out.println("\nCreating a physical game (GameDisk)...");
        Game.GameDisk physicalGame = Game.getDisk("The Witcher 3", Genre.RPG, "Epic RPG game");

        GameConsoleUpgrade gameConsoleUpgrade = new GameConsoleUpgrade(Brand.SONY, "PS5", "1234567890", physicalGame.getData());
        System.out.println("Is the game console turned on ?");
        System.out.println(gameConsoleUpgrade.isOn());
        System.out.println("Turning on the game console...");
        gameConsoleUpgrade.powerOn();
        System.out.println("and now ?");
        System.out.println(gameConsoleUpgrade.isOn());
        System.out.println("Turning off the game console...");
        gameConsoleUpgrade.powerOff();

        System.out.println("-//".repeat(50));

        System.out.println("\nIs the game console turned on ?");
        System.out.println(gameConsoleUpgrade.isOn());
        System.out.println("Is the 1 gamepad turned on ?");
        System.out.println(gameConsoleUpgrade.getFirstGamepad().isOn());
        System.out.println("Is the 2 gamepad turned on ?");
        System.out.println(gameConsoleUpgrade.getSecondGamepad().isOn());

        // Test of turning on the 1 gamepad
        System.out.println("\nTurning on the first gamepad...");
        gameConsoleUpgrade.getFirstGamepad().powerOn();
        System.out.println("is the 1 gamepad turned on?");
        System.out.println(gameConsoleUpgrade.getFirstGamepad().isOn());
        System.out.println("is the game console turned on?");
        System.out.println(gameConsoleUpgrade.isOn());
        System.out.println("Turning off the 1 gamepad...");
        gameConsoleUpgrade.getFirstGamepad().powerOff();
        System.out.println("is the 1 gamepad turned on?");
        System.out.println(gameConsoleUpgrade.getFirstGamepad().isOn());
        System.out.println("is the game console turned on?");
        System.out.println(gameConsoleUpgrade.isOn());

        System.out.println("\nIs the game console turned on ?");
        System.out.println(gameConsoleUpgrade.isOn());
        System.out.println("Is the 1 gamepad turned on ?");
        System.out.println(gameConsoleUpgrade.getFirstGamepad().isOn());
        System.out.println("Is the 2 gamepad turned on ?");
        System.out.println(gameConsoleUpgrade.getSecondGamepad().isOn());

        // Test of turning on the 2 gamepad
        System.out.println("\nTurning on the second gamepad...");
        gameConsoleUpgrade.getSecondGamepad().powerOn();
        System.out.println("is the 2 gamepad turned on?");
        System.out.println(gameConsoleUpgrade.getSecondGamepad().isOn());
        System.out.println("is the game console turned on?");
        System.out.println(gameConsoleUpgrade.isOn());
        System.out.println("Turning off the 2 gamepad...");
        gameConsoleUpgrade.getSecondGamepad().powerOff();
        System.out.println("is the 2 gamepad turned on?");
        System.out.println(gameConsoleUpgrade.getSecondGamepad().isOn());
        System.out.println("is the game console turned on?");
        System.out.println(gameConsoleUpgrade.isOn());

        System.out.println("-//".repeat(50));

        System.out.println("\nIs the game console turned on ?");
        System.out.println(gameConsoleUpgrade.isOn());
        System.out.println("Is the 1 gamepad turned on ?");
        System.out.println(gameConsoleUpgrade.getFirstGamepad().isOn());
        System.out.println("Is the 2 gamepad turned on ?");
        System.out.println(gameConsoleUpgrade.getSecondGamepad().isOn());

        // Turn on both gamepads
        System.out.println("\nTurn on both gamepads...");
        gameConsoleUpgrade.getFirstGamepad().powerOn();
        gameConsoleUpgrade.getSecondGamepad().powerOn();
        System.out.println("1 : " + gameConsoleUpgrade.getFirstGamepad());
        System.out.println("2 : " + gameConsoleUpgrade.getSecondGamepad());

        System.out.println("Are both gamepads turned on?");
        System.out.println("1 : " + gameConsoleUpgrade.getFirstGamepad());
        System.out.println("2 : " + gameConsoleUpgrade.getSecondGamepad());

        // Выключаем первый геймпад
        System.out.println("\nTurn off the 1 gamepad...");
        gameConsoleUpgrade.getFirstGamepad().powerOff();
        System.out.println("Are both gamepads turned on?");
        System.out.println("1 : " + gameConsoleUpgrade.getFirstGamepad());
        System.out.println("2 : " + gameConsoleUpgrade.getSecondGamepad());

        System.out.println("-//".repeat(50));

        try {
            System.out.println("\nTrying to turn on the game console...");
            gameConsoleUpgrade.powerOn();

            System.out.println("\nTrying to charge the gamepads...");
            gameConsoleUpgrade.getFirstGamepad().setChargeLevel(70);
            gameConsoleUpgrade.getSecondGamepad().setChargeLevel(100);

            System.out.println("\nTrying to turn on the gamepads...");
            gameConsoleUpgrade.getFirstGamepad().powerOn();
            gameConsoleUpgrade.getSecondGamepad().powerOn();

            // Играем
            gameConsoleUpgrade.playGame();
            // Играем
            gameConsoleUpgrade.playGame();
            // Играем
            gameConsoleUpgrade.playGame();
            // Играем
            gameConsoleUpgrade.playGame();
            // Играем
            gameConsoleUpgrade.playGame();
            // Играем
            gameConsoleUpgrade.playGame();
            // Играем
            gameConsoleUpgrade.playGame();
            // Играем
            gameConsoleUpgrade.playGame();
            // Играем
            gameConsoleUpgrade.playGame();
            // Играем
            gameConsoleUpgrade.playGame();
            // Играем
            gameConsoleUpgrade.playGame();
            // Играем
            gameConsoleUpgrade.playGame();
            // Играем
            gameConsoleUpgrade.playGame();
            // Играем
            gameConsoleUpgrade.playGame();
            // Играем
            //gameConsoleUpgrade.playGame();
        } catch (GameConsoleException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        testGameConsole();
        testGame();
        testT5();
    }
}