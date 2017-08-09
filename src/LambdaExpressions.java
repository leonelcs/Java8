import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class LambdaExpressions {
	
	static List<String> numberString = Arrays.asList("12", "34", "82");
	static List<Integer> numbers = new ArrayList<>();
	static List<Integer> doubleNumbers = new ArrayList<>();
	static List<Integer> negateNumbers = new ArrayList<>();
	
	static enum EmployeeType {Hourly, Salary, Sales};
	
	public static void main(String[] args) {
		
//		Computable c = new ComputableImpl();
//		System.out.println(c.doubleValue(2));
//		System.out.println(c.negate(2));
//		System.out.println(c.compute());
//		
//		Stream<Integer> stream = Stream.of(12, 52, 32, 74, 25);
//		stream
//			.map(Math::sin)
//			.forEach(System.out::println);
		
		Consumer consumer = t->System.out.println(t);
		
		List<String> list = Arrays.asList("Huey", "Duey", "Luey");
		list.forEach(s -> System.out.println(
				processString( l -> l.toLowerCase(), s)));
		

		
		numbers.clear();
		numberString
		    .stream()
		    .forEach(s -> numbers.add(Integer.parseInt(s)));
		numbers.forEach(System.out::println);
			
//		numbers.clear();
//			System.out.println(singleFunction.apply(numberString));
//			System.out.println(doubleFunction.apply(numberString));
		
		System.out.println(doubleNumbers);
		Arrays.asList(numberString).stream()
			.map(doubleFunction)
			.forEach(s -> System.out.println(s));

		Arrays.asList(numberString).stream()
			.map(negateFunction)
			.forEach(s -> System.out.println(s));
		
		Arrays.asList(1,2,3,4,5).stream()
			.map(a -> a*2)
			.forEach(s -> System.out.println(s));
		
		int hoursWorked[] = {8, 12, 8, 6, 6, 5, 6, 0};
		
		int totalHoursWorked = Arrays.stream(hoursWorked).sum();
		
		BiFunction<Integer,Float,Float> calculateFunction;
		
		if(totalHoursWorked<=40) {
			calculateFunction = (hours, payRate) -> 40 * payRate;
		} else {
			calculateFunction = (hours, payRate) ->
				hours*payRate + (hours-40)*1.5f*payRate;
		}
		
		System.out.println(
				calculatePayFunction(EmployeeType.Hourly)
				.apply(totalHoursWorked, 15.75f));
	}
	
	static Function<List<String>, List<Integer>> singleFunction = s -> {
		s.stream()
		.forEach(t -> numbers.add(Integer.parseInt(t)));
		return numbers;
		};
	static Function<List<String>, List<Integer>> doubleFunction = s -> {
		s.stream()
		.forEach(t -> doubleNumbers.add(
		Integer.parseInt(t) * 2));
		return doubleNumbers;
		};
	
	static Function<List<String>, List<Integer>> negateFunction = s -> {
		s.stream()
			.forEach(t -> negateNumbers.add(
					Integer.parseInt(t)*(-1)));
		return negateNumbers;
		};
	
	public static String processString(Function<String, String> operation,String target) {
		return operation.apply(target);
	}
	
	static public BiFunction<Integer, Float, Float> calculatePayFunction (
			EmployeeType type) {
			switch (type) {
				case Hourly:
					return (hours, payRate) -> hours * payRate;
				case Salary:
					return (hours, payRate) -> 40 * payRate;
				case Sales:
					return (hours, payRate) -> 500f + 0.15f * payRate;
				default:
					return null;
			}
		}

}
