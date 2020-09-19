package com.contest.input;

import com.contest.App;

import java.io.BufferedReader;
import java.io.IOException;

public class FirstLineParser {

  public FirstLineParser() {}

  public static void parseFirstLine(BufferedReader br) throws IOException {
    StringBuffer sb = new StringBuffer();
    
    String s = br.readLine();
    int i = 0, length = s.length();

    while(i < length) {
      sb = new StringBuffer();
      while(i < s.length() && s.charAt(i) != ' ') {
        sb.append(s.charAt(i++));
      }
      App.rentalData.add(parseString(sb.toString()));
      i++;
    }
  }
  
  private static int parseString(String str) {
    return Integer.parseInt(str);
  }

}
