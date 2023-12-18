## 1. Implementation of Inner Class

### GameConsole Class
- Create a class `GameConsole`.
- Define fields: `brand` (manufacturer's name), `model`, `serial` (serial number), `firstGamepad` (object for the first joystick, implemented as an inner class), `secondGamepad` (object for the second joystick), `isOn` (state flag: true - on, false - off).
- Create an inner (non-static) class `Gamepad`.
- Define fields: `brand`, `consoleSerial` (serial number of the connected console), `connectedNumber` (joystick's sequential number), `color` (joystick color), `chargeLevel` (charge level, default to 100.0), `isOn` (state flag).
- Create constructors for both classes.
- Apply the `final` modifier to non-changing fields, and create getters.
- Create setters for other fields.

## 2. Implementation of Nested Static Class

### Game Class
- Define fields (marked as `final`): `name`, `genre` (ACTION, SPORT, RACE), `type` (VIRTUAL, PHYSICAL).
- Create a private constructor that takes parameters: `name`, `genre`, `type`.
- Create getters for fields.
- Create a nested (static) class `GameDisk`.
- Define fields: `description` (game description), `data` (final).
- Create a private constructor that takes parameters: `name`, `genre`, `description`.
- Initialize `data` by creating an instance of the outer class `Game` and passing parameters.
- Create getters for the fields.
- Create a nested (static) class `VirtualGame`.
- Define fields: `rating` (game rating from 0 to 5), `data` (final).
- Create a private constructor that takes parameters: `name`, `genre`.
- Initialize `data` by creating an instance of the outer class `Game` and passing parameters.
- Create necessary getters and setters.
- Add static factory methods `getDisk` and `getVirtualGame` to the `Game` class.

## 3. Create PlayRoom Class

- In the `main` method:
    - Create an array of physical disk games (4 games) using the `getDisk` method.
    - Create an array of virtual store games (4 games) using the `getVirtualGame` method.
    - Create an instance of `GameConsole`.

## 4. Implementation of Anonymous Class (Comparator)

- In the `main` method:
    - Sort the array of physical disks by genre.
    - Sort the array of virtual games by rating using `Integer.compare(a.getRating(), b.getRating())`.

## 5. Enhance GameConsole Class

- Create an interface `Powered` with `powerOn` and `powerOff` methods.
- Implement the interface for both the joystick and console.
- Add functionality to turn on the console when the joystick is turned on.
- Make the "second" joystick "first" if the first one is turned off.
- Add a field `activeGame`.
- Add methods `loadGame(Game)` and `playGame()`.
- In `playGame()`, display information about the current game and the charge level of active joysticks.
- Decrease the joystick charge by 10% each time `playGame()` is called, and turn off the joystick when the charge reaches 0.
- Add a private method `checkStatus()`, which is called each time `playGame()` is invoked.
- Introduce a new field `waitingCounter` to the `GameConsole` class.
- Display a message and increment the counter if both joysticks are turned off.
- Reset the counter to 0 if at least one joystick is active.
- If the counter exceeds 5 cycles of waiting, turn off the console and throw an exception with the message "The console is shutting down due to inactivity."
