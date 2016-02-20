package com.Helpers;

/**
 * Created by brianyan on 11/30/15.
 */
/*
 * This is the file with your answer, do not rename or move it.
 * Write your code in it, and save it before submitting your answer.
 */

import com.sun.tools.javac.util.Paths;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * This is the file with your answer, do not rename or move it.
 * Write your code in it, and save it before submitting your answer.
 */
public class Answer {

    /**
     * Obtains the smallest window that encloses all the provided
     * windows. This function declaration must be kept unmodified.
     *
     * @param windows A list of strings, each one representing a window,
     *                eg, ['X=10 Y=20 W=30 H=40', 'W=50 H=60 X=70 Y=80'].
     * @return A string representing the smallest window that encloses the
     *        provided windows.
     */

    public static String getEnclosingRectangle(String[] windows) {

        // Write your implementation here
        int [] result = new int [4];
        String [] temp = new String[4];
        int MaxH = Integer.MIN_VALUE;
        int MaxW = Integer.MIN_VALUE;
        int MinX = Integer.MAX_VALUE;
        int MinY = Integer.MAX_VALUE;
        int count = 0;
        // convert to just X Y W H
        for(int i = 0; i < windows.length; i++) {
            temp = windows[i].split(" ");
            for(count = 0;count<result.length;count++){
                result[count] = Integer.parseInt(temp[count].replaceAll("[^0-9]", ""));
            }
            // now check the cases
            //Case 1 : MinX
            if(result[0] < MinX){
                MinX = result[0];
            }
            //Case 2: MinY
            if(result[1] < MinY){
                MinY = result[1];
            }
            if(result[0] + result[2] > MaxW){
                MaxW = result[0] + result[2];
            }
            if(result[1] + result[3] > MaxH){
                MaxH = result[1] + result[3];
            }
        }
        MaxW = MaxW - MinX;
        MaxH = MaxH - MinY;
        StringBuilder EnclosingRectangle = new StringBuilder();
        EnclosingRectangle.append("X=" + MinX + " Y=" + MinY + " W=" + MaxW + " H=" + MaxH);

        return EnclosingRectangle.toString();
    }

    public static String [] findIps(String logPath){
        ArrayList<String> list = new ArrayList<String>();
        try {
            Scanner s = new Scanner(new File("logPath"));
StringBuilder str = new StringBuilder("hu");
           // str.toString().sp
            while(s.hasNext()) {
                list.add(s.nextLine());
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }


        return new String[] {"Not implemented"};
    }


    /**
     * This tests your code with basic examples, and is provided only for
     * your convenience.
     */
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        String[] firstWindow = {"X=5 Y=9 W=10 H=40",
                "X=16 Y=9 W=10 H=40"};
        String[] secondWindow = {"X=0 Y=0 W=1 H=5",
                "X=0 Y=8 W=1 H=9",
                "X=3 Y=1 W=10 H=12"};
        String[][] windowStrings = {firstWindow, secondWindow};
        for (String[] windows : windowStrings) {
            System.out.println(getEnclosingRectangle(windows));
        }
    }
}
