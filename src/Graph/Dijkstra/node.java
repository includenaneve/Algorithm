package Graph.Dijkstra;

/**
 * Created by naneve on 2017/5/7.
 */
public class node {
    int value;
    int d;
    node(int value)
    {
        this.value = value;
        this.d = Integer.MAX_VALUE;
    }
    node(node o2){
        this.value = o2.value;
        this.d = o2.d;
    }
}
