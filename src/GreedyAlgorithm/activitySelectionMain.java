package GreedyAlgorithm;

import java.util.Arrays;

/**
 * Created by naneve on 2017/4/20.
 */
public class activitySelectionMain {
    public static void main(String[] args) {
        int[] s = {0, 1, 3, 0, 5, 3, 5, 6, 8, 8, 12, 2};
        int[] f = {0, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 13};
        for (int i = 1; i < f.length; i++) {
            for (int j = 1; j < f.length; j++)
            {
                if(f[j] >= f[i])
                {
                    int temp = f[i];
                    f[i] = f[j];
                    f[j] = temp;
                    int temp2 = s[i];
                    s[i] = s[j];
                    s[j] = temp2;
                }
            }
        }
        System.out.println(Arrays.toString(s));
        System.out.println(Arrays.toString(f));
        activitySelectionProblem test = new activitySelectionProblem(s, f);
        test.ByGreedy();

    }
}
