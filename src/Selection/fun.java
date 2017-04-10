import java.util.Random;
public class fun {
    private static int a[];

    public fun(int[] a) {
        this.a = a;
    }
    public int partition(int p, int r) {
        int x = a[r]; //x是最后一个元素
        int i = p - 1; //i第一次不指向任何元素 (p为1时，i=0)
        for (int j = p; j < r; j++) {
            if (a[j] < x)//如果当前指向的元素比x小
            {
                i++; //证明多一个元素比他小
                swap(i, j);

            }
        }
        swap(i + 1, r);
        return i + 1;
    }

    private void swap(int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public int randomParition(int[] a, int p, int r) {
        int max = r;
        int min = p;
        Random random = new Random();
        int i = random.nextInt(max) % (max - min + 1) + min;
        swap(r, i);
        return partition(p, r);
    }


    /**
     * i:求第i小的数,p,r是数组的开头和结尾,p初始为1
     * 1.如果数组只有一个元素，直接返回该元素
     * 2.取一个定数组的随机枢轴关键字q
     * 3.计算partition小的一边的元素个数k，这个数k加上1就是枢轴关键字
     * 4.如果这个数k正好是求的第i个数(k==i),那么返回结果a[q]
     * 5.如果i<k那么递归partition值小的子数组
     * 6.反之递归较大子数组
     */
    public int randomMinSelect(int[] a, int p, int r, int i) {
        if (p == r) {
            return a[p];
        }
        int q = randomParition(a, p, r);
        int k = q - p + 1;
        if (i == k) {
            return a[q];
        } else if (i < k) {
            return randomMinSelect(a, p, q - 1, i);
        } else {
            return randomMinSelect(a, q + 1, r, i - k);
        }
    }


}
