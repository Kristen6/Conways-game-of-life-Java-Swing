public class Cell {

  private boolean hasLife;

  public Cell(boolean life) {
    hasLife = life;
  }

  public boolean isHasLife() {
    return hasLife;
  }

  public void toggleLife() {
    hasLife = !hasLife;
  }

  @Override
  public String toString() {
    return Boolean.toString(hasLife);
  }
}
