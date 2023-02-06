package com.skillfactory.pieces;

import com.skillfactory.ChessBoard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HorseTest {

    @Test
    public void horseClassTest() {
        boolean check = Horse.class.getSuperclass().getSimpleName().equals("ChessPiece");
        ChessBoard board = new ChessBoard("White");
        board.board[3][3] = new Horse("White");
        for (int i = 10; i > -5; i--) {
            for (int j = -3; j < 9; j++) {
                boolean b = (i == 2 && j == 1) || (i == 4 && j == 1) ||
                        (i == 1 && j == 2) || (i == 5 && j == 2) ||
                        (i == 1 && j == 4) || (i == 5 && j == 4) ||
                        (i == 2 && j == 5) || (i == 4 && j == 5);
                if (board.board[3][3].canMoveToPosition(board, 3, 3, i, j)) {

                } else {
                    if (b) {
                        check = false;
                    }
                }
            }
        }
        board.board[0][0] = new Horse("White");

        check = check && !board.board[0][0].canMoveToPosition(board, 0, 0, -2, -1);

        Assertions.assertTrue(check, "The Horse moved is incorrect");
    }
}
