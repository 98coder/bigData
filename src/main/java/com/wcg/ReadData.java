package com.wcg;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ReadData {

    public static String FILE_NAME = "D:\\User.dat";

    private static void readData() throws IOException {
        // User.dat 一行100万数据，共3650行
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(FILE_NAME), StandardCharsets.UTF_8));
        String line;
        long start = System.currentTimeMillis();
        int count = 1;
        while ((line = br.readLine()) != null) {
            // 按行读取
//            SplitData.splitLine(line);
            if (count % 100 == 0) {
                System.out.println("读取第" + count/100 + "个100行,总耗时间: " + (System.currentTimeMillis() - start) / 1000 + " s");
                System.gc();
            }
            count++;
        }
        boolean running = false;
        br.close();

    }

    public static void main(String[] args) throws IOException {
        readData();
    }
}
