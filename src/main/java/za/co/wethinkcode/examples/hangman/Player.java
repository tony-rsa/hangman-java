package za.co.wethinkcode.examples.hangman;

import java.io.InputStream;
import java.util.Scanner;

public class Player {
    private final Scanner scanner;
    private boolean quit = false;
    private int chances = 5;

    public Player(InputStream in){
        this.scanner = new Scanner(in);
    }

    public Player(){
        this.scanner = new Scanner(System.in);
    }

    public int getChances() {
        return chances;
    }

    public void lostChance() {
        if (!this.hasNoChances())
            this.chances--;
    }

    public boolean hasNoChances() {
        return this.getChances() == 0;
    }

    public String getWordsFile() {
        String filename = this.scanner.nextLine();
        return filename.isBlank() ? "short_words.txt" : filename;
    }

    public String getGuess() {
        String text =  this.scanner.nextLine();
        this.quit = text.equalsIgnoreCase("quit") || text.equalsIgnoreCase("exit");
        return text;
    }

    public boolean wantsToQuit() {
        return this.quit;
    }
}
