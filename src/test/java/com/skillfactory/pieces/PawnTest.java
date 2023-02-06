package com.skillfactory.pieces;

import com.skillfactory.ChessBoard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PawnTest {
    @Test
    public void pawnClassTest() {
        boolean check = Pawn.class.getSuperclass().getSimpleName().equals("ChessPiece");
        ChessBoard board = new ChessBoard("White");
        board.board[1][0] = new Pawn("White");
        board.board[6][1] = new Pawn("Black");

        check = check && board.board[1][0].canMoveToPosition(board, 1, 0, 2, 0) &&
                board.board[1][0].canMoveToPosition(board, 1, 0, 3, 0) &&
                !board.board[1][0].canMoveToPosition(board, 1, 0, 4, 0) &&
                !board.board[1][0].canMoveToPosition(board, 1, 0, 5, 0) &&
                !board.board[1][0].canMoveToPosition(board, 1, 0, 6, 0) &&
                !board.board[1][0].canMoveToPosition(board, 1, 0, 7, 0) &&
                !board.board[1][0].canMoveToPosition(board, 1, 0, 2, 1) &&
                !board.board[1][0].canMoveToPosition(board, 1, 0, -1, 1) &&

                board.board[6][1].canMoveToPosition(board, 6, 1, 5, 1) &&
                board.board[6][1].canMoveToPosition(board, 6, 1, 4, 1) &&
                !board.board[6][1].canMoveToPosition(board, 6, 1, 3, 1) &&
                !board.board[6][1].canMoveToPosition(board, 6, 1, 2, 1) &&
                !board.board[6][1].canMoveToPosition(board, 6, 1, 1, 1) &&
                !board.board[6][1].canMoveToPosition(board, 6, 1, 0, 1) &&
                !board.board[6][1].canMoveToPosition(board, 6, 1, 5, 2) &&
                !board.board[6][1].canMoveToPosition(board, 6, 1, 8, 1) &&
                board.board[1][0].getColor().equals("White") && board.board[6][1].getColor().equals("Black") &&
                board.board[1][0].getSymbol().equals("P") && board.board[6][1].getSymbol().equals("P");

        Assertions.assertTrue(check, "The Pawn moved is incorrect");
    }
}
