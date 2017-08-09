import java.util.function.BiFunction;
import java.util.function.Function;

public class Currying {
	
	public static void main(String[] args) {
		System.out.println(biFunctionConcat.apply("Cat", "Dog"));
		
		curryConcat = (a) -> (b) -> biFunctionConcat.apply(a, b);
		System.out.println(curryConcat);
		
		Function<String,String> intermediateFunction;
		
		intermediateFunction = curryConcat.apply("Cat");
		
		System.out.println(intermediateFunction);
		System.out.println(curryConcat.apply("Cat"));
		System.out.println(intermediateFunction.apply("Dog"));
		
		
	}
	
	static BiFunction<String, String, String> biFunctionConcat =
			(a, b) -> a + b;

	static Function<String, Function<String, String>> curryConcat;
	
}
