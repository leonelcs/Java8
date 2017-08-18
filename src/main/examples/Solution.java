package main.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Solution {

	/*
	 * Complete the function below.
	 */

	static int minimumNumberOfTrips(int tripMaxWeight, int[] packagesWeight) {
		int count = 0;
		List<Integer> list = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		for (int i=0; i< packagesWeight.length; i++) {
			list.add(packagesWeight[i]);
		}
		
		Collections.sort(list);
		list2 = list;

		for (int i=list.size()-1;i>=0;i--) {
			Integer aux = list.get(i);
			Optional<Integer> value = list.stream().filter( l -> l <= tripMaxWeight - aux )
				.findFirst();
			if (value.isPresent()) {
				count +=1;
				list2.remove(value.get());
				list2.remove(list.get(i));
				if (list2.size()==0)
					return count;
			} else {
				count +=1;
				list2.remove(list.get(i));
			}

		}
		return count; 

	}

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int tripMaxWeight = in.nextInt();
        int numberOfPackages = in.nextInt();

        int[] packagesWeight = new int[numberOfPackages];

        for (int i = 0; i < numberOfPackages; i++) {
            packagesWeight[i] = in.nextInt();
        }

        int minimumNumberOfTrips = minimumNumberOfTrips(tripMaxWeight, packagesWeight);

        System.out.println(minimumNumberOfTrips);
        
        in.close();
    }

}
