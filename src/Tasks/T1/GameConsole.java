package Tasks.T1;

/**
 * The {@code GameConsole} class represents a gaming console with associated gamepads.
 * It includes information such as the brand, model, serial number, power state, and connected gamepads.
 * The class also contains a nested {@code Gamepad} class that represents individual game controllers.
 */
public class GameConsole {

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
    private Gamepad firstGamepad;

    /**
     * The second connected gamepad.
     */
    private Gamepad secondGamepad;

    /**
     * The power state of the gaming console.
     */
    private boolean isOn;

    /**
     * Constructs a {@code GameConsole} with the specified brand, model, and serial number.
     *
     * @param brand  The brand of the gaming console.
     * @param model  The model of the gaming console.
     * @param serial The serial number of the gaming console.
     */
    public GameConsole(Brand brand, String model, String serial) {
        this.brand = brand;
        this.model = model;
        this.serial = serial;
        this.isOn = false;
        this.firstGamepad = new Gamepad(GameConsole.this.brand, 1);
        this.secondGamepad = new Gamepad(GameConsole.this.brand, 2);
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
    public Gamepad getFirstGamepad() {
        return firstGamepad;
    }

    /**
     * Retrieves the second connected gamepad.
     *
     * @return The second connected gamepad.
     */
    public Gamepad getSecondGamepad() {
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
     * Sets the model of the gaming console.
     *
     * @param model The new model of the gaming console.
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Sets the first connected gamepad.
     *
     * @param firstGamepad The new first connected gamepad.
     */
    public void setFirstGamepad(Gamepad firstGamepad) {
        this.firstGamepad = firstGamepad;
    }

    /**
     * Sets the second connected gamepad.
     *
     * @param secondGamepad The new second connected gamepad.
     */
    public void setSecondGamepad(Gamepad secondGamepad) {
        this.secondGamepad = secondGamepad;
    }

    /**
     * Sets the power state of the gaming console.
     *
     * @param on {@code true} to power on the gaming console, {@code false} to power off.
     */
    public void setOn(boolean on) {
        isOn = on;
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
    public class Gamepad {

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
        private final int connectedNumber;

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
            this.consoleSerial = GameConsole.this.serial;
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
        public void setOn(boolean on) {
            isOn = on;
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