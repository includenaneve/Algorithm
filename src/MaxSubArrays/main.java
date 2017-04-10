import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        int[] a = new int[1000];
        myRandom ram = new myRandom(a.length, "thousand.txt");
        a = ram.createRandomArray();
        System.out.println("原数组: " + Arrays.toString(a));
        maxSubArray test = new maxSubArray();
        test.maxSubN(a);
    }
}
