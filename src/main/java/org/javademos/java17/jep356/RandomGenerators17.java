package org.javademos.java17.jep356;

import org.javademos.commons.IDemo;
import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;
import java.util.random.RandomGenerator.JumpableGenerator;

/**
 * # JEP 356: Enhanced Pseudo-Random Number Generators
 * Introduced in Java 17
 * 
 * - Adds new interfaces: RandomGenerator, RandomGeneratorFactory
 * - Supports LXM family generators (L32X64Mix, L64X128Mix)
 * - Enables stream and jumpable generators for parallel tasks
 */
public class RandomGenerators17 implements IDemo {

    @Override
    public void demo() {
        info(356);
        System.out.println("=== Enhanced Pseudo-Random Number Generators Demo ===");

        RandomGenerator generator = RandomGenerator.getDefault();
        System.out.println("Default Random Int: " + generator.nextInt());
        System.out.println("Default Random Double: " + generator.nextDouble());

        JumpableGenerator jumpable = (JumpableGenerator)
                RandomGeneratorFactory.of("L64X128MixRandom").create();
        System.out.println("Jumpable Random Int: " + jumpable.nextInt());
    }
}
