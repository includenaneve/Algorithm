package Graph.Dijkstra;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class filehandle {
    int edge_num;
    int node_num;
    edge[] edges;
    node[] nodes;
    int[] pi;
    node[] S;

    public void initData() {
        try {
            FileReader file1 = new FileReader("Data.txt");
            BufferedReader bfile = new BufferedReader(file1);
            Scanner sc = new Scanner(bfile);
            node_num = sc.nextInt();
            edge_num = sc.nextInt();
            edges = new edge[edge_num];
            nodes = new node[node_num];
            pi = new int[node_num];
            for (int i = 0; i < edge_num; i++) {
                int node1, node2, weight;
                node1 = sc.nextInt();
                node2 = sc.nextInt();
                weight = sc.nextInt();
                edges[i] = new edge(node1, node2, weight);
            }
            for (int i = 0; i < node_num; i++) {
                nodes[i] = new node(i + 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int w(node node1, node node2) {
        for (int i = 0; i < edge_num; i++) {
            int evalue = edges[i].node1.value;
            int evalue2 = edges[i].node2.value;
            int nv = node1.value;
            int nv2 = node2.value;
            if (evalue == nv && evalue2 == nv2) {
                return edges[i].weight;
            }
        }
        return -1;
    }

    public void relax(node u, node v) {
        if (v.d > u.d + w(u, v)) {
            v.d = u.d + w(u, v);
            pi[v.value - 1] = u.value;
        }
    }

    public void Dijkstra(int s) {
        nodes[s].d = 0;
        S = new node[node_num];
        int cnt = 0;
        for (int i = 0; i < node_num; i++) {
            S[i] = new node(-1);
        }
        Comparator<node> OrderIsdn = new Comparator<node>() {
            @Override
            public int compare(node o1, node o2) {
                return (int) (o1.d - o2.d);
            }
        };
        Queue<node> Q = new PriorityQueue<node>(node_num - 1, OrderIsdn);
        for (int i = 0; i < node_num; i++) {
            Q.add(nodes[i]);
        }
        while (!Q.isEmpty()) {
            node u = Q.peek();
            S[cnt++] = u;
//            System.out.println(u.value);
            for (int i = 0; i < edge_num; i++) {
                if (w(u, edges[i].node2) != -1) {
                    int temp = edges[i].node2.value;
                    relax(u, nodes[temp - 1]);
                }
            }
            Q.poll();

        }
        showValue();
    }

    public void showAll() {
        for (int i = 0; i < node_num; i++) {
            System.out.print(nodes[i].d + " ");
        }
        System.out.print("\n");
    }

    public void showValue() {

        int sum = 0;
        for (int i = 1; i < 5; i++) {
            int n2 = pi[i];
            int n1 = i + 1;
            System.out.println(n2+" ---> "+n1);
            for (int j = 0; j < edge_num; j++) {
                int evalue = edges[j].node1.value;
                int evalue2 = edges[j].node2.value;
                if (evalue == n2 && evalue2 == n1) {
                    sum += edges[j].weight;
                }
            }
        }
        System.out.print("最短路径值为");
        System.out.println(sum);
    }

    public static void main(String[] args) {
        filehandle f = new filehandle();
        f.initData();
        f.Dijkstra(0);

        //昨晚碰上一个bug 就是关于优先队列不维护的问题。！！！
        //原来是优先队列在数据更新前就已经出队列了。
        //所以一般做法是先访问，再更新，最后才出队列！！！
    }

}
