package main.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
