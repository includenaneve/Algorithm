package GreedyAlgorithm;
public class Knapsack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int N = Integer.parseInt("3");   // number of items
        int W = Integer.parseInt("50");   // maximum weight of knapsack

        int[] profit = {0,10,20,30};
        int[] weight = {0,10,100,120};

        int[][] opt = new int[N + 1][W + 1];
        boolean[][] sol = new boolean[N + 1][W + 1];

        for (int n = 1; n <= N; n++) {
            for (int w = 1; w <= W; w++) {

                int option1 = opt[n - 1][w];

                int option2 = Integer.MIN_VALUE;
                if (weight[n] <= w) {
                    option2 = profit[n] + opt[n - 1][w - weight[n]];
                }

                opt[n][w] = Math.max(option1, option2);
                sol[n][w] = (option2 > option1);
            }
        }

        boolean[] take = new boolean[N + 1];
        for (int n = N, w = W; n > 0; n--) {
            if (sol[n][w]) {
                take[n] = true;
                w = w - weight[n];
            } else {
                take[n] = false;
            }
        }

        // print results
        System.out.println("item" + "\t" + "profit" + "\t" + "weight" + "\t" + "take");
        for (int n = 1; n <= N; n++) {
            System.out.println(n + "\t\t" + profit[n] + "\t\t" + weight[n] + "\t\t" + take[n]);
        }
    }
}