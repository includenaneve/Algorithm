import java.util.Arrays;

public class maxSubArray {

    public void maxSubN(int[] A) {
        int left = 0;
        int right = 0;
        int maxSum = Integer.MIN_VALUE;
        int cumSum = 0;
        int leftNow = 0;
        for (int i = 0; i < A.length; i++) {
            cumSum += A[i];
            if (cumSum > maxSum) {
                maxSum = cumSum;
                left = leftNow;
                right = i;
            } else if (cumSum < 0) {
                leftNow = i + 1;
                cumSum = 0;
            }
        }

        int[] subArray = Arrays.copyOfRange(A, left, right + 1);
        System.out.println("最大子数组的和是: " + maxSum);
        System.out.println("最大子数组序列:" + Arrays.toString(subArray));
    }





}
