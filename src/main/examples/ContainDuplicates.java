package main.examples;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContainDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a1 = {1,2,3,4,5,6,7,8,9};
		System.out.println(containsDuplicates(a1));
		int[] a2 = {1,2,3,4,6,6,7,8,9};
		System.out.println(containsDuplicates(a2));

	}
	
	public static boolean containsDuplicates(int[] a) {
		Set<Integer> set = new HashSet<>();
		
		for (int i = 0; i < a.length; i++) {
			if (set.contains(a[i])) {
				return true;
			} else {
				set.add(a[i]);
			}

		}

		return false;
	}

}
