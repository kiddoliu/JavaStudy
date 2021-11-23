package com.company;

import java.io.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class A
{
    int i = 50;
    @Override
    protected void finalize() throws Throwable{
        System.out.println("final");
    }

}
public class Main {

    public static void main(String[] args) throws Exception{
      /*  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a char");
        char c = (char)reader.read();

        System.out.println("Char:" + c);
        // 读取单个字节
        reader.read();
        System.out.println("Input a line");
        String s = reader.readLine();
        System.out.println("string" + s);
        reader.close();
       */

        // createFile example
       createFile();
    }
    public static void createFile() throws Exception{
        File file = new File("/Users/admin/project/JavaStudy","abc.text");
        // 生成文件
        file.createNewFile();

        // 判断是目录还是文件
        if (file.isFile()){
            System.out.println("this is a file");
        } else {
            System.out.println("this is a directory");
        }

        // 重命名
        File file2 = new File("/Users/admin/project/JavaStudy","abc1.text");
        if (file.renameTo(file2)){
            System.out.println("文件移动成功");
        } else {
            System.out.println("文件移动失败");
        }


       FileWriter fw = new FileWriter(file2);
        fw.write("你好");
        System.out.println(fw.getEncoding());
        fw.append("ddd");
        fw.flush();

        FileReader fr = new FileReader(file2);
        String sb = new String();
        while(fr.read() != -1){
            System.out.println(sb.toString());
        }
    }

    public static void longErgodic(File file4, List<File> files){
        File[] fillarr = file4.listFiles();
        if(fillarr == null){
            System.out.println("ddddfdf");
            return;
        }

        for (File file: fillarr
             ) {
            files.add(file);
            longErgodic(file, files);
        }
    }
}
