package DynamicProgramming;

import java.util.*;

/**
 * Created by naneve on 2017/4/20.
 * 动态规划: 装配线问题
 */

public class assemblyLine {
    int n;//n个工作站
    int[] a1 = new int[n];//第一条流水线工作时间
    int[] a2 = new int[n];//第二条流水线工作时间
    int x1, x2; //两条装配线的地盘上线时间
    int e1, e2;//两条装配线的下线时间
    int[] t1 = new int[n];
    int[] t2 = new int[n];//两条装配线的转移时间
    int[] f1 = new int[n]; //fi[j]表示到达第i条流水线的第j个工作站的最快时间
    int[] f2 = new int[n];
    int[] l1 = new int[n];//li[j]表示到达第i条流水线的第j个工作站的路径
    int[] l2 = new int[n];
    int f, l;

    assemblyLine(int[] a1, int[] a2, int[] t1, int[] t2, int x1, int x2, int e1, int e2, int n) {
        this.n = n;
        this.a1 = a1;
        this.a2 = a2;
        this.t1 = t1;
        this.t2 = t2;
        this.x1 = x1;
        this.x2 = x2;
        this.e1 = e1;
        this.e2 = e2;
        f1 = new int[n];
        f2 = new int[n];
        l1 = new int[n];
        l2 = new int[n];
    }

    public void fun() {
        f1[0] = e1 + a1[0];
        f2[0] = e2 + a2[0];
        for (int j = 1; j < n; j++) {
            if (f1[j - 1] + a1[j] <= f2[j - 1] + t2[j - 1] + a1[j])//记录到达第1条流水线的第j个工作站所用最短时间,(1)从a1[1]->a1[2] (2)从a2[1]->a1[2]
            {
                f1[j] = f1[j - 1] + a1[j];
                l1[j] = 1; //记录是从那条流水线到的ai[j]
            } else {
                f1[j] = f2[j - 1] + t2[j - 1] + a1[j];
                l1[j] = 2; //记录是从那条流水线到的ai[j]
            }

//            if(f2[j-1] + a2[j] <= f1[j-1]+ t1[j-1]+a1[j])
//            {
//                f2[j] = f2[j-1] + a2[j];
//                l2[j] = 1;
//            }
//            else
//            {
//                f2[j] = f1[j-1]+ t1[j-1]+a1[j];
//                l2[j] = 2;
//            }
        }
        if (f1[n - 1] + x1 <= f2[n - 1] + x2) //最后每条线加上下线时间，最短的为最终的最优装配线解值
        {
            f = f1[n - 1] + x1;
            l = 1;
        } else {
            f = f2[n - 1] + x2;
            l = 2;
        }

        printRoad();
    }

    public void printRoad() {
        System.out.println("f1[j] = " + Arrays.toString(f1));
        System.out.println("f2[j] = " + Arrays.toString(f2));
        System.out.println("L1[j] = " + Arrays.toString(l1));
        System.out.println("L2[j] = " + Arrays.toString(l2));
        System.out.println("最短装配时间为:" + f);
        Stack line = new Stack();
        Stack station = new Stack();
        int path = l;
        line.push(path);
        station.push(n);
        for (int k = n - 1; k > 0; k--) {
            if (path == 1) {
                path = l1[k];
                line.push(path);
                station.push(k);
            } else if (path == 2) {
                path = l2[k];
                line.push(path);
                station.push(k);
            }
        }
        while (!line.empty()) {
            System.out.println("line:" + line.pop() + ",station:" + station.pop());
        }
    }


}
