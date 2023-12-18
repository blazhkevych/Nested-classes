package Tasks.T2;

/**
 * The Game class represents a video game with properties like name, genre, and type.
 */
public class Game {

    // Game properties
    private String name;    // Name of the game
    private Genre genre;    // Genre of the game
    private Type type;      // Type of the game (Physical or Virtual)

    // Private constructor to create a Game instance
    private Game(String name, Genre genre, Type type) {
        this.name = name;
        this.genre = genre;
        this.type = type;
    }

    // Getters for game properties
    public String getName() {
        return name;
    }

    public Genre getGenre() {
        return genre;
    }

    public Type getType() {
        return type;
    }

    // Setters for game properties
    public void setName(String name) {
        this.name = name;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setType(Type type) {
        this.type = type;
    }

    // Enum representing the type of the game (Physical or Virtual)
    private enum Type {
        PHYSICAL,
        VIRTUAL
    }

    /**
     * The GameDisk class represents a physical game on a disk.
     */
    public static class GameDisk {
        private final String description;    // Description of the game
        private final Game data;             // Game data associated with the disk

        // Constructor for GameDisk
        public GameDisk(String name, Genre genre, String description) {
            Game game = new Game(name, genre, Type.PHYSICAL);
            this.data = game;
            this.description = description;
        }

        // Getter for the game description
        public String getDescription() {
            return description;
        }

        // Getter for the game data associated with the disk
        public Game getData() {
            return data;
        }
    }

    /**
     * The VirtualGame class represents a virtual game with an additional rating.
     */
    public static class VirtualGame {
        private int rating;        // Rating of the game (from 0 to 5)
        private final Game data;   // Game data associated with the virtual game

        // Constructor for VirtualGame
        public VirtualGame(String name, Genre genre) {
            Game game = new Game(name, genre, Type.VIRTUAL);
            this.data = game;
        }

        // Getter for the game rating
        public int getRating() {
            return rating;
        }

        // Getter for the game data associated with the virtual game
        public Game getData() {
            return data;
        }

        // Setter for the game rating (from 0 to 5) with validation check
        public void setRating(int rating) {
            if (rating > 0 && rating <= 5) {
                this.rating = rating;
            } else {
                System.out.println("The rating must be from 0 to 5");
            }
        }
    }

    /**
     * Static factory method to create a GameDisk instance.
     *
     * @param name        The name of the game.
     * @param genre       The genre of the game.
     * @param description The description of the game.
     * @return A new GameDisk instance.
     */
    public static GameDisk getDisk(String name, Genre genre, String description) {
        return new GameDisk(name, genre, description);
    }

    /**
     * Static factory method to create a VirtualGame instance.
     *
     * @param name  The name of the game.
     * @param genre The genre of the game.
     * @return A new VirtualGame instance.
     */
    public static VirtualGame getVirtualGame(String name, Genre genre) {
        return new VirtualGame(name, genre);
    }
}