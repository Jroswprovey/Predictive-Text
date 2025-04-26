import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {


    public static void Run(Trie myTrie){
        Scanner myScanner = new Scanner(System.in);

        //Loops through menu options
        while (true){

            System.out.println("Please enter a command (Type help for a list of commands)");
            String input = myScanner.nextLine();
            String[] commands = input.split(" ");


            List<Command> commandList = List.of(
                    new Command("Quit", "Exit the program.", () -> {System.exit(0);}),
                    new Command("Search", "Enter a word or part of a word to search for in the tree. Leave it blank to display the entire database.", () -> {Actions.search(commands, myTrie);}),
                    new Command("Insert", "Add a new word to the database.", () -> {Actions.insert(commands, myTrie);}),
                    new Command("Link", "Manually create a link between two words.", () -> {Actions.link(commands, myTrie);}),
                    new Command("Predict", "Provide a word to get its most likely next word based on the database.", () -> {Actions.predict(commands, myTrie);}),
                    new Command("Train", "Input a series of words (e.g., an essay or text) to train the model.", () -> {Actions.train(commands, new Trie());})
            );


            for (int i = 0; i < commandList.size(); i++) {
                if(commands[0].equalsIgnoreCase(commandList.get(i).getName())){
                    commandList.get(i).getAction().run();
                }

            }

            
            
            
//            if(commands[0].equalsIgnoreCase("help")){
//                System.out.println("Options:" + System.lineSeparator() +
//                        "Quit: Exit the program." + System.lineSeparator() +
//                        "Search: Enter a word or part of a word to search for in the tree. Leave it blank to display the entire database." + System.lineSeparator() +
//                        "Insert: Add a new word to the database." + System.lineSeparator() +
//                        "Link: Manually create a link between two words." + System.lineSeparator() +
//                        "Predict: Provide a word to get its most likely next word based on the database." + System.lineSeparator() +
//                        "Train: Input a series of words (e.g., an essay or text) to train the model.");
//            }
//
//            if(commands[0].equalsIgnoreCase("quit")){
//                break;
//            }
//            if (commands[0].equalsIgnoreCase("search")){
//                if (commands.length > 1) {
//                    myTrie.printWords(commands[1]);
//                }else {
//                    myTrie.printWords("");
//                }
//            }
//            if(commands[0].equalsIgnoreCase("insert")){
//                myTrie.insert(commands[1].toCharArray());
//            }
//
//            if (commands[0].equalsIgnoreCase("link")){
//                myTrie.linkNodes(commands[1],commands[2]);
//
//            }
//
//            if (commands[0].equalsIgnoreCase("predict")){
//                myTrie.predict(commands[1]);
//            }
//
//            if (commands[0].equalsIgnoreCase("train")) {
//                // Sanitize input to remove special characters
//                for (int i = 1; i < commands.length; i++) {
//                    commands[i] = commands[i].replaceAll("[^a-zA-Z0-9 ]", "");
//                }
//
//                // Extract training words
//                String[] trainingWords = Arrays.copyOfRange(commands, 1, commands.length);
//
//                if (trainingWords.length > 0) {
//                    myTrie.train(trainingWords);
//                } else {
//                    System.out.println("No words provided for training.");
//                }
//            }


        }


    }
}
