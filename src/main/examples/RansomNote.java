package main.examples;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RansomNote {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();

		Map<String, Integer> magazine = new HashMap<>();
		for (int magazine_i = 0; magazine_i < m; magazine_i++) {
			String word = in.next();
			if (magazine.containsKey(word)) {
				Integer value = magazine.get(word);
				magazine.put(word, value + 1);
			} else {
				magazine.put(word, 1);
			}
		}
		System.out.println(checkMagazine(in, magazine, n));
		in.close();
	}
	
	public static String checkMagazine(Scanner in, Map<String, Integer> magazine, int n) {
		for (int ransom_i = 0; ransom_i < n; ransom_i++) {
			String ransom_word = in.next();
			if (!magazine.containsKey(ransom_word)) {
				return "No";
			} else {
				Integer value = magazine.get(ransom_word);
				if (value - 1 < 0) {
					return "No";
				} else {
					magazine.put(ransom_word, value - 1);
				}
			}
		}

		return "Yes";
	}

}
