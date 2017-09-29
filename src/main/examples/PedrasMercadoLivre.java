package main.examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class PedrasMercadoLivre {
    public static void main(String args[] ) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in = new Scanner(System.in);

        int numberOfStones = in.nextInt();

        String[] stones = new String[numberOfStones+1];
        for (int i=0; i < numberOfStones; i++) {
            stones[i] = in.next();
        }
        in.close();
        
        char[] charArr = stones[0].toCharArray();
        Set<Character> setChar = new HashSet<>();
        for (int i=0;i<charArr.length;i++) {
        	setChar.add(charArr[i]);
        }

        for (int i=0;i<charArr.length;i++) {
        	for (int j=1; j<numberOfStones;j++) {
        		if (stones[j].indexOf(charArr[i]) == -1) {
        			setChar.remove(charArr[i]);
        		}
        	}
        }
     
        System.out.println(setChar.size());
        
    }

}
