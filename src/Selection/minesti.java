package Selection;

public class minesti {
    public static void main(String[] args)
    {
        int[] a = new int[100000];
        myRandom ram = new myRandom(a.length,"10K.txt");
        a = ram.createRandomArray();
        fun kk = new fun(a);
        int myselection = 99;
        int res = kk.randomMinSelect(a,1,a.length-1,99);
        System.out.println("【"+myselection+"】"+res);


        kk.insertSort();
        kk.geta();
    }
}
