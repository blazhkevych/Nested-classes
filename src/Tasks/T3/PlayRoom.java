package Tasks.T3;

import Tasks.T1.Brand;
import Tasks.T1.GameConsole;
import Tasks.T2.Game;
import Tasks.T2.Genre;

/**
 * This class represents a playroom and contains the main method to demonstrate game-related functionality.
 */
public class PlayRoom {

    /**
     * The main method to demonstrate game-related functionality.
     *
     * @param args The command-line arguments (not used in this context).
     */
    public static void main(String[] args) {
        // Create an array of physical games (4 games) using the getDisk method.
        Game.GameDisk[] physicalGames = new Game.GameDisk[4];
        for (int i = 0; i < physicalGames.length; i++) {
            // Cycle through genres for each physical game.
            Genre currentGenre = Genre.values()[i % Genre.values().length];
            physicalGames[i] = Game.getDisk("Game " + i, currentGenre, "Description " + i);
        }

        // Print information about each physical game to the console, specifying all fields.
        for (Game.GameDisk physicalGame : physicalGames) {
            System.out.println("Physical Game:");
            System.out.println("Name: " + physicalGame.getData().getName());
            System.out.println("Genre: " + physicalGame.getData().getGenre());
            System.out.println("Type: " + physicalGame.getData().getType());
            System.out.println("Description: " + physicalGame.getDescription());
            System.out.println();
        }

        // Create an array of virtual games (4 games) using the getVirtualGame method.
        Game.VirtualGame[] virtualGames = new Game.VirtualGame[4];
        for (int i = 0; i < virtualGames.length; i++) {
            // Cycle through genres for each virtual game.
            Genre currentGenre = Genre.values()[i % Genre.values().length];
            virtualGames[i] = Game.getVirtualGame("Game " + i, currentGenre);
            virtualGames[i].setRating(i % 5);
        }

        // Print information about each virtual game to the console, specifying all fields.
        for (Game.VirtualGame virtualGame : virtualGames) {
            System.out.println("Virtual Game:");
            System.out.println("Name: " + virtualGame.getData().getName());
            System.out.println("Genre: " + virtualGame.getData().getGenre());
            System.out.println("Type: " + virtualGame.getData().getType());
            System.out.println("Rating: " + virtualGame.getRating());
            System.out.println();
        }

        // Create a GameConsole.
        GameConsole gameConsole = new GameConsole(Brand.SONY, "PS5", "1234567890");

        // Print information about the GameConsole to the console, specifying all fields.
        System.out.println(gameConsole);
    }
}
