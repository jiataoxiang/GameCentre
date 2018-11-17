package fall2018.csc2017.GameCentre;


import org.junit.Test;

import java.util.ArrayList;

import fall2018.csc2017.GameCentre.Soduku.SudokuBoard;
import fall2018.csc2017.GameCentre.Soduku.SudokuBoardManager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SudokuUnitTest {

    /**
     * The SudokuBoardManager for test.
     */
    private SudokuBoardManager boardManager;

    /**
     * Make a solved SudokuBoard.
     */
    private void setUpCorrect() {
        this.boardManager = new SudokuBoardManager();
    }


    /**
     * Checks whether each row has numbers 1 to 9.
     */
    @Test
    public void horizontallySetUp() {
        setUpCorrect();
        SudokuBoard board = boardManager.getBoard();
        ArrayList<ArrayList<Integer>> horizontal =
                new ArrayList<ArrayList<Integer>>();
        for (int row = 0; row < 9; row++) {
            ArrayList<Integer> rows = new ArrayList<Integer>();
            for (int column = 0; column < 9; column++) {
                rows.add(board.getBox(row, column).getSolutionValue());
            }
            horizontal.add(rows);
        }
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                assertTrue(horizontal.get(row).contains(column + 1));
            }
        }
    }

    /**
     * Checks whether each column has numbers 1 to 9.
     */
    @Test
    public void verticallySetUp() {
        setUpCorrect();
        SudokuBoard board = boardManager.getBoard();
        ArrayList<ArrayList<Integer>> horizontal =
                new ArrayList<ArrayList<Integer>>();
        for (int column = 0; column < 9; column++) {
            ArrayList<Integer> rows = new ArrayList<Integer>();
            for (int row = 0; row < 9; row++) {
                rows.add(board.getBox(row, column).getSolutionValue());
            }
            horizontal.add(rows);
        }
        boolean result = true;
        for (int column = 0; column < 9; column++) {
            for (int row = 0; row < 9; row++) {
                if (!horizontal.get(column).contains(row + 1)) {
                    result = false;
                    break;
                };
            }
        }
        assertTrue(result);
    }

    /**
     * Checks whether each column has numbers 1 to 9.
     */
    @Test
    public void boxSetUp() {
        setUpCorrect();
        SudokuBoard board = boardManager.getBoard();
        ArrayList<ArrayList<Integer>> boxes =
                new ArrayList<ArrayList<Integer>>();
        int columnStarting = 0;
        int rowStarting = 0;
        while (columnStarting != 9) {
            ArrayList<Integer> box = new ArrayList<Integer>();
            for (int column = columnStarting;
                 column < columnStarting + 3;
                 column++) {
                if (column == columnStarting) {
                    box = new ArrayList<Integer>();
                }
                for (int row = rowStarting; row < rowStarting + 3; row++) {
                    box.add(board.getBox(row, column).getSolutionValue());
                }
            }
            boxes.add(box);
            if (rowStarting == 6) {
                rowStarting = 0;
                columnStarting += 3;
            } else {
                rowStarting += 3;
            }
        }
        boolean result = true;
        for (int boxNumber = 0; boxNumber < 9; boxNumber++) {
            for (int boxIndex = 0; boxIndex < 9; boxIndex++) {
                if (!boxes.get(boxNumber).contains(boxIndex + 1)) {
                    result = false;
                    break;
                };
            }
        }
        assertTrue(result);
    }




}
