package main.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SumOfTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,3};
		int[] b = {10,20,30,40};
		int v = 42;
		System.out.println(sumOfTwo(a, b, v));
	}
	
	public static boolean sumOfTwo(int[] a, int[] b, int v) {
		
		Set<Integer> setA = IntStream.of(a).boxed().collect(Collectors.toSet());
		
		List<Integer> listB = IntStream.of(b).boxed().collect(Collectors.toList());

		List<Integer> aOpt = new ArrayList<>();
		
		listB.stream()
			.map(lb -> v - lb)
			.forEach(t -> aOpt.add(t));
		
		Optional<Integer> result = aOpt.stream()
			.filter(o -> setA.contains(o))
			.findFirst();
		
		if (result.isPresent()) {
			return true;
		} else {
			return false;
		}
	}

}
