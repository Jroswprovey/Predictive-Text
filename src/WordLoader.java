import java.io.File;
import java.util.Scanner;

public class WordLoader {

    public static Trie WordLoader(){
        Trie myTrie = new Trie();

        try{
            Scanner fileScanner = new Scanner(new File("src/words_alpha.txt"));//please change this path to where you've located this file if the program errors
            while (fileScanner.hasNextLine()){
                myTrie.insert(fileScanner.nextLine().toCharArray());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return myTrie;
    }
}
