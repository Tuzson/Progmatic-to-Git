package Exceptions;

import java.util.ArrayList;

public abstract class ChessPieces {
   protected ArrayList <Character> chessPieces;

    public ChessPieces() {
        chessPieces = new ArrayList<>();
        chessPieces.add('\u2654');
        chessPieces.add('\u2655');
        chessPieces.add('\u2656');
        chessPieces.add('\u2657');
        chessPieces.add('\u2658');
        chessPieces.add('\u2659');
        chessPieces.add('\u265A');
        chessPieces.add('\u265B');
        chessPieces.add('\u265C');
        chessPieces.add('\u265D');
        chessPieces.add('\u265E');
        chessPieces.add('\u265F');

    }
}
