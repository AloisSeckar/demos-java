package org.javademos.java17.jep356;

import org.javademos.commons.IDemo;
import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;
import java.util.random.RandomGenerator.JumpableGenerator;

/// Demo for JDK 17 feature JEP 356 - Enhanced Pseudo-Random Number Generators.
///
/// Introduced new interfaces to improve random number generation:
/// - `RandomGenerator` and `RandomGeneratorFactory`
/// - Support for LXM family generators (`L32X64Mix`, `L64X128Mix`)
/// - Added streamable and jumpable generators for parallel computation.
///
/// JEP link:
/// - [JEP 356 - Enhanced Pseudo-Random Number Generators](https://openjdk.org/jeps/356)
///
/// Further reading:
/// - [Baeldung: Enhanced Pseudo-Random Number Generators in Java 17](https://www.baeldung.com/java-17-random-number-generators)
///
/// @author alois.seckar@gmail.com
public class RandomGeneratorsDemo implements IDemo {

    @Override
    public void demo() {
        info(356);

        RandomGenerator generator = RandomGenerator.getDefault();
        System.out.println("Default Random Int: " + generator.nextInt());
        System.out.println("Default Random Double: " + generator.nextDouble());

        JumpableGenerator jumpable =
                (JumpableGenerator) RandomGeneratorFactory.of("Xoshiro256PlusPlus").create();
        System.out.println("Jumpable Random Int: " + jumpable.nextInt());
    }
}
