---
name: creed-chat
description: 'Interviewing skill that must be run when clarifying the task given by the user.'
---

<!-- ↓↓↓ agentcreed ↓↓↓ -->

# creed-chat

Before starting an interview with the user, analyze the input and abstract the steps that should lead to the result.

For each step, consider what the required information is.

For each piece of required information, consider if it can be obtained from the instructions, docs, codebase or the previous answers. If yes, use the obtained knowledge.

If not, seek clarification from the user.

Repeat this process until all required information for all steps is obtained or clarified.

Give a summary to the user before proceeding further.

<!-- ↑↑↑ agentcreed ↑↑↑ -->
