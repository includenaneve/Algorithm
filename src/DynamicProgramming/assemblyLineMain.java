package DynamicProgramming;
/**
 * Created by naneve on 2017/4/20.
 */
public class assemblyLineMain {
    public static void main(String[] args)
    {
        int n = 6;//n个工作站
        int[] a1 = {7,9,3,4,8,4};//第一条流水线工作时间
        int[] a2 = {8,5,6,4,5,7};//第二条流水线工作时间
        int x1 = 3,x2 = 2; //两条装配线的地盘上线时间
        int e1 = 2,e2 = 4;//两条装配线的下线时间
        int[] t1 = {2,3,1,3,4};
        int[] t2 = {2,1,2,2,1};//两条装配线的转移时间

        assemblyLine test = new assemblyLine(a1,a2,t1,t2,x1,x2,e1,e2,n);
        test.fun();

    }
}
