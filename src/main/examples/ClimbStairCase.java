package main.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClimbStairCase {

    static int totalCounter = 0;
    
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	int n = in.nextInt();
    	int k = in.nextInt();
//    	List<List<Integer>> listOfLists = new ArrayList<>();
    	List<Integer> list = new ArrayList<>();
    	waysToReachN(0,n,k,list);
    }
    
    public static void waysToReachN(int currentValue, int n, int k, List<Integer> pathSoFar) {
        if(currentValue == n) {
            System.out.println(pathSoFar);
            totalCounter++;
            return;
        } else if(currentValue > n) {
            return;
        }
        for(int i = 1 ; i <= k ; i++) {
            // add step
            pathSoFar.add(i);

            // recurse
            waysToReachN(currentValue + i, n, k, pathSoFar);

            // remove step
            pathSoFar.remove(pathSoFar.size()-1);
        }
    }


}