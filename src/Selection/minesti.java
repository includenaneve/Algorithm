public class minesti {
    public static void main(String[] args)
    {

        int[] a = new int[100000];
        myRandom ram = new myRandom(a.length,"10K.txt");
        a = ram.createRandomArray();
        fun kk = new fun(a);
        System.out.println(kk.randomMinSelect(a,1,a.length-1,32));

    }
}
