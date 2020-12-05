package Ötbetűs;

import java.util.Scanner;

public class User {

    private String userWord;
    private int answer = 0;

    public String getUserWord() {
        return userWord;
    }

    public void letsTryAnotherWord() {
        boolean goodWord = false;
        System.out.println("Írj be egy 5 betűs szót");
        Scanner sc = new Scanner(System.in);
        String word = null;
        while (!goodWord) {
            try {
                goodWord = true;
                word = sc.next().toLowerCase();
                if (word.length() != 5) {
                    throw new not5CharWordException();
                }
                for (int i = 0; i < word.length(); i++) {
                    switch (word.charAt(i)) {
                        case 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 -> throw new notWordException();
                    }

                }

            } catch (not5CharWordException e) {
                System.out.println("A szó nem 5 betű. Adj meg 5 betűs szót.");
                goodWord = false;
                sc = new Scanner(System.in);
            } catch (notWordException e) {
                System.out.println("A szóban szám szerepel. Kérlek adj meg értelmes szót.");
                goodWord = false;
                sc = new Scanner(System.in);
            }


        }
        userWord = word;
    }

    public void letsThinkAWord() {
        boolean goodWord = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Írj be egy szót amire gondolsz és a gép megpróbálja kitalálni.");
        while (!goodWord) {
            try {
                goodWord = true;
                userWord = sc.next().toLowerCase();
                if (userWord.length() != 5) {
                    throw new not5CharWordException();
                }
                for (int i = 0; i < userWord.length(); i++) {
                    switch (userWord.charAt(i)) {
                        case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> throw new notWordException();
                    }

                }
            } catch (not5CharWordException e) {
                System.out.println("A szó nem 5 betű. Adj meg 5 betűs szót.");
                goodWord = false;
                sc = new Scanner(System.in);
            } catch (notWordException e) {
                System.out.println("A szóban szám szerepel. Kérlek adj meg értelmes szót.");
                goodWord = false;
                sc = new Scanner(System.in);
            }
        }

    }

    public int wordCheck(String botWord){
        answer = 0;
        for (int i = 0; i < botWord.length(); i++) {
            if (botWord.charAt(i) == userWord.charAt(i)){
                answer++;
            }
        }
        return answer;
    }

    public int getAnswer() {
        return answer;
    }
}
