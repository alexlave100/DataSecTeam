package com.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;

import java.util.ArrayList;

import com.contest.input.FirstLineParser;
import com.contest.input.NextLineParser;

public class App {
/**
 * 
(X) 4 2 1 2 5
    0 4 2 3 4 1
    0 0 3 3 4 2
    1 9 4 6 6 1
    3 4 6 7 6 2
*/

  // (X) The first line in the input file - 1: number of rentals
  //                                        2: number of bicycles
  //                                        3: number of trucks
  //                                        4: amount of bicycles every truck can carry at one time
  //                                        5: bonus sum for every rental in the city
  //                                        
  public static ArrayList<Integer> rentalData      = new ArrayList<>(); 
  // First number in the rest of the lines in the input file - denotes the start time of the rental (1st line = rental 0)
  public static ArrayList<Integer> startTime       = new ArrayList<>();
  // X coordinate where the customer is starting
  public static ArrayList<Integer> startX          = new ArrayList<>();
  // Y coordinate where the customer is starting
  public static ArrayList<Integer> startY          = new ArrayList<>();
  // X coordinate for the destination
  public static ArrayList<Integer> destX           = new ArrayList<>();
  // Y coordinate for the destination
  public static ArrayList<Integer> destY           = new ArrayList<>();
  // Max distance the customer will walk to rent a bicycle
  public static ArrayList<Integer> walkingDistance = new ArrayList<>();

    public static void main(String[] args) throws IOException{
      File file = new File("../ctsten0244_input_5.txt");
      FileReader f = new FileReader(file);
      BufferedReader br = new BufferedReader(f);

      try {
        FirstLineParser.parseFirstLine(br);
      } catch (Exception e) {
        System.out.println("Not good"); 
        return;
      }

      try {
        NextLineParser.parseRentalInformation(br);
      } catch (Exception e) {
        System.out.println("Rental info parse error");
        return;
      }

      int i  = 0;
      // Prints all fields of all rentals + header(rentalData) - just to test that the parser works.
      // This below prints identical output to the input files
      while(i < 5)
        System.out.print(rentalData.get(i++) + " ");
      System.out.println();
      i = 0;
      while(i < rentalData.get(0)) {
        System.out.print(startTime.get(i) + " ");
        System.out.print(startX.get(i) + " ");
        System.out.print(startY.get(i) + " ");
        System.out.print(destX.get(i) + " ");
        System.out.print(destY.get(i) + " ");
        System.out.println(walkingDistance.get(i++));
      }

       String s = br.readLine();
       //  Just to verify that next line is null (we have reached EOF)
       System.out.println("Next line is: " + s);

       br.close();
    }
}
