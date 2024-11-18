# Conway's Game of Life

Conway's Game of Life is a cellular automaton simulation where cells on a grid evolve based on a set of simple rules. This interactive version allows you to set up the board, start the simulation, and watch the patterns emerge.

## How to Play
## Demo Video

[Click here to watch the demo video](video_IntroductionOfTheGame/project_Presentation.mp4)


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