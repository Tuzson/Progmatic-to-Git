package Ötbetűs;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Game {

private User user;
private BOT bot;

    public Game() throws FileNotFoundException {
        user = new User();
        bot = new BOT();
    }

    public void letsPlay(){
        boolean win = false;
        bot.wordThinker();
        System.out.println("Gondoltam egy 5 betűs szóra. Ki tudod találni melyik volt az?");
        while (!win){
            user.letsTryAnotherWord();

            if (bot.getAnswer(user) == 5){
                win = true;
                System.out.println( bot.getAnswer(user) + "! Nyertél! Vége a játéknak");
            }else {
                System.out.println("A tippelt szóban " +bot.getAnswer(user) + " betű egyezik");
            }
        }
    }

    public void letsThink(){
        user.letsThinkAWord();
        boolean win = false;
        while (!win){
            String botWord = bot.tryToFindTheWord(user.getAnswer());
            if (user.wordCheck(botWord) == 5 ){
                win = true;
                System.out.println("A gép kitalálta a szót " + bot.getRound() + " körből");
            }

            }
        }

    }
