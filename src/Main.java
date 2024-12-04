/*
Joseph Rosw-Provey
Data Structures
Professor Douglass
12/3/2024
 */
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        Trie myTrie = new Trie();

        try{
            Scanner fileScanner = new Scanner(new File("src/words_alpha.txt"));//please change this path to where you've located this file if the program errors
            while (fileScanner.hasNextLine()){
                myTrie.insert(fileScanner.nextLine().toCharArray());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        while (true){


            System.out.println("Please enter a command");
            String input = myScanner.nextLine();

            String[] commands = input.split(" ");

            if(commands[0].equalsIgnoreCase("help")){
                System.out.println("Options:" + System.lineSeparator() +
                        "Quit: Exit the program." + System.lineSeparator() +
                        "Search: Enter a word or part of a word to search for in the tree. Leave it blank to display the entire database." + System.lineSeparator() +
                        "Insert: Add a new word to the database." + System.lineSeparator() +
                        "Link: Manually create a link between two words." + System.lineSeparator() +
                        "Predict: Provide a word to get its most likely next word based on the database." + System.lineSeparator() +
                        "Train: Input a series of words (e.g., an essay or text) to train the model.");
            }

            if(commands[0].equalsIgnoreCase("quit")){
                break;
            }
            if (commands[0].equalsIgnoreCase("search")){
                if (commands.length > 1) {
                    myTrie.printWords(commands[1]);
                }else {
                    myTrie.printWords("");
                }
            }
            if(commands[0].equalsIgnoreCase("insert")){
                myTrie.insert(commands[1].toCharArray());
            }

            if (commands[0].equalsIgnoreCase("link")){
                myTrie.linkNodes(commands[1],commands[2]);

            }

            if (commands[0].equalsIgnoreCase("predict")){
                myTrie.predict(commands[1]);
            }

            if (commands[0].equalsIgnoreCase("train")) {
                // Sanitize input to remove special characters
                for (int i = 1; i < commands.length; i++) {
                    commands[i] = commands[i].replaceAll("[^a-zA-Z0-9 ]", "");
                }

                // Extract training words
                String[] trainingWords = Arrays.copyOfRange(commands, 1, commands.length);

                if (trainingWords.length > 0) {
                    myTrie.train(trainingWords);
                } else {
                    System.out.println("No words provided for training.");
                }
            }


        }
    }
}