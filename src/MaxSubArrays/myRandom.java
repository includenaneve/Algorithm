import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;

public class myRandom {
    int num;
    String fileName;
    int[] a;

    public myRandom(int num,String fileName) {
        this.num = num;
        this.fileName = fileName;
        a = new int[num];
//        System.out.println(this.num+" "+this.fileName+" "+ Arrays.toString(this.a));
    }

    public int[] createRandomArray() {
        //生成随机数并放入文件中
        try {
            FileWriter file1 = new FileWriter(this.fileName);
            Random random = new Random();
            for (int i = 0; i < num; i++) {
                int random_num = random.nextInt();
                String str_num = Integer.toString(random_num);
                file1.write(str_num + "\r\n");
            }
            file1.flush();
            file1.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //读取随机数文件，将随机数放入数组
        try {
            FileReader file1 = new FileReader(this.fileName);
            BufferedReader bfile = new BufferedReader(file1);
            String number;
            int i = 0;
            while ((number = bfile.readLine()) != null) {
                int num1 = Integer.parseInt(number);
                this.a[i++] = num1;
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return this.a;
    }
}