/*
Joseph Rosw-Provey
Data Structures
Professor Douglass
12/3/2024
 */
public class Edge {
    Node source;
    Node destination;
    int weight = 0;
    Edge next;

    public Edge(Node source, Node destination){
        this.source = source;
        this.destination = destination;
    }
}
