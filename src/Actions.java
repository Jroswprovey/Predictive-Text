import java.util.Arrays;

public class Actions {


    public static void quit(){
        System.exit(0);
    }

    public static void search(String[] commands, Trie myTrie){
        if (commands.length > 1) {
            myTrie.printWords(commands[1]);
        }else {
            myTrie.printWords("");
        }
    }

    public static void insert(String[] commands, Trie myTrie) {
        myTrie.insert(commands[1].toCharArray());
    }

    public static void link(String[] commands, Trie myTrie) {
        myTrie.linkNodes(commands[1],commands[2]);
    }

    public static void predict(String[] commands, Trie myTrie) {
        myTrie.predict(commands[1]);
    }

    public static void train(String[] commands, Trie myTrie) {
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
