package Ötbetűs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class FileReader {

   protected ArrayList<String> words;
   protected TreeMap<Character,ArrayList<String>> wordsMap = new TreeMap<>();

    public FileReader() throws FileNotFoundException {
        words = new ArrayList<>(read());
    }

    public ArrayList<String> read() throws FileNotFoundException {
        ArrayList<String> words2 = new ArrayList<>();
        File file = new File("Txt/words.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNext()){
            String word = sc.next();
            if (word.length() == 5){
                words2.add(word);
                wordsMap.putIfAbsent(word.charAt(0), new ArrayList<>());
                wordsMap.get(word.charAt(0)).add(word);
            }
        }
        return words2;
    }

    public ArrayList<String> getWords() {
        return words;
    }
}
