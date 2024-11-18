import java.util.Arrays;

public class Model implements IModel {
  private Cell board[][];

  public Model() {
  }

  public Model(Cell[][] board) {
    this.board = board;
  }

  /***
   * set the size of the board
   * @param size
   */
  private void setSize(int size) {
    this.board = new Cell[size][size];
  }

  /***
   * initialize the board with initial configuration
   */
  @Override
  public void initializeBoard(int size) {
    this.setSize(size);
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        board[i][j] = new Cell(false);
      }
    }
  }

  /***
   * take in the x,y coordinate of the cell, get the cell object and return a new cell
   * @param x
   * @param y
   * @return
   */
  @Override
  public void updateCell(int x, int y) {
    board[x][y].toggleLife();
  }

  /***
   * return a new model with cells updated to the expected values according to the rule
   * rules:
   *      - A creature that has two or three neighbors will continue live in the next generation.
   *      - A creature that has more than 3 neighbors will die of overcrowding. Its cell will be
   *          empty in the next generation.
   *      - A creature that has less than 2 neighbors will die of loneliness.
   *      - A new creature born in an empty cell that has exactly 3 neighbors.
   */
  @Override
  public IModel updateBoard() {
    int[] checkArray = {-1, 0, 1};

    int rows = this.board.length;
    int cols = this.board[0].length;

    // make a 2D copyArray to keep the original initialBoard;
    Cell[][] copy = new Cell[rows][cols];

    for (int i = 0; i < rows; i++) {
      for (int i1 = 0; i1 < cols; i1++) {
        copy[i][i1] = new Cell(board[i][i1].isHasLife());
      }
    }

    // update the initialBoard;
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {

        // go through the 8 cell around the specific cell.
        int oneAroundIt = 0;
        for (int i2 = 0; i2 < 3; i2++) {
          for (int i3 = 0; i3 < 3; i3++) {
            int r = row + checkArray[i2];
            int c = col + checkArray[i3];

            // count how many one around it.
            if (r >= 0 && r < rows && c >= 0 && c < cols && board[r][c].isHasLife()) {
              oneAroundIt++;
            }
          }
        }

        // don't add this specific cell if it's 1.
        if (board[row][col].isHasLife()) {
          oneAroundIt--;

          // 2. A creature that has more than 3 neighbors will die of overcrowding. Its cell will be
          // empty in the next generation.
          // 3. A creature that has less than 2 neighbors will die of loneliness.
          if (oneAroundIt > 3 || oneAroundIt < 2) {
            copy[row][col].toggleLife();
          }

          // 4. A new creature born in an empty cell that has exactly 3 neighbors.
        } else if (oneAroundIt == 3) {
          copy[row][col].toggleLife();
        }
      }
    }
    return new Model(copy);
  }

  public Cell getCell(int x, int y) {
    return board[x][y];
  }

  @Override
  public String toString() {
    return Arrays.deepToString(board);
  }
}