package com.skillfactory.pieces;

import com.skillfactory.ChessBoard;

public class King extends ChessPiece {
    public King(String color) {
        super(color);
    }

    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
        return false;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        return false;
    }

    @Override
    public String getSymbol() {
        return "K";
    }
}
