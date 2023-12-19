package Tasks.T4;

import Tasks.T2.Game;
import Tasks.T2.Genre;

import java.util.Arrays;

public class Comparator {
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

        // Sorting physical games array by genre using an anonymous Comparator class.
        Arrays.sort(physicalGames, new java.util.Comparator<Game.GameDisk>() {
            @Override
            public int compare(Game.GameDisk o1, Game.GameDisk o2) {
                return o1.getData().getGenre().compareTo(o2.getData().getGenre());
            }
        });

        // Print information about each physical game to the console, specifying all fields, after sorting.
        System.out.println("After sorting:");
        for (Game.GameDisk physicalGame : physicalGames) {
            System.out.println("Physical Game:");
            System.out.println("Name: " + physicalGame.getData().getName());
            System.out.println("Genre: " + physicalGame.getData().getGenre());
            System.out.println("Type: " + physicalGame.getData().getType());
            System.out.println("Description: " + physicalGame.getDescription());
            System.out.println();
        }
    }
}
