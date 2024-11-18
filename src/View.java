import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class View extends JFrame implements IView {

  private boolean gameRunning = false;
  private JLabel promptSize;
  private JTextField size;
  private String input;
  int outputSize;
  private JButton ok;
  private JButton startStopButton;
  private JButton resetButton;
  private JPanel gameBoard;

  /***
   * constructor to start the initial page users see
   */
  public View() {
    super("✨The Game Of Life✨");
    setSize(600, 600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());

    JPanel buttonPanel = new JPanel();
    add(buttonPanel, BorderLayout.NORTH);
    buttonPanel.setBackground(Color.LIGHT_GRAY);

    promptSize = new JLabel("Please enter the size of the board(Integer and 3 is the minimum): ");
    buttonPanel.add(promptSize);

    size = new JTextField(3);
    size.getDocument().addDocumentListener(new DocumentListener() {
      @Override
      public void insertUpdate(DocumentEvent e) {
        updateButtonState();
      }

      @Override
      public void removeUpdate(DocumentEvent e) {
        updateButtonState();
      }

      @Override
      public void changedUpdate(DocumentEvent e) {
        updateButtonState();
      }
    });
    buttonPanel.add(size);

    ok = new JButton("OK");
    ok.setEnabled(false);
    buttonPanel.add(ok);

    resetButton = new JButton("RESET");
    resetButton.setEnabled(false);
    buttonPanel.add(resetButton);

    // Add a "Start" button;
    startStopButton = new JButton("START!");
    startStopButton.setEnabled(false);
    add(startStopButton, BorderLayout.SOUTH);
  }

  /***
   * create a game board component and assign each cell an actionListener
   * @param n
   * @param features
   */
  private void createGameBoard(int n, Features features) {
    gameBoard = new JPanel();
    gameBoard.setLayout(new GridLayout(n, n));
    gameBoard.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    gameBoard.setSize(20 * n, 20 * n);
    features.initializeBoard(n);

    // Create individual cells for the grid
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        JButton cell = new JButton();
        int finalI = i;
        int finalJ = j;

        cell.setOpaque(true);
        cell.setBackground(Color.white);
        cell.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            // change button color
            if (cell.getBackground().equals(Color.yellow)) {
              cell.setBackground(Color.white);
            } else {
              cell.setBackground(Color.yellow);
            }
            // update the status;
            features.updateCell(finalI, finalJ);
          }
        });
        gameBoard.add(cell);
      }
    }
  }

  private void resetGame() {
    gameRunning = false;
    startStopButton.setText("START!");
    if (gameBoard != null) {
      remove(gameBoard); // Remove the game board from the view
    }
    revalidate(); // Revalidate the frame
    repaint(); // Repaint the frame
  }

  public void addFeatures(Features features) {
    startStopButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        gameRunning = !gameRunning;
        if (gameRunning) {
          startStopButton.setText("STOP!");
          features.startGeneration();
        } else {
          startStopButton.setText("START!");
          features.stopGeneration();
        }
      }
    });
    ok.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        outputSize = Integer.parseInt(input);
        createGameBoard(outputSize, features);
        ok.setEnabled(false);
        size.setEnabled(false);
        add(gameBoard, BorderLayout.CENTER);

        pack();
        revalidate();
        startStopButton.setEnabled(true);
        resetButton.setEnabled(true);
      }
    });

    resetButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        resetButton.setEnabled(false);
        size.setEnabled(true);
        features.stopGeneration();
        resetGame();
      }
    });
  }

  /***
   * Update the view with the new model
   * @param booleanBoard
   */
  @Override
  public void updateGameBoard(boolean[][] booleanBoard) {
    // Iterate over the game board JPanel's components (cells)
    Component[] components = gameBoard.getComponents();
    for (int i = 0; i < components.length; i++) {
      JButton cell = (JButton) components[i];
      int row = i / booleanBoard.length; // Calculate row index
      int col = i % booleanBoard.length; // Calculate column index

      // Set the cell color based on the corresponding cell state in the provided boolean array
      if (booleanBoard[row][col]) {
        cell.setBackground(Color.yellow); // Alive cell color
      } else {
        cell.setBackground(Color.WHITE); // Dead cell color
      }
//      if (gameRunning) {
//        cell.setEnabled(false);
//      } else {
//        cell.setEnabled(true);
//      }
    }
    // Repaint the game board to reflect the changes
    gameBoard.repaint();
  }

  private void updateButtonState() {
    input = size.getText().trim();
    boolean isValid = input.matches("\\d+");

    ok.setEnabled(!input.isEmpty() && isValid && equalBigger3());
  }

  public boolean equalBigger3() {
    return Integer.parseInt(input) >= 3;
  }
}
