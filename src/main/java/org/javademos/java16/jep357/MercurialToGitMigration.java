package org.javademos.java16.jep357;

import org.javademos.commons.IDemo;

/**
 * ## JEP 357: Migrate from Mercurial to Git
 *
 * ### History
 * * JDK 16: Delivered
 *
 * ### Links
 * * [JEP 357](https://openjdk.org/jeps/357)
 * * [JEP 369: Migrate to GitHub](https://openjdk.org/jeps/369)
 *
 * This JEP was purely an infrastructure change for the OpenJDK community.
 * There are no Java language features or APIs to demonstrate.
 */
public class MercurialToGitMigration implements IDemo {

    @Override
    public void demo() {
        info(357);

        System.out.println("This JEP was an infrastructure project to migrate the OpenJDK Community's source code repositories.");
        System.out.println("The migration was from Mercurial (hg) to Git.");
        System.out.println();
        System.out.println("Key Goals:");
        System.out.println("1. Migrate all single-repository OpenJDK Projects.");
        System.out.println("2. Preserve all version control history, including tags.");
        System.out.println("3. Port internal tools (like 'jcheck') to work with Git.");
        System.out.println();
        System.out.println("This change did not introduce any new Java language features or APIs, " +
                "but was a critical step for the community, leading to JEP 369 (Migrate to GitHub).");
    }
}