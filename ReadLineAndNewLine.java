package com.days21;

import java.io.*;

/**
 * @author 一笑奈何
 * @create 2019-02-20 18:43
 * @desc 字符缓冲流的特殊功能--常用--掌握
 *
 * /*
 * 		 * ===BufferedReader
 * 		 * ----String readLine()读取一整行数据(循环读取多行时不自动换行)
 * 		 *
 * 		 * ==BufferedWriter
 * 		 	--- void newLine()在每行的行尾写入一个换行符
 * 		 */

public class ReadLineAndNewLine {
    /*
    需求:
    把a.txt复制到b.txt
     */
    public static void main(String[] args)  {
        File filePath=new File("b.txt");
        //封装数据源
        //InputStreamReader----FileReader---BufferedReader
        BufferedReader reader=null;
        //传输目的地
        //OutputStreamWriter---FileWriter--BufferedWriter
        BufferedWriter writer=null;
        try {
             reader=new BufferedReader(new FileReader("E:\\javaSE\\集合\\a.txt"));
             writer=new BufferedWriter(new FileWriter(filePath));

        } catch (IOException e) {
            e.printStackTrace();
        }
        String line="";
        //readLine()读取一行数据,行尾不会自动换行---读取时读不到会返回null(多是循环里用)
       try {
           while((line=reader.readLine())!=null){
                writer.write(line);
                //write()多用于配合newLine()一起用,用来在行尾换行
               writer.newLine();
           }
           writer.close();
           reader.close();
           System.out.println(filePath.getAbsolutePath());
       }catch (IOException e){}
    }
}
