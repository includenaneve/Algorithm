package GreedyAlgorithm;

/**
 * Created by naneve on 2017/4/20.
 */
public class activitySelectionProblem {
    int num;
    int[] s = new int[num];
    int[] f = new int[num];

    activitySelectionProblem(int[] s, int[] f) {
        num = s.length;
        this.s = s;
        this.f = f;
    }

    public void ByGreedy() {
        int n = num;
        int[] A = new int[n];
        int index = 0;
        A[index] = 1;
        for (int i = 2; i < n; i++) {
            if(s[i] >= f[A[index]])
            {
                index++;
                A[index] = i;
            }
        }
        System.out.println("贪心算法得到的解为:"+(index+1));
        System.out.println("你的节目表为:");
        System.out.println("节目编号\t节目开始时间\t节目结束时间");
        for(int i = 0;i<=index;i++)
        {
            System.out.println(A[i]+"\t\t\t"+s[A[i]]+"\t\t\t\t"+f[A[i]]);
        }
    }

}
