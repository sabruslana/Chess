package com.skillfactory.pieces;

import com.skillfactory.ChessBoard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueenTest {
    @Test
    public void queenClassTest() {
        boolean check = Queen.class.getSuperclass().getSimpleName().equals("ChessPiece");
        ChessBoard board = new ChessBoard("White");
        board.board[3][3] = new Queen("White");
        ChessPiece queen = board.board[3][3];

        for (int i = 10; i > -5; i--) {
            for (int j = -3; j < 9; j++) {
                boolean b = (i == 2 && j == 2) || (i == 1 && j == 1) ||
                        (i == 0 && j == 0) || (i == 4 && j == 4) ||
                        (i == 5 && j == 5) || (i == 6 && j == 6) ||
                        (i == 7 && j == 7) ||
                        (i == 4 && j == 2) || (i == 5 && j == 1) ||
                        (i == 6 && j == 0) || (i == 2 && j == 4) ||
                        (i == 1 && j == 5) || (i == 0 && j == 6) ||
                        (i == 3 && j == 2) || (i == 3 && j == 1) ||
                        (i == 3 && j == 0) || (i == 3 && j == 4) ||
                        (i == 3 && j == 5) || (i == 3 && j == 6) ||
                        (i == 3 && j == 7) ||
                        (i == 2 && j == 3) || (i == 1 && j == 3) ||
                        (i == 0 && j == 3) || (i == 4 && j == 3) ||
                        (i == 5 && j == 3) || (i == 6 && j == 3) ||
                        (i == 7 && j == 3);
                if (queen.canMoveToPosition(board, 3, 3, i, j)) {
                    if (!b) {
                        check = false;
                    }
                } else {
                    if (b) {
                        check = false;
                    }
                }
            }
        }

        Assertions.assertTrue(check && queen.getSymbol().equals("Q") && queen.getColor().equals("White"), "The Queen moved is incorrect");
    }
}
