package DynamicProgramming;

/**
 * Created by naneve on 2017/4/20.
 */
public class matrixChainMultiplicationMain {
    public static void main(String[] args)
    {
        int[] p = {30,35,15,5,10,20,25};//答案在书上P338
        matrixChainMultiplication test = new matrixChainMultiplication(p,p.length);
        test.fun();
    }
}
