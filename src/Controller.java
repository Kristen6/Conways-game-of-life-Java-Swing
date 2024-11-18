public class Controller implements Features{
  private IModel model;
  private IView view;
  private volatile boolean running; // Flag to control the game loop

  /***
   * constructor to take in the model
   * @param m
   */
  public Controller(IModel m) {
    this.model = m;
  }

  /***
   * add the view
   * @param v
   */
  public void setView(IView v) {
    view = v;
    //provide view with all the callbacks
    view.addFeatures(this);
  }

  /***
   * start the generation of the game
   */
  @Override
  public void startGeneration() {
    running = true;
    Thread generationThread = new Thread(() -> {
      while (running) {
        model = (Model) model.updateBoard(); // Update the model
        updateView(); // Update the view with the new model
        try {
          Thread.sleep(1000); // Delay between generations (adjust as needed)
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });
    generationThread.start();
  }

  /***
   * pause the generation
   */
  @Override
  public void stopGeneration() {
    running = false;
    updateView();
  }

  /***
   * update the cell life in the model
   * @param i
   * @param j
   */
  @Override
  public void updateCell(int i, int j) {
    model.updateCell(i, j); // Update the cell in the model
    updateView(); // Update the view with the new model
  }

  /***
   * initialize the board in the model
   * @param userInputSize
   */
  @Override
  public void initializeBoard(int userInputSize) {
    model.initializeBoard(userInputSize);
  }

  private void updateView() {
    String boardString = model.toString(); // Get string representation of the board

    // Parse the string representation and convert it into a boolean array
    String[] rows = boardString.substring(2, boardString.length() - 2).split("\\], \\[");
    boolean[][] booleanBoard = new boolean[rows.length][];
    for (int i = 0; i < rows.length; i++) {
      String[] cols = rows[i].split(", ");
      booleanBoard[i] = new boolean[cols.length];
      for (int j = 0; j < cols.length; j++) {
        booleanBoard[i][j] = Boolean.parseBoolean(cols[j]);
      }
    }

    // Update the view with the boolean array representing the board
    view.updateGameBoard(booleanBoard);
  }
}
