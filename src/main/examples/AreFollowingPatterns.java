package main.examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class AreFollowingPatterns {
	
	/**
	 * 
	 * @param args
Given an array strings, determine whether it follows the sequence given in the patterns array. In other words, there should be no i and j for which strings[i] = strings[j] and patterns[i] ≠ patterns[j] or for which strings[i] ≠ strings[j] and patterns[i] = patterns[j].

Example

For strings = ["cat", "dog", "dog"] and patterns = ["a", "b", "b"], the output should be
areFollowingPatterns(strings, patterns) = true;
For strings = ["cat", "dog", "doggy"] and patterns = ["a", "b", "b"], the output should be
areFollowingPatterns(strings, patterns) = false.
Input/Output

[time limit] 4000ms (js)
[input] array.string strings

An array of strings, each containing only lowercase English letters.

Guaranteed constraints:
1 ≤ strings.length ≤ 105,
1 ≤ strings[i].length ≤ 10.

[input] array.string patterns

An array of pattern strings, each containing only lowercase English letters.

Guaranteed constraints:
patterns.length = strings.length,
1 ≤ patterns[i].length ≤ 10.

[output] boolean

Return true if strings follows patterns and false otherwise.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strings1 = {"cat", "dog", "dog"};
		String[] patterns1 = {"a", "b", "b"};
		System.out.println(areFollowingPatterns(strings1, patterns1));

		String[] strings2 = {"cat", "dog", "doggy"};
		String[] patterns2 = {"a", "b", "b"};
		System.out.println(areFollowingPatterns(strings2, patterns2));
	}
	
	static boolean areFollowingPatterns(String[] strings, String[] patterns) {
		Map<String,List<Integer>> map = new HashMap<>();
		for (int i=0; i< patterns.length; i++) {
			if (!map.containsKey(patterns[i])) {
				List<Integer> list = new ArrayList<>();
				list.add(i);
				map.put(patterns[i], list);
			} else {
				List<Integer> list = map.get(patterns[i]);
				list.add(i);
				map.put(patterns[i], list);
			}
		}
		
		Set<String> words = new HashSet<>();
		
		List<Integer> resultado = new ArrayList<>();
		map.entrySet().stream()
			.forEach(m -> {
				List<Integer> list = m.getValue();

				String word = strings[list.get(0).intValue()];
				if (!words.contains(word)) {
					words.add(word);
					Optional<Integer> value = list.stream()
							.filter(l -> !strings[l.intValue()].equals(word) )
							.findFirst();
						if (value.isPresent()) {
							resultado.add(value.get());
						}
				} else {
					resultado.add(-1);
				}
		});
		if (resultado.size() == 0)
			return true;
		return false;
	}


}
