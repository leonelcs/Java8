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
		List<Integer> trips = new ArrayList<>();
		List<Integer> packagesSorted = Arrays.stream(packagesWeight).boxed().sorted((a, b) -> -Integer.compare(a, b))
				.collect(Collectors.toList());

		for (int pack : packagesSorted) {

			OptionalInt pos = IntStream.range(0, trips.size())
					.filter(ind -> trips.get(ind) + pack <= tripMaxWeight)
					.findFirst();

			if (pos.isPresent()) {
				trips.set(pos.getAsInt(), trips.get(pos.getAsInt()) + pack);
			} else {
				trips.add(pack);
			}
		}

		return trips.size();
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
