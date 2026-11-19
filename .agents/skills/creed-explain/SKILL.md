---
name: creed-explain
description: 'Introspection skill that explains what the agent did in the last iteration of the current session and why. Use when asked "what happened?", "why did you do that?" or "explain your last steps".'
---

<!-- ↓↓↓ agentcreed ↓↓↓ -->

# creed-explain

Use this process to explain your own work to the user. The goal is to let the user understand what happened and why, not to defend the result.

For the purpose of this skill, consider:

- `iteration` is everything between a user prompt and your final response to it, including the work of your subagents.
- `evidence` is anything visible in the current session: user prompts, your responses, files read, commands run with their outputs, edits made and rules quoted from instruction files.

Explain the last `iteration` before the prompt that invoked this skill. If the user points at another `iteration` or at a single decision, explain only that.

## Rules

- This skill only reports. Skip the `git status` and `git pull --ff-only` check required by `creed-dev`. Do not edit files, do not run commands that change anything and do not redo or fix the work. The only allowed writes are logging into `.creed/SUGGESTIONS.md` and `.creed/BACKLOG.md`.
- Build the explanation from `evidence` only. Re-read the session, do not rely on your impression of it. You may re-read files to quote a rule or to check the current state.
- You cannot replay your past reasoning. Mark every stated reason as `recorded` (you wrote it down in the session at that time) or `reconstructed` (you infer it now from `evidence`). Never present a `reconstructed` reason as certain.
- If a part of the `iteration` is not visible to you (new session, summarized or truncated history, subagent that returned only a report), say so and do not fill the gap by guessing.
- Do not justify yourself. If a step was wrong, unnecessary, based on an assumption or broke a rule, state it plainly.
- Do not store the explanation in any file unless the user asks for it.

## Report

Respond with the sections below. Leave out a section that has nothing to say. Keep it brief; the user can ask for more detail on any point.

1. **Task** - how you understood the request, in one or two sentences.
2. **Steps** - what you did, in chronological order. For each step give the action, the reason and its mark (`recorded` / `reconstructed`). Group routine steps (e.g. reading several files) into one.
3. **Decisions** - points where more than one approach was possible: the options, the one taken and why. Say whether the user was asked.
4. **Rules** - instructions that shaped the result, each with its source file. List separately the rules that applied but were skipped or broken.
5. **Assumptions and gaps** - what you took for granted without `evidence` and what is not visible to you.
6. **Outcome** - what was changed, what was verified (build, tests) and what was left unverified or undone.

## Follow-up

- If the explanation reveals that an instruction was unclear, missing or contradictory and that it affected the result, log it into `.creed/SUGGESTIONS.md`.
- If it reveals a mistake in the work, report it and let the user decide the next step.

<!-- ↑↑↑ agentcreed ↑↑↑ -->
