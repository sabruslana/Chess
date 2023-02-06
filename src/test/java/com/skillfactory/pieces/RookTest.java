package com.skillfactory.pieces;

import com.skillfactory.ChessBoard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RookTest {
    @Test
    public void rookClassTest() {
        boolean check = Rook.class.getSuperclass().getSimpleName().equals("ChessPiece");
        ChessBoard board = new ChessBoard("White");
        board.board[3][3] = new Rook("White");
        ChessPiece rook = board.board[3][3];

        for (int i = 10; i > -5; i--) {
            for (int j = -3; j < 9; j++) {
                boolean b = (i == 3 && j == 2) || (i == 3 && j == 1) ||
                        (i == 3 && j == 0) || (i == 3 && j == 4) ||
                        (i == 3 && j == 5) || (i == 3 && j == 6) ||
                        (i == 3 && j == 7) ||
                        (i == 2 && j == 3) || (i == 1 && j == 3) ||
                        (i == 0 && j == 3) || (i == 4 && j == 3) ||
                        (i == 5 && j == 3) || (i == 6 && j == 3) ||
                        (i == 7 && j == 3);
                if (rook.canMoveToPosition(board, 3, 3, i, j)) {
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

        Assertions.assertTrue(check && rook.getSymbol().equals("R") && rook.getColor().equals("White"), "The Rook moved is incorrect");
    }
}
