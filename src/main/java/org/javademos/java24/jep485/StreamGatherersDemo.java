package org.javademos.java24.jep485;

import java.util.List;
import java.util.Optional;
import java.util.stream.Gatherers;

import org.javademos.commons.IDemo;

/// Demo for JDK 24 feature <strong>JEP 485 - Stream Gatherers</strong>.
///
/// JEP history:
/// - JDK 24: [JEP 485 - Stream Gatherers](https://openjdk.org/jeps/485)
/// - JDK 23: [JEP 473 - Stream Gatherers (Second Preview)](https://openjdk.org/jeps/473)
/// - JDK 22: [JEP 461 - Stream Gatherers (Preview)](https://openjdk.org/jeps/461)
///
/// Further reading:
/// - [Stream Gatherers in Java](https://www.baeldung.com/java-stream-gatherers)
/// - [Stream Gatherers: The Missing Piece in Java Stream Processing](https://todd.ginsberg.com/post/java/gatherers/)
/// - [Stream Gatherers in JDK 24: Building Custom Intermediate Operations for the Stream API](https://www.danvega.dev/blog/stream-gatherers)
///
/// @author rishabhrawat.171105@gmail.com
public class StreamGatherersDemo implements IDemo {

	@Override
	public void demo() {
		info(485);

		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		// fold constructs an aggregate incrementally:
		// initializer -> creates an empty string ""
		// integrator -> appends each number to the current string
		// finisher -> emits the final concatenated string after the stream ends
		System.out.println("===== fold: append all numbers =====");
		Optional<String> str = numbers.stream().gather(Gatherers.fold(() -> "", (string, number) -> string + number)).findFirst();
		str.ifPresent(s -> System.out.println("Appended String: " + s));

		// mapConcurrent applies a function to each element concurrently
		// maxConcurrency -> 4 threads
		// mapper -> n -> n*n
		System.out.println("\n=== mapConcurrent: square each number concurrently ===");
		numbers.stream().gather(Gatherers.mapConcurrent(4, n -> n * n))
				.forEach(n -> System.out.println("Square: " + n));


		// scan maintains state per element:
		// initializer -> empty string ""
		// integrator -> appends the current number to the running string
		// finisher -> emits the current concatenated string after each element
		System.out.println("\n=== scan: running total ===");
		numbers.stream().gather(Gatherers.scan(() -> "", (string, number) -> string + number))
				.forEach(n -> System.out.println("Running total: " + n));

		// windowFixed groups elements into fixed-size batches
		// initializer -> empty list
		// integrator -> adds element to current window
		// finisher -> emits full windows
		System.out.println("\n=== windowFixed: windows of size 3 ===");
		numbers.stream().gather(Gatherers.windowFixed(3)).forEach(window -> System.out.println("Window: " + window));
		
		// windowSliding creates overlapping windows
		// first window -> first N elements
		// subsequent windows -> drop first element of previous, add next input
		System.out.println("\n=== windowSliding: sliding windows of size 3 ===");
		numbers.stream().gather(Gatherers.windowSliding(3))
				.forEach(window -> System.out.println("Sliding Window: " + window));
		
	}

}