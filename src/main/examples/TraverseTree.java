package main.examples;

import java.util.ArrayList;
import java.util.List;

public class TraverseTree {

	public List<Integer> traverseTree(Tree<Integer> t, List<Integer> list) {
		if (t==null)
			return list;
		else {
			if (list==null)
				list = new ArrayList<>();
			list.add(t.value);
			list = traverseTree(t.left,list);
			list = traverseTree(t.right,list);
		}
		return list;
	}
	
	int[] traverseTree(Tree<Integer> t) {
	    List<Integer> list = new ArrayList<>();
	    list.addAll(traverseTree(t,list));
	    int[] retorno = new int[list.size()];
	    int i=0;
	    for (Integer value: list) {
	    	retorno[i] = value.intValue();
	    	i++;
	    }
	    return retorno;
	    
	}

}

class Tree<T> {
	Tree(T x) {
		value = x;
	}

	T value;
	Tree<T> left;
	Tree<T> right;
}
