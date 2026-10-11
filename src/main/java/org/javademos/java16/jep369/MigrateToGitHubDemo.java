package org.javademos.java16.jep369;

import org.javademos.commons.IDemo;

/// Demo for JDK 16 feature JEP 369 - Migrate to GitHub.
///
/// JEP history:
/// - JDK 16: [JEP 369 - Migrate to GitHub](https://openjdk.org/jeps/369)
///
/// Further reading:
/// - [JEP 357 - Migrate from Mercurial to Git](https://openjdk.org/jeps/357)
/// - [Project Skara](https://openjdk.org/projects/skara/)
/// - [OpenJDK repositories on GitHub](https://github.com/openjdk/)
/// - [OpenJDK Developers' Guide](https://openjdk.org/guide/)
///
/// @author alois.seckar@gmail.com
public class MigrateToGitHubDemo implements IDemo {
    @Override
    public void demo() {
        info(369);

        // JEP 369 is an infrastructure change of the OpenJDK Community. It does not
        // affect the Java language, the APIs or the JVM. Together with JEP 357
        // (Mercurial -> Git), it moved all single-repository OpenJDK Projects
        // (JDK feature releases and JDK 11+ update releases) to GitHub:
        //   https://github.com/openjdk/

        // Why an external hosting provider and why GitHub?
        // - performance: faster clones and pulls, better availability (uptime)
        // - API: bots can take part in the review process instead of parsing e-mails
        // - community: most Java developers already have a GitHub account
        // - tooling: editors, IDEs and desktop clients support GitHub pull requests

        // Contribution workflow (tooling developed in Project Skara):
        // - every change starts as a pull request (PR)
        // - a `jcheck` bot validates commits; passing PRs get the "rfr" label
        //   (request for review) and labels per affected area (e.g. "hotspot-dev")
        // - RFR e-mails with generated webrevs are sent to the mailing lists
        // - reviewers may comment via e-mail, web browser, IDE or CLI - all
        //   comments are mirrored between GitHub and the mailing lists
        // - the author issues `/integrate`; a bot squashes and rebases the commits,
        //   writes the final commit message (with `Reviewed-by:` trailers) and pushes
        // - non-Committers need a Committer to confirm with `/sponsor`

        // What stayed the same?
        // - bug tracking in JBS (JDK Bug System), the wiki and the mailing lists
        // - roles and permissions from the OpenJDK Census and Bylaws (bots map
        //   GitHub user ids to OpenJDK usernames)

        // Avoiding vendor lock-in:
        // - all PR discussions are archived (mbox + JSON) and mirrored to mailing lists
        // - Skara tooling must also work with GitLab, so the provider can be changed
        // - `git.openjdk.org` URLs redirect to the current hosting provider
    }
}
