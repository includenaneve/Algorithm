package DynamicProgramming;
/**
 * Created by naneve on 2017/4/20.
 * 动态规划:矩阵连乘问题
 * 利用最优加括号方式来得到矩阵连乘得到最少乘法次数，
 * 过程:
 * 1.找到一个索引k，使得原问题的乘法次数最少,那么被k分割开的两个子问题的乘法次数肯定也是最少的
 * 2.由于不知道这个k的值是多少，因此每次都要去找一个k是的乘法次数最小值
 * 3.由最优子结构从下到上分析一步一步得到最优解 一个矩阵相乘->两个矩阵相乘->n个矩阵相乘
 */
public class matrixChainMultiplication {

    int len;
    int[] p = new int[len]; //保存矩阵的维度
    int[][] m = new int[len][len]; //保存最优乘法次数
    int[][] s = new int[len][len];

    matrixChainMultiplication(int[] p, int len) {
        this.len = len;
        this.p = p;
        m = new int[len][len];
        s = new int[len][len];
    }

    public void fun() {
        int n = len; //p个维度就有p-1个矩阵相乘
        for (int i = 1; i < n; i++) {
            m[i][i] = 0; //m[i][i]代表单个矩阵A[i,i],所以乘法次数为0
        }
        /**
         * l是解决当前矩阵相乘长度,
         * 例如l=2时解决了m[1,2],m[2,3]..m[n-1,n]; l = 4时算出了m[1,4],m[2,5]..m[n-3,n]
         * 这里的m每次都有多种加括号结合方式,例如l = 4时候 m[1,4] = A1A2A3A4有三种加括号方式
         * k=1时(A1)(A2A3A4)、k=2时(A1A2)(A3A4)、k=3时(A1A2A3)(A4)
         * 因此这里l表示每次要处理矩阵的长度
         * i表示处理矩阵长度为l时加括号方式的数量,l = 4时 每个l=4的矩阵有三种加括号方式
         * k表示断开位置,找到每个k对应m[i][k]的最小值
         */
        for (int l = 2; l < n; l++) {
            for (int i = 1; i < n - l + 1; i++) {
                int j = i + l - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int  k= i; k <= j - 1; k++) {
                    int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < m[i][j]) {
                        m[i][j] = q; //记录乘法次数最少次数
                        s[i][j] = k; //记录乘法次数最少时断开位置
                    }
                }
            }
        }
        print(1,len-1);
    }

    public void print(int i,int j)
    {
        if(i == j)
        {
            System.out.print("A"+i);
        }
        else
        {
            System.out.print("(");
            print(i,s[i][j]);
            print(s[i][j]+1,j);
            System.out.print(")");
        }
    }

}
