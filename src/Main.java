import Tasks.T1.GameConsole;
import Tasks.T1.Brand;
import Tasks.T2.Game;
import Tasks.T2.Genre;

public class Main {

    // T1 - GameConsole and Gamepad tests
    public static void testGameConsole() {
        GameConsole gameConsole = new GameConsole(Brand.SONY, "PS5", "1234567890");
        System.out.println(gameConsole);
    }

    // T2 - Game tests
    public static void testGame() {
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

    public static void main(String[] args) {
        //testGameConsole();
        //testGame();

    }
}