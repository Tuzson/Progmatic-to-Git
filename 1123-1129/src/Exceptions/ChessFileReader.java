package Exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ChessFileReader {
    ArrayList<String> text;
    String filePath;

    public ChessFileReader(String filePath) throws FileNotFoundException {
        this.filePath = filePath;
        text = new ArrayList<>(isItAChessFile(filePath));
    }

    public ArrayList<String> isItAChessFile(String filePath) throws FileNotFoundException {
        Chess chess = new Chess();
        ArrayList<String> chessList = new ArrayList<>();
        File file;
        Scanner sc = null;
        int nrOfLine = 0;
        String s = null;
        boolean isGoodFilePath = false;
        while (!isGoodFilePath) {
            try {
                file = new File(filePath);
                sc = new Scanner(file);
                isGoodFilePath = true;
            }catch (FileNotFoundException e) {
                System.out.println("Nem megfelelő elérési útvonal. Írj be egy másikat");
                isGoodFilePath = false;
                sc = new Scanner(System.in);
                filePath = sc.next();
            }


        }
        try {
            for (int i = 1; sc.hasNextLine(); i++) {
                nrOfLine = i;
                s = sc.nextLine();

                chessList.add(s);
                if (s.length() != chess.nrOfColumn) {
                    throw new InvalidChessBoardException();
                }
            }
            if (nrOfLine != chess.nrOfLine) {
                throw new InvalidChessBoardException();
            }
            for (int i = 0; i < chessList.size(); i++) {
                for (int j = 0; j < chessList.size(); j++) {
                    if (!(chess.chessPieces.contains(chessList.get(i).charAt(j)) || chessList.get(i).charAt(j) == ' ')) {
                        throw new InvalidChessBoardException();
                    }
                }
            }

        } catch (InvalidChessBoardException e) {
            if (s.length() != chess.nrOfColumn) {
               System.out.println("A beolvasott file nem egy sakkjátszma állását tartalmazza, mert a oszlopok száma nem egyezik meg egy sakktábláéval.");
            } else if (nrOfLine != chess.nrOfLine) {
                System.out.println("A beolvasott file nem egy sakkjátszma állását tartalmazza, mert a sorok száma nem egyezik meg egy sakktábláéval.");
            } else {
                System.out.println("A beolvasott file nem egy sakkjátszma állását tartalmazza, mert a karakterek eltérnek az elvárttól.");
            }

        }
        return chessList;

    }
}
