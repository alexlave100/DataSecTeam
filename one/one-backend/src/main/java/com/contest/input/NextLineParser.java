package com.contest.input;

import com.contest.App;

import java.io.BufferedReader;
import java.io.IOException;

public class NextLineParser {

  public NextLineParser() {}

  public static void parseRentalInformation(BufferedReader br) throws IOException {
    StringBuffer sb = new StringBuffer();  
    String s = new String();
    int i = 0, col = 0;

    while((s = br.readLine()) != null) {
      int length = s.length();
      while(i < length) {
        sb = new StringBuffer();       
        while(i < s.length() && s.charAt(i) != ' ')
          sb.append(s.charAt(i++));
        insertData(sb.toString(), col);
        col++; i++;
      }
      i = col = 0;
    }
  }

  private static void insertData(String s, int col) {
    switch (col) {
      case 0:
        App.startTime.add(parseString(s));
        break;
      case 1:
        App.startX.add(parseString(s));
        break;
      case 2:
        App.startY.add(parseString(s));
        break;
      case 3:
        App.destX.add(parseString(s));
        break;
      case 4:
        App.destY.add(parseString(s));
        break;
      case 5:
        App.walkingDistance.add(parseString(s));
        break;
    }
  }
  
  private static int parseString(String str) {
    return Integer.parseInt(str);
  }
}
