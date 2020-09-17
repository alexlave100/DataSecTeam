package com.contest;

import java.io.*;

public class App {

    public static void main(String[] args) throws IOException {
      File file = new File("File.txt");

      InputStream ips = new FileInputStream(file);
      OutputStream ops = System.out;

      int c;

      while((c = ips.read()) != -1)  {
        ops.write(c);
      } 
      
      System.out.println();
      
      ips.close();
      ops.close();

      int test = -5;
      int comeon = Math.abs(test);
      System.out.println("Hello World! " + comeon);
    }
}
