package main.examples;

import java.util.Scanner;

public class HourGlass {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int i=0; i < 6; i++){
            for(int j=0; j < 6; j++){
                arr[i][j] = in.nextInt();
            }
        }
        int biggestValue = Integer.MIN_VALUE;
        for(int i=0; i < 4; i++){
            for(int j=0; j < 4; j++){
                int value = sumOfHourGlass(arr,i,j);
                if (value>biggestValue) {
                    biggestValue = value;
                }
            }
        }
        System.out.println(biggestValue);
    }
    
    public static int sumOfHourGlass(int[][] arr, int st_i, int st_j) {
        return arr[st_i][st_j] + arr[st_i][st_j+1] + arr[st_i][st_j+2]+arr[st_i+1][st_j+1]+
            arr[st_i+2][st_j] + arr[st_i+2][st_j+1] + arr[st_i+2][st_j+2];
    }

}
