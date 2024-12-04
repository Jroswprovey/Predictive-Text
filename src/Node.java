/*
Joseph Rosw-Provey
Data Structures
Professor Douglass
12/3/2024
 */
public class Node {
    Character element;
    Node[] children = new Node[26];
    boolean isWord = false;
    Edge edge;
    Node parent;


    public Node(Character element){
        this.element = element;
    }
}
