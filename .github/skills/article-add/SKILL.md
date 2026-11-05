---
name: article-add
description: 'Add one or more articles, releases, or announcements as new entries to JavaNews.md in demos-java. Use when the user provides URLs to add to the Java news list.'
argument-hint: '<url> [<url> ...]'
---

# Add Articles to JavaNews.md

Input: one or more URLs (`/article-add <url1> <url2> ...`). Each URL becomes one table row in [JavaNews.md](../../../JavaNews.md).
Only edit that file. Do not create other files or notes.

## Entry format

```
| **`YYYY-MM-DD`** | [Article Title](URL) - short description with **bold** key terms |
```

- Title: the article's own title. Shorten only if it is very long or clickbaity.
- Description: one sentence, after ` - `, in a neutral informative tone. No emojis, no marketing wording,
  no opinions of your own. Say what the article announces or explains.
- Bold (`**...**`) the key product, project, release, or JDK version, e.g. `**JDK 28**`, `**Quarkus**`, `**WildFly 42**`.
  Use backticks for code identifiers, e.g. `` `HttpClient` ``.
- Use the original article URL exactly as the user gave it (do not add tracking parameters or rewrite it).

## Workflow

1. Fetch all URLs in parallel. Ask for the title, publication date, author, and a content summary.
2. Determine the date of each article (see below). Never guess it.
3. Read the current month sections at the top of `JavaNews.md` **after** fetching. The user edits this file
   by hand (shortening descriptions, fixing typos), so always work from the current content, not from memory.
4. Insert the rows (see placement below) with a single edit per file where possible.
5. Report briefly: one line per article with its date and the section it went to, plus any caveat.

## Determining the date

Use the real publication date, in this order of preference:

- The byline or date shown on the page (InfoQ, JavaPro, Foojay, inside.java, WildFly, Quarkus, TornadoVM, InfoWorld, ...).
  The date in the URL may be wrong or only approximate (for example, a Foojay URL can differ from its byline date).
- GitHub release pages show relative dates ("2 weeks ago"). Fetch
  `https://api.github.com/repos/<owner>/<repo>/releases/tags/<tag>` and use `published_at`.
- Mailing-list announcements (mail-archive.com): use the date in the message header.
- If the date cannot be determined, ask the user. Do not invent one. If the user supplies it later, add the entry then.

## Placement

- Entries are grouped in `## YYYY - Month` sections, newest section first, each with the same table header:

  ```
  ## 2026 - October

  | Date&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; | Article |
  | --- | :-- |
  ```

- Put each entry into the section of its own month, which is not necessarily the current one
  (for example, a late August article added in September goes to August).
- If the month section does not exist yet, create it directly above the newest existing month section, copying the header above.
- Within a section, order rows by date, newest first. For equal dates, add the new row next to the existing rows of that date.
- If the date belongs to a year other than the one in the file's sections, ask the user before touching archive files
  (`JavaNews2025.md`, etc.).
- The file may already contain a few out-of-order rows. Do not reorder or reformat existing rows.

## Safe editing

- Match the existing text exactly in the old-string of the edit, and copy every unchanged row verbatim into the new string.
  After the edit, check that no existing row changed (for example, by grepping a neighbouring row). Past mistake:
  rewording `**Java 28**` to `**JDK 28**` in an unrelated row. Fix such slips immediately.
- Do not add a row for a URL that is already in the file. Tell the user instead.

## When a page cannot be read

- Cookie walls and long boilerplate are normal. Look for the article body, byline, and date in the fetched text.
- If a fetch redirects to an unrelated (ad or tracking) domain, do not follow it. Retry once, then try one alternative
  source (the project's own site or API). If the content is still unavailable, say so.
- Without readable content, write the description only from what is verifiable (for example, the title) and tell the user.
  If the date is also unknown, ask for it before adding the row.
