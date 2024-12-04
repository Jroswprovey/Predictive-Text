/*
Joseph Rosw-Provey
Data Structures
Professor Douglass
12/3/2024
 */
public class Trie {
    Node root;


    //root will always be defined no matter what in trie
    public Trie(){
        root = new Node(null);
    }

    public void insert(char[] parsedWord){
        Node curNode = root;

        //every char in array gets put into array
        for(int i=0; i< parsedWord.length; i++){
            int alphaVal = Alphabet.getAlphaValue(parsedWord[i]);
            //if there is not a child in the alpha value index of child array create a new one
            if(curNode.children[alphaVal] == null){
                curNode.children[alphaVal] = new Node(parsedWord[i]);
            }
            curNode.children[alphaVal].parent = curNode; //set parent to the node that would be above it
            curNode = curNode.children[alphaVal]; //move to next node
        }

        curNode.isWord = true; // sets last node inserted in trie to be a word

    }

    //Start at a Node other than root
    public void printWords(String input) {
        char[] charInput = input.toCharArray();
        Node curnode = root;
        int alphaVal;


        for (int i = 0; i < charInput.length; i++) {
            alphaVal = Alphabet.getAlphaValue(charInput[i]);
            curnode = curnode.children[alphaVal];
        }

        printWords(curnode, input.toUpperCase());
    }

    //searches through array and finds words that have prefix in them
    private void printWords(Node curNode, String prefix) {
        if (curNode == null) {
            return; //
        }

        // If this node marks the end of a word, print the current prefix.
        if (curNode.isWord) {
            System.out.println(prefix);
        }

        // Recurse for each child, adding its character to the prefix.
        for (int i = 0; i < curNode.children.length; i++) {
            if (curNode.children[i] != null) {
                printWords(curNode.children[i], prefix + curNode.children[i].element);
            }
        }
    }

    //finds singular node in trie then returns the last letter node in that words
    private Node findNode (String input){
        char[] charInput = input.toCharArray();
        Node curNode = root;
        for (int i = 0; i < input.length(); i++) {
                curNode = curNode.children[Alphabet.getAlphaValue(charInput[i])];
        }
        return curNode;
    }

    //Links nodes together Using strings. automates find node
    public void linkNodes(String source, String destination){
        Node nodeSource = findNode(source);
        Edge curEdge = nodeSource.edge;
        Node nodeDestination = findNode(destination);

        //loops through all edges in source node and checks if any of them have the same destination thats trying to be added
        while(curEdge != null){
            //if the same destination is found
            if(curEdge.destination.equals(nodeDestination)){
                curEdge.weight++;
                return;
            }
            if(curEdge.next == null){
                break;
            }
            curEdge = curEdge.next;
        }

        Edge newEdge = new Edge(nodeSource, nodeDestination);
        if (curEdge == null) {
            // If there are no edges, set the new edge as the first edge
            nodeSource.edge = newEdge;
        } else {
            curEdge.next = newEdge; // Link the new edge to the end of the list
        }
    }

    //Prints out predicted next word
    public void predict(String input){
        if(findNode(input).edge == null){
            System.out.println("No prediction found");
            return;
        }
        Node curDestination = findNode(input).edge.destination; // curNode is the source nodes
        Edge curEdge = findNode(input).edge;
        StringBuilder sb = new StringBuilder();

        //this prints out all edges
        while (curEdge != null) {
            sb.append(System.lineSeparator());// these must be added now because the arrays
            sb.append("]" + curEdge.weight + "[");
            //gets to destination and adds the element to the string builder then moves up the trie
            while (curDestination != root) {
                sb.append(curDestination.element);
                curDestination = curDestination.parent; // increments up the Trie via parents
            }

            curEdge = curEdge.next;//increment down edge list
            if(curEdge != null){
            curDestination = curEdge.destination; //reset destination to next edges destination
                }
        }

        System.out.print(sb.reverse()); // since traversal up the trie results in the word being backwards we reverse it
        System.out.println();

    }

    //takes in a string array and then turns it into a linked list so it can be used recursively
    public void train(String[] trainingArr){
        for (int i = 0; i < trainingArr.length-1; i++) {
                linkNodes(trainingArr[i], trainingArr[i + 1]);
                System.out.println("Linking: " + trainingArr[i] + " -> " + trainingArr[i + 1]);
        }
    }
}