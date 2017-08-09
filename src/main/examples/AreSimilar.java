package main.examples;
import java.util.ArrayList;
import java.util.List;

public class AreSimilar {

	public static boolean areSimilar(int[] a, int[] b) {
	    List<Integer> list1 = new ArrayList<>();
	    List<Integer> list2 = new ArrayList<>();
	    for (int i=0; i < a.length; i++) {
	        if (a[i] != b[i]) {
	            list1.add(a[i]);
	            list2.add(b[i]);
	        }
	    }
	    
	    if (list1.size() == 0) {
	        return true;
	    }

	    if (list1.size() ==2 && (list1.get(0).equals(list2.get(1)) && list1.get(1).equals(list2.get(0)))) {
            return true;
        }
	    return false;
	}


}
