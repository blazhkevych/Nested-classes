package Tasks.T5;

import Tasks.T1.Brand;
import Tasks.T1.Color;
import Tasks.T2.Game;

public class GameConsoleUpgrade implements Powered {
    /**
     * The brand of the gaming console, defined by the {@code Brand} enum.
     */
    private final Brand brand;

    /**
     * The model of the gaming console.
     */
    private String model;

    /**
     * The serial number of the gaming console.
     */
    private final String serial;

    /**
     * The first connected gamepad.
     */
    private GameConsoleUpgrade.Gamepad firstGamepad;

    /**
     * The second connected gamepad.
     */
    private GameConsoleUpgrade.Gamepad secondGamepad;

    /**
     * The power state of the gaming console.
     */
    private boolean isOn;

    /**
     * The active game on the gaming console.
     */
    private Game activeGame;

    private int waitingCounter;

    /**
     * Constructs a {@code GameConsole} with the specified brand, model, and serial number.
     *
     * @param brand  The brand of the gaming console.
     * @param model  The model of the gaming console.
     * @param serial The serial number of the gaming console.
     */
    public GameConsoleUpgrade(Brand brand, String model, String serial, Game activeGame) {
        this.brand = brand;
        this.model = model;
        this.serial = serial;
        this.isOn = false; // по умолчанию консоль выключена или выключена должна быть ? По идее если сюда попадает activeGame, то консоль должна быть включена.
        this.firstGamepad = new GameConsoleUpgrade.Gamepad(GameConsoleUpgrade.this.brand, 1);
        this.secondGamepad = new GameConsoleUpgrade.Gamepad(GameConsoleUpgrade.this.brand, 2);
        this.activeGame = activeGame;
    }

    /**
     * Retrieves the brand of the gaming console.
     *
     * @return The brand of the gaming console.
     */
    public Brand getBrand() {
        return brand;
    }

    /**
     * Retrieves the model of the gaming console.
     *
     * @return The model of the gaming console.
     */
    public String getModel() {
        return model;
    }

    /**
     * Retrieves the serial number of the gaming console.
     *
     * @return The serial number of the gaming console.
     */
    public String getSerial() {
        return serial;
    }

    /**
     * Retrieves the first connected gamepad.
     *
     * @return The first connected gamepad.
     */
    public GameConsoleUpgrade.Gamepad getFirstGamepad() {
        return firstGamepad;
    }

    /**
     * Retrieves the second connected gamepad.
     *
     * @return The second connected gamepad.
     */
    public GameConsoleUpgrade.Gamepad getSecondGamepad() {
        return secondGamepad;
    }

    /**
     * Checks if the gaming console is powered on.
     *
     * @return {@code true} if the gaming console is powered on, {@code false} otherwise.
     */
    public boolean isOn() {
        return isOn;
    }

    /**
     * Powers off the gaming console.
     */
    @Override
    public void powerOn() {
        isOn = true;
    }

    /**
     * Powers off the gaming console.
     */
    @Override
    public void powerOff() {
        isOn = false;
    }

    /**
     * Sets the model of the gaming console.
     *
     * @param model The new model of the gaming console.
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Sets the active game on the gaming console.
     *
     * @param activeGame The new active game on the gaming console.
     */
    public void setActiveGame(Game activeGame) {
        if (isOn && activeGame == null) {
            this.activeGame = activeGame;
        }
    }

    /**
     * Sets the first connected gamepad.
     *
     * @param firstGamepad The new first connected gamepad.
     */
    public void setFirstGamepad(GameConsoleUpgrade.Gamepad firstGamepad) {
        this.firstGamepad = firstGamepad;
    }

    /**
     * Sets the second connected gamepad.
     *
     * @param secondGamepad The new second connected gamepad.
     */
    public void setSecondGamepad(GameConsoleUpgrade.Gamepad secondGamepad) {
        this.secondGamepad = secondGamepad;
    }

