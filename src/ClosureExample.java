import java.util.function.Function;

public class ClosureExample {

	int instanceLength;

	public Function<String, String> getStringOperation() {
		final String seperator = ":";

		return target -> {
			int localLength = target.length();
			instanceLength = target.length();
			return target.toLowerCase() + seperator 
					+ instanceLength + seperator + localLength;
		};
	}

}
