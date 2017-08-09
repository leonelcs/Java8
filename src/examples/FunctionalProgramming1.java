package examples;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class FunctionalProgramming1 {

	public static void main(String[] args) {

		Function<Integer, Integer> absThenNegate = ((Function<Integer, Integer>) Math::negateExact).compose(Math::abs);

		System.out.println(absThenNegate.apply(-25));
		System.out.println(absThenNegate.apply(25));

		Function<Integer, Integer> negateThenAbs = ((Function<Integer, Integer>) Math::negateExact).andThen(Math::abs);

		System.out.println(negateThenAbs.apply(-25));
		System.out.println(negateThenAbs.apply(25));

		fluentInterfaces();
		System.out.println("factorial result: ");
		System.out.println(factorial(5));

		System.out.println("Streams");
		Stream<Integer> stream = Stream.of(12, 52, 32, 74, 25);
		stream.map(x -> x * 2).forEach(x -> System.out.println(x));

		System.out.println("Streams - parallel");
		Stream<Integer> stream2 = Stream.of(12, 52, 32, 74, 25);
		stream2.parallel().map(x -> x * 2).forEach(x -> System.out.println(x));

		ClosureExample ce = new ClosureExample();
		final Function<String, String> function = ce.getStringOperation();
		System.out.println(function.apply("Closure"));

		Function<String, String> function2 = String::toLowerCase;
		Consumer<String> consumer = s -> System.out.println(function2.apply(s));

		Predicate<Integer> tooLarge = s -> s > 100;
		System.out.println(tooLarge.test(45));
		List<Integer> list = Arrays.asList(230, 45, 13, 563, 4);
		Stream<Integer> stream3 = list.stream();
		stream3.forEach(s -> System.out.println(tooLarge.test(s)));

	}

	public static int factorial(int n) {
		return n == 1 ? 1 : n * factorial(n - 1);
	}

	public static void fluentInterfaces() {

		// LocalDate today = LocalDate.now();
		// LocalDate futureDate = today.plusYears(2);
		// futureDate = futureDate.minusMonths(1);
		// futureDate = futureDate.plusDays(3);
		// System.out.println(today);
		// System.out.println(futureDate);

		LocalDate futureDate = LocalDate.now().plusYears(2).minusMonths(1).plusDays(3);
		System.out.println(futureDate);

		Random random = new Random();
		random.ints().limit(5).sorted().forEach(x -> System.out.println(x));

	}

}
