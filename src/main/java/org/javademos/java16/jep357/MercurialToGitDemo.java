package org.javademos.java16.jep357;

import org.javademos.commons.IDemo;

/// Demo for JDK 16 feature JEP 357 - Migrate from Mercurial to Git.
///
/// JEP history:
/// - JDK 16: [JEP 357 - Migrate from Mercurial to Git](https://openjdk.org/jeps/357)
///
/// Further reading:
/// - [JEP 369 - Migrate to GitHub](https://openjdk.org/jeps/369)
/// - [OpenJDK repositories on GitHub](https://github.com/openjdk/)
/// - [OpenJDK Developers' Guide](https://openjdk.org/guide/)
///
/// @author alois.seckar@gmail.com
public class MercurialToGitDemo implements IDemo {
    @Override
    public void demo() {
        info(357);

        // JEP 357 is an infrastructure change of the OpenJDK Community. It does not
        // affect the Java language, the APIs or the JVM. It only changed the version
        // control system used to develop the JDK itself - from Mercurial (hg) to Git.
        // Hosting of the new Git repositories (on GitHub) was covered by JEP 369.

        // Why Git?
        // - smaller metadata: `.git` folder of `jdk/jdk` is ~300 MB compared to
        //   ~1.2 GB of `.hg` folder, which means less disk space and faster clones
        //   (shallow clones can reduce the size even further)
        // - tooling: virtually every editor and IDE has built-in Git integration
        // - hosting: many options for hosting Git repositories are available

        // What was done?
        // - all single-repository OpenJDK Projects were converted to Git with full
        //   history including tags (multi-repository Projects like JDK 8 Updates
        //   were out of scope)
        // - OpenJDK tools jcheck, webrev and defpath were ported to Git
        // - new `git translate` tool maps Mercurial changeset hashes to Git commit
        //   hashes (and vice versa) using `.hgcommits` file stored in the repository
        // - bug tracking stayed in JBS (JDK Bug System)

        // Commit messages were reformatted to follow Git best practices - a title
        // line, optional free-form body and trailers recognized by Git ecosystem.
        // Sponsored commits use Git's separate author and committer fields.
        // Example of a commit message in the new format:
        //
        //   76543210: Crash when starting the JVM
        //
        //   Fixed a tricky race condition when the JVM is starting up by using a Mutex.
        //
        //   Co-authored-by: Robin Westberg <rwestberg@openjdk.org>
        //   Reviewed-by: darcy

        // For Java developers, the main benefit is easier access to the JDK
        // sources - they can be cloned with a simple Git command, e.g.:
        //   git clone https://github.com/openjdk/jdk.git
    }
}
