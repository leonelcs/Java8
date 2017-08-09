package main.examples;
import java.util.function.Function;

public class Memoization {
	
//	private static final Map<Integer, Integer> memoizationCache = new HashMap<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Function<Integer, Integer> memoizationFunction =
				Memoizer.memoize(squareFunction);
				System.out.println(memoizationFunction.apply(2));
				System.out.println(memoizationFunction.apply(2));
				System.out.println(memoizationFunction.apply(2));

	}
	
	static Function<Integer, Integer> squareFunction = x -> {
		System.out.println("In function");
		return x * x;
		};
	
//	private static Integer doComputeExpensiveSquare(Integer input) {
//		System.out.println("Computing square");
//		return 2 * input;
//	}
//	
//	public static Integer computeExpensiveSquare(Integer input) {
//		if (!memoizationCache.containsKey(input)) {
//			memoizationCache.put(input,
//			doComputeExpensiveSquare(input));
//		}
//		return memoizationCache.get(input);
//	}
	
	

}
