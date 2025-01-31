# Conway's Game of Life

Conway's Game of Life is a cellular automaton simulation where cells on a grid evolve based on a set of simple rules. This interactive version allows you to set up the board, start the simulation, and watch the patterns emerge.

## Demo Video

[Click here to watch the demo video](video_IntroductionOfTheGame/project_Presentation.mp4)

## Before Playing the Game:

You must have Java installed on your computer:

**Option 1**:  
Download the **"Conway's_Game_of_Life_Project.jar"** and double-click to play the game.  
(if you use macOS, it may show "macOS cannot verify that this app is free from malware."  
Method: Manually Allow the JAR File
1. Try running the JAR file, and macOS will show a warning.
2. Go to "System Settings" > "Privacy & Security".
3. Scroll down to the Security section, where macOS will list the blocked app.
4. Click "Allow Anyway".
5. Try running the JAR file again. This time, macOS will still show a warning but will give you an "Open" option—click it to proceed.)

**Option 2**:  
Download the `src` folder containing all the classes, then compile and run the `Main` class to start the game.

## How to Play

1. **Set the Board Size**
    - Input a number to define the board size (e.g., `10` for a 10x10 grid).
    - Click **"OK"** to generate the board.

2. **Set the Initial State**
    - The board consists of white buttons representing dead cells.
    - Click any white button to activate it (turns yellow, representing a living cell).
    - Click an activated (yellow) cell again to deactivate it (turns back to white).

3. **Start the Game**
    - Click **"Start"** to begin the simulation.
    - The cells will follow Conway's Game of Life rules to survive, reproduce, or die in successive generations.

4. **Pause the Game**
    - Click **"Stop"** to pause the simulation.
    - While paused, you can click buttons to modify the board manually.

5. **Reset the Board**
    - If you'd like to start over, click **"Reset"** to clear the board.

## Conway's Rules

1. **Any live cell with fewer than two live neighbors dies (underpopulation).**
2. **Any live cell with two or three live neighbors survives.**
3. **Any live cell with more than three live neighbors dies (overpopulation).**
4. **Any dead cell with exactly three live neighbors becomes a live cell (reproduction).**

## Enjoy the Game!

Experiment with different initial setups to discover fascinating patterns like oscillators, still lifes, or gliders. Have fun exploring the world of Conway's Game of Life!
