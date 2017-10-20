package main.examples;

import java.util.Scanner;
import java.util.Stack;

public class NBaseConverter {
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		//first one is the number
        int number = in.nextInt();
		//second is the base
        int base = 7;
                
        System.out.println(convertion(number));
        
	}
	
	public static String getLetter(int value) {
		switch (value){
			case 0:
				return "0";
			case 1:
				return "a";
			case 2:
				return "t";
			case 3:
				return "l";
			case 4:
				return "s";
			case 5:
				return "i";
			case 6:
				return "n";
		}
	}
	
	public static String convertion(long number) {
		int base = 7;
//		String[] baseString = {"0","a","t","l","s","i", "n" };
		
		if (number < base) {
			return getLetter((int) number%base);
		} else {
			return convertion(number/base) + getLetter((int) number%base);
		}
	}
	
    static String convert(long input) {
		String[] baseString = {"0","a","t","l","s","i", "n" };
		Stack<Integer> stack = new Stack<>();
		while (input >= 7)
		{	
			stack.push(Integer.valueOf((int) input % 7));
			input = input/7;
		}	
			
		String str = new String(""+baseString[(int) input]);
		while (!stack.isEmpty()) {
			str = str+ baseString[stack.pop()];
		}
        return str;
    }
    
//    static int find(LinkedListNode list, LinkedListNode sublist) {
//        LinkedListNode headSubList = sublist;
//        int index = 0;
//        if (list==null || sublist==null)
//            return -1;
//        if (list!=null && sublist!=null) {
//            while (!list.val.equals(sublist.val)) {
//                list = list.next;
//                index++;
//            }
//            else {
//                while (list.val.equals(sublist.val) && list!=null && sublist!=null) {
//                    list = list.next;
//                    sublist = sublist.next;
//                }
//                if (sublist!=null)
//                    find(list, headSubList);
//                else 
//            }
//        }
//
//    }

}

