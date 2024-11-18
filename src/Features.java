public interface Features {

    /***
     * start the generation of the game
     */
    void startGeneration();

    /***
     * pause the generation
     */
    void stopGeneration();

    /***
     * update the cell life in the model
     * @param i
     * @param j
     */
    void updateCell(int i, int j);
    /***
     * initialize the board in the model
     * @param n
     */
    void initializeBoard(int n);
}
