package main.examples;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class NumbersNeeded {

	public static int numberNeeded(String first, String second) {
		if (first.equals(second))
			return 0;
		Map<Character, Integer> mapS1 = stringToMap(first);
		Map<Character, Integer> mapS2 = stringToMap(second);
		int count = 0;

	    Iterator<Map.Entry<Character, Integer>> it = mapS1.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Character, Integer> pair = (Map.Entry<Character, Integer>) it.next();
			Character key = pair.getKey();
			if (mapS2.containsKey(key)) {
				Integer aux = mapS2.get(key);
				Integer diff = pair.getValue() - aux;
				count = diff >= 0 ? count + diff : count + (-1)*diff;
				mapS2.remove(key);
			} else {
				count += pair.getValue();
			}
		}
		Iterator<Map.Entry<Character, Integer>> it2 = mapS2.entrySet().iterator();
		while (it2.hasNext()) {
			Map.Entry<Character, Integer> pair = (Map.Entry<Character, Integer>) it2.next();
			count += pair.getValue();
		}
		return count;
	}

	public static Map<Character, Integer> stringToMap(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			Integer val = map.get(new Character(c));
			if (val != null) {
				map.put(c, new Integer(val + 1));
			} else {
				map.put(c, 1);
			}
		}
		return map;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String a = in.next();
		String b = in.next();
		System.out.println(numberNeeded(a, b));
	}
}
