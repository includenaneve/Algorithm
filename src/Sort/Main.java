package Sort;

import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

import com.sun.xml.internal.ws.api.streaming.XMLStreamWriterFactory;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.*;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis3D;
import org.jfree.chart.axis.NumberAxis3D;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.data.category.DefaultCategoryDataset;

public class Main {

    public long[] mergeResult = new long[6];
    public long[] qsortResult = new long[6];
    public int mergeIndex = 0;
    public int qsortIndex = 0;

    public void test(String filename, int testNumber) {
        int a[] = new int[testNumber];
        int c[] = new int[testNumber];
        int b[] = new int[testNumber];
        try {
            FileReader file1 = new FileReader(filename);
            BufferedReader bfile = new BufferedReader(file1);
            String number;
            int i = 0;
            while ((number = bfile.readLine()) != null) {
                int num = Integer.parseInt(number);
                a[i] = num;
                b[i] = num;
                c[i] = num;
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

//        System.out.println("数据规模： " + testNumber);
//        //插入排序
//        Date begintime = new Date();
//        insertSort(a);
//        // margeSort(a,0,a.length-1);
//        Date endtime = new Date();
//        long between = endtime.getTime() - begintime.getTime();
//        long s = between /1000;
//        System.out.println("插入排序花费的时间是: "+ s + "秒  "+ (between - s * 1000)+"毫秒");
////        createRandom(testNumber,a);

        //归并排序
        Date begintime2 = new Date();
        margeSort(b, 0, b.length - 1);
        Date endtime2 = new Date();
        long between2 = endtime2.getTime() - begintime2.getTime();
        mergeResult[mergeIndex++] = between2;
        long s2 = between2 / 1000;
        System.out.println("归并排序花费的时间是: " + s2 + "秒  " + (between2 - s2 * 1000) + "毫秒");

        //快速排序
        Date begintime3 = new Date();
        myqsort(c, 0,c.length-1);
        Date endtime3 = new Date();
        long between3 = endtime3.getTime() - begintime3.getTime();
        qsortResult[qsortIndex++] = between3;
        long s3 = between3 / 1000;
        System.out.println("快速排序花费的时间是: " + s3 + "秒  " + (between3 - s3 * 1000) + "毫秒");
    }

    public void createRandom(int testNumber,String filename) {
        try {
            FileWriter file1 = new FileWriter(filename);
            Random random = new Random();
            for (int i = 0; i < testNumber; i++) {
                int random_num = random.nextInt();
                String str_num = Integer.toString(random_num);
                file1.write(str_num + "\r\n");
            }
            file1.flush();
            file1.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void createRandom(int testNumber, int[] a) {
        try {
            FileWriter file1 = new FileWriter("result1.txt");
            Random random = new Random();
            for (int i = 0; i < testNumber; i++) {
                String str_num = Integer.toString(a[i]);
                file1.write(str_num + "\r\n");
            }
            file1.flush();
            file1.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertSort(int a[]) {
        for (int i = 1; i < a.length; i++) //默认第一个数是有序的
    {
        int temp = a[i];  //从第一个无序的数开始插入
        int j = i;
        while (j > 0 && temp < a[j - 1])  //如果该数比前一个数小，交换
        {
            a[j] = a[j - 1];
            j--;
        }
        a[j] = temp;
    }
}

    public int[] margeSort(int a[], int left, int right) {
        int mid = (right + left) / 2;
        if (left < right) //相等时推出递归
        {
            margeSort(a, left, mid);
            margeSort(a, mid + 1, right);
            mergeCombine(a, left, mid, right);
        }
        return a;
    }

    public void mergeCombine(int[] a, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int L[] = new int[n1 + 1];
        int R[] = new int[n2 + 1];

        for (int i = 0; i < n1; i++) {
            L[i] = a[left + i];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = a[mid + i + 1];
        }
        L[n1] = 2147483647;
        R[n2] = 2147483647;
        int i = 0;
        int j = 0;
        for (int k = left; k <= right; k++) {
            if (L[i] <= R[j]) {
                a[k] = L[i];
                i++;
            } else {
                a[k] = R[j];
                j++;
            }
        }
    }

    public void myqsort(int arr[], int  left, int right)
    {
        int l =  left;
        int h = right;
        int povit = arr[ left];
        while (l < h)
        {
            while (l < h && arr[h] >= povit)
            h--;
            if (l < h) {
                int temp = arr[h];
                arr[h] = arr[l];
                arr[l] = temp;
                l++;
        }

        while (l < h && arr[l] <= povit)
            l++;
        if (l < h) {
            int temp = arr[h];
            arr[h] = arr[l];
            arr[l] = temp;
            h--;
        }
        }
    }

    public static void main(String[] args) {
        Main t1 = new Main();
        /**
         * 生成随机数文件
         */
//        t1.createRandom(100000,"test10W.txt");
//        t1.createRandom(150000,"test15W.txt");
//        t1.createRandom(200000,"test20W.txt");
//        t1.createRandom(250000,"test25W.txt");
//        t1.createRandom(3000000,"test300W.txt");
        t1.test("test10W.txt", 100000);
        t1.test("test15W.txt", 150000);
        t1.test("test20W.txt", 200000);
        t1.test("test25W.txt", 250000);
        t1.test("test300W.txt", 3000000);

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(t1.mergeResult[0],"归并排序","100000");
        dataset.addValue(t1.mergeResult[1],"归并排序","150000");
        dataset.addValue(t1.mergeResult[2],"归并排序","200000");
        dataset.addValue(t1.mergeResult[3],"归并排序","250000");
        dataset.addValue(t1.mergeResult[4],"归并排序","3000000");

        dataset.addValue(t1.qsortResult[0],"快速排序","100000");
        dataset.addValue(t1.qsortResult[1],"快速排序","150000");
        dataset.addValue(t1.qsortResult[2],"快速排序","200000");
        dataset.addValue(t1.qsortResult[3],"快速排序","250000");
        dataset.addValue(t1.qsortResult[4],"快速排序","3000000");

        JFreeChart chart = ChartFactory.createLineChart(
                "排序算法时间复杂度",// 报表题目，字符串类型
                "dataNums", // 横轴
                "RunningTime/ms", // 纵轴
                dataset, // 获得数据集
                PlotOrientation.VERTICAL, // 图标方向垂直
                true, // 显示图例
                false, // 不用生成工具
                false // 不用生成URL地址
        );

        //字体清晰
        chart.setTextAntiAlias(false);
        // 设置背景颜色
        chart.setBackgroundPaint(Color.WHITE);

        // 设置图标题的字体
        Font font = new Font("隶书", Font.BOLD, 25);
        chart.getTitle().setFont(font);

        // 设置面板字体
        Font labelFont = new Font("SansSerif", Font.TRUETYPE_FONT, 12);
        // 设置图示的字体
        chart.getLegend().setItemFont(labelFont);

        CategoryPlot categoryplot = (CategoryPlot) chart.getPlot();
        // x轴 // 分类轴网格是否可见
        categoryplot.setDomainGridlinesVisible(true);
        // y轴 //数据轴网格是否可见
        categoryplot.setRangeGridlinesVisible(true);
        categoryplot.setRangeGridlinePaint(Color.WHITE);// 虚线色彩
        categoryplot.setDomainGridlinePaint(Color.WHITE);// 虚线色彩
        categoryplot.setBackgroundPaint(Color.lightGray);// 折线图的背景颜色
//        // 显示折点数据
//        lineandshaperenderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
//        lineandshaperenderer.setBaseItemLabelsVisible(true);

        StandardChartTheme standardChartTheme=new StandardChartTheme("CN");
        //设置标题字体
        standardChartTheme.setExtraLargeFont(new Font("隶书",Font.BOLD,20));
        //设置图例的字体
        standardChartTheme.setRegularFont(new Font("宋书",Font.PLAIN,15));
        //设置轴向的字体
        standardChartTheme.setLargeFont(new Font("宋书",Font.PLAIN,15));
        //应用主题样式
        ChartFactory.setChartTheme(standardChartTheme);
        //在D盘目录下生成图片
        File file = new File("chart.jpeg");
        try {
            ChartUtilities.saveChartAsJPEG(file, chart, 800, 600);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //使用ChartFrame对象显示图像
        ChartFrame frame = new ChartFrame("xyz",chart);
        frame.setVisible(true);
        frame.pack();

    }
}
