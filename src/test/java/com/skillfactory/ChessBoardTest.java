package com.skillfactory;

import com.skillfactory.pieces.Horse;
import com.skillfactory.pieces.King;
import com.skillfactory.pieces.Rook;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ChessBoardTest {
    @Test
    public void castlingTest() {
        boolean check;
        ChessBoard board = new ChessBoard("White");
        board.board[0][7] = new Rook("White");
        board.board[0][4] = new King("White");
        board.board[7][7] = new Rook("Black");
        board.board[7][4] = new King("Black");
        board.castling7();
        check = board.board[0][7] == null && board.board[0][4] == null && board.board[7][7] != null &&
                board.board[7][4] != null && board.board[0][6].getSymbol().equals("K") &&
                board.board[0][5].getSymbol().equals("R");
        board.castling7();
        check = check && board.board[7][4] == null && board.board[7][7] == null &&
                board.board[7][6].getSymbol().equals("K") && board.board[7][5].getSymbol().equals("R");

        check = check && board.board[0][6].getColor().equals("White") && board.board[0][5].getColor().equals("White") &&
                board.board[7][6].getColor().equals("Black") && board.board[7][5].getColor().equals("Black");

        ChessBoard board1 = new ChessBoard("White");
        board1.board[0][4] = new King("White");
        board1.board[0][7] = new Horse("White");
        check = check && !board1.castling7();

        board1.board[0][7] = new Rook("White");
        board1.moveToPosition(0, 7, 0, 6);
        board1.nowPlayer = "White";
        board1.moveToPosition(0, 6, 0, 7);
        board1.nowPlayer = "White";
        check = check && !board1.castling7();

        Assertions.assertTrue(check, "The castling7() is incorrect");
    }
}
