import java.util.ArrayList;
import java.util.List;

public class AreSimilar {

	public static void main(String[] args) {
		int[] a = {832, 998, 148, 570, 533, 561, 894, 147, 455, 279};
		int[] b = {832, 998, 148, 570, 533, 561, 455, 147, 894, 279};
		
		System.out.println(areSimilar(a, b));

	}
	
	static boolean areSimilar(int[] a, int[] b) {
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
//	    System.out.println(list1.size());
//	    System.out.println(list1.get(0)+" - "+list2.get(1)+" - "+list1.get(1)+" - "+list2.get(0));
	    if (list1.size() ==2 && (list1.get(0).equals(list2.get(1)) && list1.get(1).equals(list2.get(0)))) {
            return true;
        }
	    return false;
	}


}
