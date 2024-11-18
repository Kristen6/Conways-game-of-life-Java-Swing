public interface IView {

    void addFeatures(Features features);

    /***
     * Update the view with the new model
     * @param board
     */
    void updateGameBoard(boolean[][] board);
}
