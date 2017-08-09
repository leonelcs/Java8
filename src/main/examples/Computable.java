package main.examples;

public interface Computable {
	
	public int compute();
	
	public default int doubleValue(int n) {
		return 2*n;
	}
	
	public default int negate(int n) {
		return -1*n;
	}

}
