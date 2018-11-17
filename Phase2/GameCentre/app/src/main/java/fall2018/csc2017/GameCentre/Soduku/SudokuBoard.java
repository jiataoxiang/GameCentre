package fall2018.csc2017.GameCentre.Soduku;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

public class SudokuBoard implements Serializable {

    /**
     * The cells on the board.
     */
    private Cell[][] cells = new Cell[9][9];

    /**
     * A new board of cells in row-major order.
     * Precondition: len(cells) == 81.
     *
     * @param cells the cells for the board
     */
    SudokuBoard(List<Cell> cells) {
        Iterator<Cell> iterator = cells.iterator();

        for (int row = 0; row != 9; row++) {
            for (int col = 0; col != 9; col++) {
                this.cells[row][col] = iterator.next();
            }
        }
    }

    /**
     * Get the box at the ith row and jth column
     */
    public Cell getBox(int row, int column) {
        return this.cells[row][column];
    }

    /**
     * Check whether the box at the ith row and jth column
     * has been correctly solved.
     */
    boolean checkBox(int row, int col) {
        return this.cells[row][col].checkValue();
    }

    /**
     * Check whether the face value of box at the ith row and
     * jth column can be edited.
     */
    boolean checkEditable(int row, int col) {
        return this.cells[row][col].isEditable();
    }
}