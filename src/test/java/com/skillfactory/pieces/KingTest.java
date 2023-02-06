package com.skillfactory.pieces;

import com.skillfactory.ChessBoard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KingTest {
    @Test
    public void kingClassTest() {
        boolean check = King.class.getSuperclass().getSimpleName().equals("ChessPiece");

        ChessBoard board = new ChessBoard("White");
        board.board[3][3] = new King("White");
        ChessPiece king = board.board[3][3];

        for (int i = 10; i > -5; i--) {
            for (int j = -3; j < 9; j++) {
                boolean b = (i == 3 && j == 2) || (i == 3 && j == 4) ||
                        (i == 4 && j == 3) || (i == 2 && j == 3) ||
                        (i == 4 && j == 4) || (i == 2 && j == 2) ||
                        (i == 4 && j == 2) ||
                        (i == 2 && j == 4);
                if (king.canMoveToPosition(board, 3, 3, i, j)) {
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

        Assertions.assertTrue(check && king.getSymbol().equals("K") && king.getColor().equals("White"), "The King moved is incorrect");
    }
}
