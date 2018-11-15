package murry.googlestreams;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.SplittableRandom;

public class StreamBasics {

	public static void main(String[] args) {
		
		warmUp();
		
		DecimalFormat dc = new DecimalFormat(".###");
		
		var start = System.nanoTime();
		var numbers = new SplittableRandom().ints(100_000_000, 1, 500).parallel().toArray();
		var totalTime = (System.nanoTime() - start) / 1E6;
		System.out.println("It took " + dc.format(totalTime) + " ms to generate 1E9 ints from 1 - 500.");

		start = System.nanoTime();
		var sum = Arrays.stream(numbers).parallel().sum();
		totalTime = (System.nanoTime() - start) / 1E6;
		System.out.println("The sum:" + sum + " was completed in " + dc.format(totalTime) + " ms");
	}

	public static void warmUp() {
		DecimalFormat dc = new DecimalFormat(".###");
		for (int i = 0; i < 10; ++i) {
			var start = System.nanoTime();
			var numbers = new SplittableRandom().ints(1_000_000_000, 1, 500).parallel().toArray();
			var totalTime = (System.nanoTime() - start) / 1E6;
			System.out.println("Warm-up: " + i + "took " + dc.format(totalTime) + " ms to generate 1E9 ints from 1 - 500.");
		
			start = System.nanoTime();
			var sum = Arrays.stream(numbers).parallel().sum();
			totalTime = (System.nanoTime() - start) / 1E6;
			System.out.println("Warm-up: " + i + " sum:" + sum + " was completed in " + dc.format(totalTime) + " ms");

		}
	}
}
