package Ötbetűs;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.TreeMap;

public class BOT extends FileReader {
    private FileReader fileReader;
    private int answer;
    private String wordToThink;
    private int round;
    private int nr;
    private int prevNr;
    private String prevWord;
    private int expected = 1;
    private ArrayList<String> possibleWords = new ArrayList<>();
    private int counter = 0;
    private ArrayList<String> morePossibleWords = new ArrayList<>();

    public BOT() throws FileNotFoundException {


    }

    public void wordThinker() {
        int random = (int) (Math.random() * words.size());
        wordToThink = words.get(random);

    }

    public int getAnswer(User user) {
        answer = 0;
        for (int i = 0; i < wordToThink.length(); i++) {
            if (wordToThink.charAt(i) == user.getUserWord().charAt(i)) {
                answer++;
            }
        }
        return answer;
    }


    public String tryToFindTheWord(int answerNr) {
        boolean goForward = false;
        round++;

        if (!wordsMap.isEmpty() && !words.isEmpty()) {
            if (round == 1) {
                nr = (int) (Math.random() * words.size());
                prevWord = words.get(nr);
                return wordToThink = words.get(nr);
            } else {
                prevWord = wordToThink;
                if (answerNr == 0) {
                    wordsMap.remove(prevWord.charAt(0));
                    counter = 0;
                    for (int i = 0; i < words.size(); i++) {
                        if (prevWord.charAt(0) == words.get(i).charAt(0)) {
                            words.remove(i);
                            i = i - 1;
                        }
                    }
                    while (!goForward) {
                        if (!words.isEmpty()) {
                            nr = (int) (Math.random() * words.size());
                            if (prevWord.charAt(0) != words.get(nr).charAt(0)) {
                                return wordToThink = words.get(nr);
                            } else if (wordsMap.isEmpty()) {
                                nr = (int) (Math.random() * possibleWords.size());
                                return wordToThink = possibleWords.get(nr);
                            } else {
                                nr = (int) (Math.random() * words.size());
                            }
                        } else {
                            nr = (int) (Math.random() * possibleWords.size());
                            return wordToThink = possibleWords.get(nr);
                        }

                    }
                } else {

                    while (!goForward) {
                        nr = (int) (Math.random() * wordsMap.get(prevWord.charAt(0)).size());
                        if (!wordsMap.get(prevWord.charAt(0)).get(nr).equals(prevWord) && counter <= 4) {
                            counter++;
                            return wordToThink = wordsMap.get(prevWord.charAt(0)).get(nr);

                        } else if (!wordsMap.get(prevWord.charAt(0)).get(nr).equals(prevWord) && counter == 5) {
                            counter = 0;
                            for (int i = 0; i < wordsMap.get(prevWord.charAt(0)).size(); i++) {
                                possibleWords.add(wordsMap.get(prevWord.charAt(0)).get(i));
                                nr = (int) (Math.random() * words.size());
                                if (wordsMap.containsKey(words.get(nr).charAt(0)) && prevWord.charAt(0) != words.get(nr).charAt(0)) {
                                    wordToThink = words.get(nr);
                                }
                            }
                            wordsMap.remove(prevWord.charAt(0));
                            for (int i = 0; i < words.size(); i++) {
                                if (words.get(i).charAt(0) == prevWord.charAt(0)) {
                                    words.remove(i);
                                    i = i - 1;
                                }
                            }
                            goForward = true;
                        }


                    }
                    return wordToThink;

                }


            }

        }

        prevNr = nr;
        prevWord = wordToThink;

        if (answerNr < expected) {
            if (!possibleWords.isEmpty()) {
                possibleWords.remove(prevNr);
                nr = (int) (Math.random() * possibleWords.size());
                return wordToThink = possibleWords.get(nr);
            } else {
                morePossibleWords.remove(prevNr);
                nr = (int) (Math.random() * morePossibleWords.size());
                return wordToThink = morePossibleWords.get(nr);
            }
        } else {
            while (!(counter >= answerNr)) {
                counter = 0;
                int i = 0;
                remove(prevWord, answerNr);
                for (; i < morePossibleWords.size(); i++) {
                    for (int j = 0; j < 5; j++) {
                        if (prevWord.charAt(j) == morePossibleWords.get(i).charAt(j)) {
                            counter++;
                        }
                    }
                    if (i == 0 && counter < answerNr) {
                        morePossibleWords.remove(i);
                        i = i - 1;
                    } else if (i > 0 && counter < answerNr) {
                        morePossibleWords.remove(i);
                        i = i - 1;
                    } else if (counter >= answerNr) {
                        expected++;
                        counter = 0;
                        return wordToThink = morePossibleWords.get(i);
                    }
                }
            }
            nr = (int) (Math.random() * morePossibleWords.size());

        }
        return wordToThink = morePossibleWords.get(nr);
    }

    public void remove(String preWord, int answerNr) {
        int counter = 0;
        int roundCounter = 0;
        boolean isFinished = false;
        while (!isFinished) {
            if (!possibleWords.isEmpty()) {
                for (int i = 0; i < possibleWords.size(); i++) {
                    for (int j = 0; j < 5; j++) {
                        if (preWord.charAt(j) == possibleWords.get(i).charAt(j)) {
                            counter++;
                        }
                    }
                    if (counter >= answerNr) {
                        morePossibleWords.add(possibleWords.get(i));

                    }
                    counter = 0;
                    possibleWords.remove(i);
                    i = i - 1;
                    if (possibleWords.isEmpty()) {
                        isFinished = true;
                        break;
                    }
                }
            } else {
                for (int i = 0; i < morePossibleWords.size(); i++) {
                    for (int j = 0; j < 5; j++) {
                        if (preWord.charAt(j) == morePossibleWords.get(i).charAt(j)) {
                            counter++;
                        }
                    }
                    if (counter < answerNr) {
                        morePossibleWords.remove(i);

                    }
                    roundCounter++;
                    counter = 0;
                    i = i - 1;
                    if (i == morePossibleWords.size() - 1 || roundCounter >= morePossibleWords.size()) {
                        isFinished = true;
                        break;
                    }
                }
            }
        }
    }

    public int getRound() {
        return round;
    }

    public int getNr() {
        return nr;
    }
}
