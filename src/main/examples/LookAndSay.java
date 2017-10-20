package main.examples;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LookAndSay {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		String number = in.next();
		int n = in.nextInt();
		System.out.println(LookAndSay(number, n));
		
		in.close();
	}
	
	static String LookAndSay(String start, int n) {
		String retorno = start;
		for (int i=0; i < n; i++)
			retorno = LookAndSay(retorno);
		return retorno;
	}

	static String LookAndSay(String start) {
		char[] charArray = start.toCharArray();
		int counter = 0;
		String retorno = "";
		for (int i=0; i < charArray.length; i++) {
			if (counter==0)
				counter++;
			else if (counter!=0 && charArray[i]==charArray[i-1]) {
				counter++;
			}
			else if (counter!=0 && (charArray[i]!=charArray[i-1])) {
				retorno = retorno + counter + charArray[i-1];
				counter = 1;
			}
			
 		}
		retorno = retorno + counter + charArray[charArray.length-1];
		return retorno;
	}

}
