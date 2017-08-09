package main.examples;
import java.util.function.BiFunction;
import java.util.function.Function;

public class IndependentFunctions {

	static BiFunction<Integer, Double, Double> computeHourly = (hours, rate) -> hours * rate;
	static Function<Double, Double> computeSalary = rate -> rate * 40.0;
	static BiFunction<Double, Double, Double> computeSales = (rate, commission) -> rate * 40.0 + commission;

	public static void main(String[] args) {

		double total = 0.0;
		boolean hourly = false;
		if (hourly) {
			total = computeHourly.apply(35, 12.75);
		} else {
			total = computeSalary.apply(25.35) + computeSales.apply(8.75, 2500.0);
		}
		System.out.println(total);

	}

}