    /**
     * Sets the power state of the gaming console.
     *
     * @param on {@code true} to power on the gaming console, {@code false} to power off.
     */
//    public void setOn(boolean on) {
//        isOn = on;
//    }

    /**
     * Loads the specified game on the gaming console.
     *
     * @param game The game to load.
     */
    public void loadGame(Game game) { // По ТЗ метод выводит только сообщение. Тогда зачем ему параметр game ? Метод просто для красоты в виде вывода сообщения ?
        if (isOn) {
            activeGame = game; // Нужно ли ? Game activeGame попадает через конструктор.
            System.out.println("The game " + game.getName() + " is loading...");
        }
    }

    /**
     * Checks the status of the gaming console.
     *
     * @throws GameConsoleException If the gaming console is inactive for more than 5 cycles.
     */
    private void checkStatus() throws GameConsoleException {
        //Если оба джойстика выключены – выводить сообщение «Подключите джойстик» и увеличивать счетчик на 1.
        if (!firstGamepad.isOn() && !secondGamepad.isOn()) {
            System.out.println("Подключите джойстик");
            waitingCounter++;
        }
        //Если хотя-бы один джойстик активен – сбрасывать в 0.
        if (firstGamepad.isOn() || secondGamepad.isOn()) {
            waitingCounter = 0;
        }
        //Если счетчик превысил 5 циклов ожидания – «Выключить» приставку
        // и бросить исключение с текстом «Приставка завершает работу из-за отсутствия активности» (Класс-исключение создать свой.)
        if (waitingCounter >= 5) {
            powerOff();
            System.out.println("Выключение... \n5\n4\n3\n2\n1\n");
            throw new GameConsoleException("Приставка завершает работу из-за отсутствия активности");
        }
    }

    /**
     * Plays the active game on the gaming console.
     */
    public void playGame() throws GameConsoleException {
        checkStatus();
        if (isOn) {
            loadGame(activeGame); // Нужно ли ?
            System.out.println("The game " + activeGame.getName() + " is playing...");
            // информацию о заряде только активных джойстиков
            if (firstGamepad.isOn) {
                System.out.println("The 1 gamepad charge level is " + firstGamepad.getChargeLevel() + "%");
            }
            if (secondGamepad.isOn) {
                System.out.println("The 2 gamepad charge level is " + secondGamepad.getChargeLevel() + "%");
            }

            decreaseChargeLevel(firstGamepad, secondGamepad);
        }
    }

    /**
     * Decreases the charge level of the specified gamepad by 10%.
     *
     * @param gamepad1 The first gamepad.
     * @param gamepad2 The second gamepad.
     */
    private void decreaseChargeLevel(GameConsoleUpgrade.Gamepad gamepad1, GameConsoleUpgrade.Gamepad gamepad2) {
        if (gamepad1.isOn) {
            gamepad1.chargeLevel -= 10;
            if (gamepad1.chargeLevel == 0) {
                gamepad1.powerOff();
            }
        }
        if (gamepad2.isOn) {
            gamepad2.chargeLevel -= 10;
            if (gamepad2.chargeLevel == 0) {
                gamepad2.powerOff();
            }
        }
    }

    /**
     * Returns a string representation of the gaming console, including its brand, model, serial number,
     * power state, and information about connected gamepads.
     *
     * @return A string representation of the gaming console.
     */
    @Override
    public String toString() {
        return "GameConsole:" +
                "\n\tbrand = " + brand +
                "\n\tmodel = " + model +
                "\n\tserial = " + serial +
                "\n\tisOn = " + isOn +
                "\n\tfirstGamepad:" + firstGamepad +
                "\n\tsecondGamepad:" + secondGamepad;
    }

    /**
     * The {@code Gamepad} class represents an individual game controller associated with a gaming console.
     */
    public class Gamepad implements Powered {

        /**
         * The brand of the gamepad, defined by the {@code Brand} enum.
         */
        private final Brand brand;

