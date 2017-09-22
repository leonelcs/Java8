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
    	
        List<Integer []> listOfLists = new ArrayList<>();
        if (n==0 && k==0) {
            int[][] retorno = new int[1][];
            retorno[0] = new int[1];
            
        } else {

    	waysToReachN(0,n,k,null, listOfLists);
    	int[][] retorno = new int[listOfLists.size()][];
    	int i=0;
    	for (Integer[] list: listOfLists) {
    		retorno[i] = new int[list.length];
    		for (int j=0;j<list.length;j++) {
    			retorno[i][j] = list[j];
    			System.out.print(retorno[i][j]+" ");
    		}
    		System.out.println("");
    		i++;
    	}
        }
//        return retorno;
    }
    
    
    
    public static void waysToReachN(int currentValue, int n, int k, List<Integer> pathSoFar, List<Integer []> matrix) {
        if(currentValue == n) {
            matrix.add(pathSoFar.toArray(new Integer[pathSoFar.size()]));
            return;
        } else if(currentValue > n) {
            return;
        }
        for(int i = 1 ; i <= k ; i++) {
        	if (pathSoFar==null)
        		pathSoFar = new ArrayList<>();
            // add step
            pathSoFar.add(i);

            // recurse
            waysToReachN(currentValue + i, n, k, pathSoFar, matrix);

            // remove step
            pathSoFar.remove(pathSoFar.size()-1);
        }
    }


}