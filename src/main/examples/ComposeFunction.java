package main.examples;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ComposeFunction {
	
	public static void main(String[] args) {
		
		System.out.println("before");
		
		Function<Double, Double> doubleFunction = x -> x * x;
		Function<Double, Double> before
		= doubleFunction.compose(x -> x + 2);
		
		Function<Double, Double> after
		= doubleFunction.andThen(x -> x + 2);
		
		
		
		List<Double> lista =  new ArrayList<>();
		lista.add(new Double(15));
		lista.add(new Double(5));
		lista.add(new Double(25));
		lista.add(new Double(150));
		lista.add(new Double(-15));
		
		lista.stream()
			.map(l -> before.apply(l))
			.forEach(System.out::println);
		
		System.out.println("after");
		
		lista.stream()
		.map(l -> after.apply(l))
		.forEach(System.out::println);
//		System.out.println(second.apply(new Double(15)));

	}

}
