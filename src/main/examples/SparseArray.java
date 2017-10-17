package main.examples;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SparseArray {
	
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int nString = in.nextInt();
        String[] arrayStrings = new String[nString];
        for (int i=0; i < nString; i++) {
        	arrayStrings[i] = in.next();
        }
        int nQueues = in.nextInt();

        int[] resultArray = new int[nQueues];
        Arrays.fill(resultArray, 0);
        List<String> streamStrings = Arrays.asList(arrayStrings);

        for (int i=0; i < nQueues; i++) {
        	String queue = in.next();
        	resultArray[i] = Collections.frequency(streamStrings, queue );
        }
        for (int i=0;i<nQueues;i++) {
        	System.out.println(resultArray[i]);
        }
        
        
    }

}
