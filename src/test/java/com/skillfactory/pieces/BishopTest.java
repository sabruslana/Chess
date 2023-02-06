package com.skillfactory.pieces;

import com.skillfactory.ChessBoard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BishopTest {
    @Test
    public void bishopClassTest() {
        boolean check = Bishop.class.getSuperclass().getSimpleName().equals("ChessPiece");
        ChessBoard board = new ChessBoard("Black");
        board.board[3][3] = new Bishop("Black");
        ChessPiece bishop = board.board[3][3];

        for (int i = 10; i > -5; i--) {
            for (int j = -3; j < 9; j++) {
                boolean b = (i == 2 && j == 2) || (i == 1 && j == 1) ||
                        (i == 0 && j == 0) || (i == 4 && j == 4) ||
                        (i == 5 && j == 5) || (i == 6 && j == 6) ||
                        (i == 7 && j == 7) ||
                        (i == 4 && j == 2) || (i == 5 && j == 1) ||
                        (i == 6 && j == 0) || (i == 2 && j == 4) ||
                        (i == 1 && j == 5) || (i == 0 && j == 6);
                if (bishop.canMoveToPosition(board, 3, 3, i, j)) {
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

        check = check && !bishop.canMoveToPosition(board, 3, 3, -1, -1) && !bishop.canMoveToPosition(board, 3, 3, 8, 8);

        Assertions.assertTrue(check && bishop.getSymbol().equals("B") && bishop.getColor().equals("Black"), "The Bishop moved is incorrect");
    }
}
