package fall2018.csc2017.GameCentre.util;

import android.content.Context;
import android.widget.Toast;

public class MovementController {

    /**
     * The BoardManager to control.
     */
    private BoardManagerForBoardGames boardManager = null;

    /**
     * Default constructor for movement controller.
     */
    public MovementController() {
    }

    /**
     * Setter function for the boardManager.
     */
    public void setBoardManager(BoardManagerForBoardGames boardManager) {
        this.boardManager = boardManager;
    }

    /**
     * Performs tap movement for the game.
     */
    public void processTapMovement(Context context, int position, int value, boolean display) {
        if (boardManager.isValidTap(position)) {
            boardManager.makeMove(position, value);
            if (boardManager.boardSolved()) {
                Toast.makeText(context, "YOU WIN!", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(context, "Invalid Tap", Toast.LENGTH_SHORT).show();
        }
    }
}
