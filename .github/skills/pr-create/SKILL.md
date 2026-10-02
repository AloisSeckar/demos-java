---
name: pr-create
description: 'Branch, commit, and open a pull request for a finished JEP demo in demos-java, closing its GitHub issue. Use as the final step of demo-create and demo-update.'
argument-hint: '<jep-number>'
---

# Open a PR for a JEP Demo

Input: the JEP number the demo was implemented for. For [demo-update](../demo-update/SKILL.md), use the new JEP.
The demo must already build and run as described in [demo-create](../demo-create/SKILL.md)
or [demo-update](../demo-update/SKILL.md).

Values used below:
- `<jdk>`: the JDK release the JEP targets, i.e. the `java<jdk>` package holding the implementation.
- Branch: `jep-<jep-number>`.
- Title and commit message: `feat(jdk<jdk>): add demo for JEP <jep-number>`.

## Prerequisite: GitHub CLI

The GitHub CLI (`gh`) is the preferred tool for steps 1 and 6. Check it with `gh auth status`. If `gh` is missing
or not logged in, recommend that the user install it from https://cli.github.com/ and run `gh auth login`.
Do not install or log in to it on the user's behalf. Continue with the fallbacks below, and repeat the
recommendation in the final report.

## Workflow

1. Find the open issue for the JEP in `AloisSeckar/demos-java`. 
   Use `gh issue list --state open --search "JEP <jep-number> in:title"` if `gh` is available. 
   Otherwise use a GitHub issue tool or fetch
   `https://github.com/AloisSeckar/demos-java/issues?q=is%3Aissue+is%3Aopen+%22JEP+<jep-number>%22+in%3Atitle`.
   Accept only an issue whose title starts with `JEP <jep-number> `.
   If there are no matches or several, ask the user which issue to use, or whether to proceed without one.
2. Run `git status` and confirm the changes contain only demo-related files: the demo class(es),
   `JDK<jdk>Info.json` files, and `Java<jdk>DemoLoader.java` loaders. Never stage `target/`, `tmp/`,
   or unrelated edits. Ask the user about anything unexpected.
3. Create and switch to `jep-<jep-number>` from the current branch (normally an up-to-date `master`),
   so the uncommitted changes come along. If the branch already exists, ask the user before reusing it.
4. Stage the demo-related files explicitly by path and commit them with the commit message above.
5. Push with `git push -u origin jep-<jep-number>`. If `origin` is not writable (for example, a contributor
   working on the upstream repo), push to the user's fork and open the PR from `<fork-owner>:jep-<jep-number>`.
6. Open a PR against `master` of `AloisSeckar/demos-java` with the title above. Its body is
   `Closes #<issue-number>`, or nothing if the user chose to proceed without an issue. Use
   `gh pr create --base master --head jep-<jep-number> --title "<title>" --body "<body>"` if `gh` is available,
   otherwise any available GitHub PR tool. If neither works, give the user the compare URL
   `https://github.com/AloisSeckar/demos-java/compare/master...jep-<jep-number>?expand=1` along with the title and body.
7. Report the branch, commit, and PR URL.
