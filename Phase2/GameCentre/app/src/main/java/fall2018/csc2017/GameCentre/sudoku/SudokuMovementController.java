package fall2018.csc2017.GameCentre.sudoku;

import android.content.Context;
import android.widget.Toast;


public class SudokuMovementController {

    private SudokuBoardManager boardManager = null;

    public SudokuMovementController() {
    }

    public void setBoardManager(SudokuBoardManager boardManager) {
        this.boardManager = boardManager;
    }

    public void processTapMovement(Context context, int position, boolean display) {
        if (boardManager.isValidTap(position)) {
            Integer[] undoStep = new Integer[2];
            undoStep[0] = new Integer(position);
            undoStep[1] = new Integer(boardManager.getBoard().getCell(position / 9,
                    position % 9).getFadeValue());
            boardManager.addUndo(undoStep);
            boardManager.makeMove(position,
                    boardManager.getBoard().getCell(position / 9,
                            position % 9).getFaceValue());
            if (boardManager.boardSolved()) {
                Toast.makeText(context, "YOU WIN!", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(context, "Invalid Tap", Toast.LENGTH_SHORT).show();
        }
    }
}
