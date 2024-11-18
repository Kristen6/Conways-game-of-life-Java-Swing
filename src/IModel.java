public interface IModel {

    /***
     * initialize the board with initial configuration
     */
    void initializeBoard(int size);

    /***
     * take in the x,y coordinate of the cell, get the cell object and mutate the given cell
     * @param x
     * @param y
     * @return
     */
    void updateCell(int x, int y);

    /***
     * return a new model with cells updated to the expected values according to the rule
     * rules:
     *      - A creature that has two or three neighbors will continue live in the next generation.
     *      - A creature that has more than 3 neighbors will die of overcrowding. Its cell will be
     *          empty in the next generation.
     *      - A creature that has less than 2 neighbors will die of loneliness.
     *      - A new creature born in an empty cell that has exactly 3 neighbors.
     */
    IModel updateBoard();
}
