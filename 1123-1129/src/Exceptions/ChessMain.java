package Exceptions;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ChessMain {

    public static void main(String[] args) throws FileNotFoundException {
        ChessFileReader chessFileReader = new ChessFileReader("Txt/chess.txt");
        for (int i = 0; i < chessFileReader.text.size(); i++) {
            System.out.println(chessFileReader.text.get(i));

        }
        ArrayList <String> arr = new ArrayList<>(chessFileReader.text);

    }

    public static void checkNrOfPieces(ArrayList<String> chess){
       int pieceCounter = 0;
        for (int i = 0; i < chess.size(); i++) {
            for (int j = 0; j < chess.size(); j++) {
                if (chess.get(i).charAt(j) != ' '){
                    pieceCounter++;
                }
            }
        }
        if (pieceCounter !=32){
            
        }
    }
}
