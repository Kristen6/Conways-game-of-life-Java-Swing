import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    View view = new View();
    Model model = new Model();
    Controller controller = new Controller(model);
    controller.setView(view);
    view.setVisible(true); // Show the GUI;
  }
}
