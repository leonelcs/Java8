package examples;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrangePalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(palindromeRearranging("aabbbc"));
	}
	
	public static boolean palindromeRearranging(String inputString) {
	    Stream<Character> sch = inputString.chars().mapToObj(i -> (char) i);
	    
	    Map<Character, Integer> map = sch
	         .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1)));
	    
	    List<Integer> impares = new ArrayList<>();
	    
	    map.entrySet().stream()
	    		.filter(m -> { if (m.getValue()%2 == 1)
	    							return true;
	    						else
	    							return false;
	    			}
	    		)
	    		.forEach(t -> impares.add(1));
	    
	    if (impares.size()>1) {
	    	return false;
	    }
	    
	    return true;
	}

}
