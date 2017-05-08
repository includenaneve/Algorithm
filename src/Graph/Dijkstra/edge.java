package Graph.Dijkstra;

public class edge {
    node node1 ;
    node node2 ;
    int weight;
    edge(int node1,int node2,int weight){
        this.node1 = new node(node1);
        this.node2 = new node(node2);
        this.weight = weight;
    }

}
