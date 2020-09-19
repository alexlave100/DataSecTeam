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
      while(i < s.length()) {
        sb = new StringBuffer();       
        while(i < s.length() && s.charAt(i) != ' ') {
          sb.append(s.charAt(i++));
        }

        insertData(sb, col);
        col++;
        i++;
      }
      i = col = 0;
    }
  }


  private static void insertData(StringBuffer sb, int col) {
    switch (col) {
      case 0:
        App.startTime.add(parseString(sb.toString()));
        break;
      case 1:
        App.startX.add(parseString(sb.toString()));
        break;
      case 2:
        App.startY.add(parseString(sb.toString()));
        break;
      case 3:
        App.destX.add(parseString(sb.toString()));
        break;
      case 4:
        App.destY.add(parseString(sb.toString()));
        break;
      case 5:
        App.walkingDistance.add(parseString(sb.toString()));
        break;
    }
  }
  
  private static int parseString(String str) {
    return Integer.parseInt(str);
  }
}
