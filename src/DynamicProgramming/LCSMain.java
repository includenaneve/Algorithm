package DynamicProgramming;

/**
 * Created by naneve on 2017/4/20.
 */
public class LCSMain {
    public static void main(String[] args)
    {
        String str2 = "BDCABA";
        String str1 = "ABCBDAB";

        LCS test = new LCS(str1,str2);
        test.fun();

    }
}
