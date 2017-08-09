package test.examples;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import main.examples.AreSimilar;

public class AreSimilarTest {

	@Test
	public void test() {
		int[] a = {832, 998, 148, 570, 533, 561, 894, 147, 455, 279};
		int[] b = {832, 998, 148, 570, 533, 561, 455, 147, 894, 279};
		
		boolean result = AreSimilar.areSimilar(a, b);
		
		assertThat(true, is(equalTo(result)));
	}

}
