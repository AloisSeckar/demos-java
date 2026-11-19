# AgentCreed Backlog

<!-- ↓↓↓ agentcreed ↓↓↓ -->

This file is used to collect tasks for the project codebase discovered during development (e.g. refactoring, duplicated or unused code, bugs, missing tests, missing or outdated documentation, changes out of the current task scope). Findings about agent instructions belong in `SUGGESTIONS.md`.

This file holds pending tasks only, as a numbered list. Resolved items are deleted, never marked as done. When resolved items are deleted, the remaining items are renumbered.

<!-- ↑↑↑ agentcreed ↑↑↑ -->

1. `JEPStatus.md` in the project root is discontinued and unreachable from `README.md` or `ARCHITECTURE.md`. Either link it from `README.md` or remove it.
2. Bug in `src/main/java/org/javademos/commons/ArgsFilterUtil.java` (`printFilteredInfo`, lines 124–129): when `--code-only` is active, `filtered` already contains only entries with `code == true`, but the summary filters by `!jepData.code()`, always printing `0`.
