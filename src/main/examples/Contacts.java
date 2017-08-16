package main.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Contacts {
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<String> addList = new ArrayList<>();
        List<String> findList = new ArrayList<>();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            if (op.equals("add"))
            	addList.add(contact);
            if (op.equals("find"))
            	findList.add(contact);
        }

        findList.stream()
        	.forEach( f -> System.out.println(count(addList, f)) );
    }
	
	static int count(List<String> addList, String find) {

		
		Pattern pattern = Pattern.compile("^("+find+")");
		return addList.stream()
			.filter( l -> pattern.matcher(l.trim()).find() )
			.collect(Collectors.toList()).size();

	}

}
