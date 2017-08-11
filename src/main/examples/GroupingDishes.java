package main.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author llsa
You have a list of dishes. Each dish is associated with a list of ingredients used to prepare it. You want to group the dishes by ingredients, so that for each ingredient you'll be able to find all the dishes that contain it (if there are at least 2 such dishes).

Return an array where each element is a list with the first element equal to the name of the ingredient and all of the other elements equal to the names of dishes that contain this ingredient. The dishes inside each list should be sorted lexicographically. The result array should be sorted lexicographically by the names of the ingredients in its elements.

Example

For
  dishes = [["Salad", "Tomato", "Cucumber", "Salad", "Sauce"],
            ["Pizza", "Tomato", "Sausage", "Sauce", "Dough"],
            ["Quesadilla", "Chicken", "Cheese", "Sauce"],
            ["Sandwich", "Salad", "Bread", "Tomato", "Cheese"]]
the output should be
  groupingDishes(dishes) = [["Cheese", "Quesadilla", "Sandwich"],
                            ["Salad", "Salad", "Sandwich"],
                            ["Sauce", "Pizza", "Quesadilla", "Salad"],
                            ["Tomato", "Pizza", "Salad", "Sandwich"]]
For
  dishes = [["Pasta", "Tomato Sauce", "Onions", "Garlic"],
            ["Chicken Curry", "Chicken", "Curry Sauce"],
            ["Fried Rice", "Rice", "Onions", "Nuts"],
            ["Salad", "Spinach", "Nuts"],
            ["Sandwich", "Cheese", "Bread"],
            ["Quesadilla", "Chicken", "Cheese"]]
the output should be
  groupingDishes(dishes) = [["Cheese", "Quesadilla", "Sandwich"],
                            ["Chicken", "Chicken Curry", "Quesadilla"],
                            ["Nuts", "Fried Rice", "Salad"],
                            ["Onions", "Fried Rice", "Pasta"]]
Input/Output

[time limit] 4000ms (js)
[input] array.array.string dishes

An array of dishes. dishes[i] for each valid i contains information about the ith dish: the first element of dishes[i] is the name of the dish and the following elements are the ingredients of that dish. Both the dish name and the ingredient names consist of English letters and spaces. It is guaranteed that all dish names are different. It is also guaranteed that ingredient names for one dish are also pairwise different.

Guaranteed constraints:
1 ≤ dishes.length ≤ 500,
2 ≤ dishes[i].length ≤ 10,
1 ≤ dishes[i][j].length ≤ 50.

[output] array.array.string

The array containing the grouped dishes.
 */

public class GroupingDishes {
	
	public static void main(String[] args) {
		String[][] dishes = {{"Salad", "Tomato", "Cucumber", "Salad", "Sauce"},
		            {"Pizza", "Tomato", "Sausage", "Sauce", "Dough"},
		            {"Quesadilla", "Chicken", "Cheese", "Sauce"},
		            {"Sandwich", "Salad", "Bread", "Tomato", "Cheese"}};
		System.out.println(groupingDishes(dishes));
		
		
	}
	
	public static String[][] groupingDishes(String[][] dishes) {
	   
		Map<String, List<String>> map = new HashMap<>();
		
		for (int i=0; i < dishes.length; i++) {
			for (int j=1; j < dishes[i].length; j++) {
				if (!map.containsKey(dishes[i][j])) {
					List<String> list = new ArrayList<>();
					list.add(dishes[i][0]);
					map.put(dishes[i][j], list);
				} else {
					List<String> list = map.get(dishes[i][j]);
					if (!list.contains(dishes[i][0]))
						list.add(dishes[i][0]);
					map.put(dishes[i][j],list);
				}
			}
		}
		
		List<String[]> cleanList = new ArrayList<>();
		map.entrySet().stream()
			.filter(m -> m.getValue().size() > 1)
			.sorted(Map.Entry.comparingByKey())
			.forEach( l -> {
				List<String> temp = new ArrayList<>();
				temp.add(l.getKey());
				Collections.sort(l.getValue());
				temp.addAll(l.getValue());
				cleanList.add(temp.toArray(new String[0]));
			});

		String[][] retorno = cleanList.toArray(new String[0][0]);
				
		return retorno;
	   
	}

}
