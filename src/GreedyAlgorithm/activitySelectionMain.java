package GreedyAlgorithm;

/**
 * Created by naneve on 2017/4/20.
 */
public class activitySelectionMain {
    public static void main(String[] args) {
        int[] s = {0,1,3,0,5,3,5,6,8,8,2,12};
        int[] f = {0,4,5,6,7,8,9,10,11,12,13,14};
        activitySelectionProblem test = new activitySelectionProblem(s,f);
        test.ByGreedy();

    }
}
