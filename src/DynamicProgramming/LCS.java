package DynamicProgramming;

/**
 * Created by naneve on 2017/4/20.
 */
public class LCS {
    String str1;
    String str2;
    int m;
    int n;
    int[][] c = new int[m][n];
    char[][] b = new char[m][n];

    LCS(String str1, String str2) {
        this.str1 = str1;
        this.str2 = str2;
        m = str1.length()+1;
        n = str2.length()+1;
        c = new int[m][n];
        b = new char[m][n];

    }

    public void fun() {
        int m = str1.length() + 1;
        int n = str2.length() + 1;
        for (int i = 0; i < m; i++) {
            c[i][0] = 0;
            b[i][0] = '一';
        }
        for (int i = 0; i < n; i++) {
            c[0][i] = 0;
            b[0][i] = '一';
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1))
                {
                    c[i][j] = c[i-1][j-1]+1;//来自左上方
                    b[i][j] = '↖';
                }
                else if(c[i-1][j] >= c[i][j-1])//比较上和左，去较大值
                {
                    c[i][j] = c[i-1][j];
                    b[i][j] = '↑';
                }
                else
                {
                    c[i][j] = c[i][j-1];
                    b[i][j] = '←';
                }
            }
        }
        for(int i = 0;i<m;i++)
        {
            for(int j = 0;j<n;j++) {
                System.out.print(c[i][j]);
                System.out.print(b[i][j]+" ");
            }
            System.out.print("\n");

        }
        System.out.println("LCS长度为:"+c[m-1][n-1]);
        print(m-1,n-1);
    }

    public void print(int i,int j)
    {
        if(i == 0 || j == 0)
        {
            return;
        }
        if(b[i][j] == '↖')
        {
            print(i-1,j-1);
            System.out.print(str1.charAt(i-1));
        }
        else if(b[i][j] == '↑')
        {
            print(i-1,j);
        }
        else
        {
            print(i,j-1);
        }
    }

    public void printAll()
    {

    }

}
