package com.skillfactory.pieces;

import com.skillfactory.ChessBoard;

public class Rook extends ChessPiece{
    public Rook(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        return false;
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}