        /**
         * The serial number of the gaming console to which the gamepad is connected.
         */
        private final String consoleSerial;

        /**
         * The connected number of the gamepad (1 for the first gamepad, 2 for the second).
         */
        private int connectedNumber;

        /**
         * The color of the gamepad, defined by the {@code Color} enum.
         */
        private Color color;

        /**
         * The charge level of the gamepad (in percentage).
         */
        private double chargeLevel = 100.0;

        /**
         * The power state of the gamepad.
         */
        private boolean isOn;

        /**
         * Constructs a {@code Gamepad} with the specified brand and connected number.
         *
         * @param brand           The brand of the gamepad.
         * @param connectedNumber The connected number of the gamepad.
         */
        public Gamepad(Brand brand, int connectedNumber) {
            this.brand = brand;
            this.connectedNumber = connectedNumber;
            this.consoleSerial = GameConsoleUpgrade.this.serial;
        }

        /**
         * Retrieves the brand of the gamepad.
         *
         * @return The brand of the gamepad.
         */
        public Brand getBrand() {
            return brand;
        }

        /**
         * Retrieves the serial number of the gaming console to which the gamepad is connected.
         *
         * @return The serial number of the connected gaming console.
         */
        public String getConsoleSerial() {
            return consoleSerial;
        }

        /**
         * Retrieves the connected number of the gamepad.
         *
         * @return The connected number of the gamepad.
         */
        public int getConnectedNumber() {
            return connectedNumber;
        }

        /**
         * Retrieves the color of the gamepad.
         *
         * @return The color of the gamepad.
         */
        public Color getColor() {
            return color;
        }

        /**
         * Retrieves the charge level of the gamepad.
         *
         * @return The charge level of the gamepad.
         */
        public double getChargeLevel() {
            return chargeLevel;
        }

        /**
         * Checks if the gamepad is powered on.
         *
         * @return {@code true} if the gamepad is powered on, {@code false} otherwise.
         */
        public boolean isOn() {
            return isOn;
        }

        /**
         * Sets the color of the gamepad.
         *
         * @param color The new color of the gamepad.
         */
        public void setColor(Color color) {
            this.color = color;
        }

        /**
         * Sets the charge level of the gamepad.
         *
         * @param chargeLevel The new charge level of the gamepad.
         */
        public void setChargeLevel(double chargeLevel) {
            this.chargeLevel = chargeLevel;
        }

        /**
         * Sets the power state of the gamepad.
         *
         * @param on {@code true} to power on the gamepad, {@code false} to power off.
         */
//        public void setOn(boolean on) {
//            isOn = on;
//        }

        /**
         * Powers on the gamepad.
         */
        @Override
        public void powerOn() {
            // Turn on gamepad
            this.isOn = true;
            // Turns on the console when the joystick is turned on
            GameConsoleUpgrade.this.powerOn();
        }

        /**
         * Powers off the gamepad.
         */
        @Override
        public void powerOff() {
            // Makes the “second” gamepad “first” if the first one was turned off.
            if (this.connectedNumber == 1) {
                getSecondGamepad().connectedNumber = 1;
                getFirstGamepad().connectedNumber = 2;
            }
            // Turn off gamepad
            this.isOn = false;
            // Turns off the console when the joystick is turned off
            if (!getFirstGamepad().isOn() && !getSecondGamepad().isOn()) {
                GameConsoleUpgrade.this.powerOff();
            }
        }

        /**
         * Returns a string representation of the gamepad, including its brand, connected console serial number,
         * connected number, color, charge level, and power state.
         *
         * @return A string representation of the gamepad.
         */
        @Override
        public String toString() {
            return "\n\t\tbrand = " + brand +
                    "\n\t\tconsoleSerial = " + consoleSerial +
                    "\n\t\tconnectedNumber = " + connectedNumber +
                    "\n\t\tcolor = " + color +
                    "\n\t\tchargeLevel = " + chargeLevel +
                    "\n\t\tisOn = " + isOn;
        }
    }
}
