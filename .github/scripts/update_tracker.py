#!/usr/bin/env python3
import os
import json
import re
import urllib.parse
from datetime import datetime
from pathlib import Path

REPO_ROOT = Path(__file__).resolve().parent.parent.parent
SCRIPTS_DIR = Path(__file__).resolve().parent
DATA_FILE = SCRIPTS_DIR / "apna_college_375.json"
README_FILE = REPO_ROOT / "README.md"

CODE_EXTENSIONS = {
    ".java": "Java",
    ".cpp": "C++",
    ".c": "C",
    ".py": "Python",
    ".js": "JavaScript",
    ".ts": "TypeScript",
    ".go": "Go",
    ".rs": "Rust",
    ".cs": "C#",
    ".kt": "Kotlin",
    ".swift": "Swift",
    ".rb": "Ruby",
    ".txt": "Code"
}

# Known problem aliases mapping for Apna College sheet questions
EXTRA_ALIASES = {
    "Given Sum Pair": ["two-sum", "1", "pair-with-given-sum"],
    "Reverse the Array": ["reverse-array", "reverse-an-array", "reverse-the-array"],
    "Delete without Head node": ["delete-node-in-a-linked-list", "237", "delete-without-head-pointer", "delete-node-without-linked-list-head"],
    "Sum of two linked lists": ["add-two-numbers", "2", "sum-of-two-linked-lists"],
    "Permute Two Arrays such that Sum of Every Pair is Greater or Equal to K": ["permute-arrays-for-sum-threshold", "permutations-in-array"],
    "ceiling in a sorted array": ["ceil-in-a-sorted-array", "ceil-in-sorted-array"],
    "Linked List Cycle": ["linked-list-cycle", "141"],
    "Product of Array Except Self": ["product-of-array-except-self", "238"],
    "Best time to Buy and Sell Stock": ["best-time-to-buy-and-sell-stock", "121"],
    "Find Minimum in Rotated Sorted Array": ["find-minimum-in-rotated-sorted-array", "153"],
    "3Sum": ["3sum", "15"],
    "Valid Anagram": ["valid-anagram", "242"],
    "Longest Substring without Repeating Characters": ["longest-substring-without-repeating-characters", "3"],
    "Spiral Matrix": ["spiral-matrix", "54"],
    "Reverse Linked List": ["reverse-linked-list", "206"],
    "Merge Two Sorted Lists": ["merge-two-sorted-lists", "21"],
    "Remove nth node from end of list": ["remove-nth-node-from-end-of-list", "19"],
    "Reorder List": ["reorder-list", "143"]
}

def normalize_text(text):
    if not text:
        return ""
    words = re.findall(r"[a-z0-9]+", text.lower())
    stopwords = {"the", "a", "an", "in", "of", "to", "for", "with", "and", "or", "on", "at", "from", "by", "given", "using", "problem"}
    filtered = [w for w in words if w not in stopwords]
    return "".join(filtered) if filtered else "".join(words)

def extract_slug(url):
    if not url:
        return ""
    clean = url.rstrip("/").split("?")[0]
    parts = clean.split("/")
    slug = parts[-2] if parts[-1] == "1" and len(parts) >= 2 else parts[-1]
    return re.sub(r"\d+$", "", slug).strip("-").lower()

def get_progress_bar(percent, width=20):
    filled = int(round(width * percent / 100))
    filled = max(0, min(width, filled))
    return "█" * filled + "░" * (width - filled)

def encode_path(p):
    return urllib.parse.quote(p, safe="/#")

def find_case_insensitive_dir(parent, candidates):
    for entry in parent.iterdir():
        if entry.is_dir() and entry.name.lower() in [c.lower() for c in candidates]:
            return entry
    return None

def scan_solved_problems():
    solved = []

    # 1. Scan LeetCode directory (case-insensitive find)
    lc_dir = find_case_insensitive_dir(REPO_ROOT, ["Leetcode", "leetcode"])
    if lc_dir and lc_dir.exists():
        for entry in sorted(lc_dir.iterdir()):
            if not entry.is_dir() or entry.name.startswith("."):
                continue

            folder_name = entry.name
            m = re.match(r"^(\d+)-(.*)$", folder_name)
            num = m.group(1) if m else None
            slug = m.group(2).lower() if m else folder_name.lower()

            title = ""
            diff = "Medium"
            readme_path = entry / "README.md"
            if readme_path.exists():
                try:
                    content = readme_path.read_text(encoding="utf-8", errors="ignore")
                    tm = re.search(r'<h2><a\s+href="[^"]*">([^<]+)</a></h2>', content)
                    if tm:
                        title = tm.group(1).strip()
                    dm = re.search(r'Difficulty-(Easy|Medium|Hard)', content, re.IGNORECASE)
                    if dm:
                        diff = dm.group(1).capitalize()
                except Exception:
                    pass

            # Find solution file
            sol_file = None
            for cf in sorted(entry.iterdir()):
                if cf.suffix in CODE_EXTENSIONS and cf.name != "README.md":
                    sol_file = cf.relative_to(REPO_ROOT).as_posix()
                    break

            rel_path = entry.relative_to(REPO_ROOT).as_posix()
            solved.append({
                "source": "LeetCode",
                "folder": folder_name,
                "number": num,
                "path": rel_path,
                "sol_file": sol_file or rel_path,
                "slug": slug,
                "title": title or slug.replace("-", " ").title(),
                "url": f"https://leetcode.com/problems/{slug}/",
                "difficulty": diff
            })

    # 2. Scan Geeks For Geeks directory (case-insensitive find)
    gfg_dir = find_case_insensitive_dir(REPO_ROOT, ["Geeks For Geeks", "GFG", "geeksforgeeks"])
    if gfg_dir and gfg_dir.exists():
        for entry in sorted(gfg_dir.iterdir()):
            if entry.name.startswith(".") or entry.name == ".gitkeep":
                continue

            if entry.is_dir():
                title = entry.name
                url = ""
                diff = "Medium"
                meta_path = entry / "metadata.json"
                if meta_path.exists():
                    try:
                        mdata = json.loads(meta_path.read_text(encoding="utf-8", errors="ignore"))
                        title = mdata.get("problemTitle", title)
                        url = mdata.get("problemUrl", "")
                        d = mdata.get("difficulty", "")
                        if d and d.lower() != "unknown":
                            diff = d.capitalize()
                    except Exception:
                        pass

                slug = extract_slug(url) if url else re.sub(r"[^a-zA-Z0-9]+", "-", entry.name.lower()).strip("-")
                
                sol_file = None
                for cf in sorted(entry.iterdir()):
                    if cf.suffix in CODE_EXTENSIONS and cf.name != "README.md":
                        sol_file = cf.relative_to(REPO_ROOT).as_posix()
                        break

                rel_path = entry.relative_to(REPO_ROOT).as_posix()
                solved.append({
                    "source": "GFG",
                    "folder": entry.name,
                    "number": None,
                    "path": rel_path,
                    "sol_file": sol_file or rel_path,
                    "slug": slug,
                    "title": title,
                    "url": url or f"https://www.geeksforgeeks.org/problems/{slug}/1",
                    "difficulty": diff
                })
            elif entry.is_file() and entry.suffix in CODE_EXTENSIONS:
                name_clean = re.sub(r'^\d+[-_]', '', entry.stem)
                title = name_clean.replace('_', ' ').replace('-', ' ').title()
                slug = re.sub(r"[^a-zA-Z0-9]+", "-", name_clean.lower()).strip("-")
                rel_path = entry.relative_to(REPO_ROOT).as_posix()
                solved.append({
                    "source": "GFG",
                    "folder": entry.name,
                    "number": None,
                    "path": rel_path,
                    "sol_file": rel_path,
                    "slug": slug,
                    "title": title,
                    "url": f"https://www.geeksforgeeks.org/problems/{slug}/1",
                    "difficulty": "Medium"
                })

    return solved

def main():
    if not DATA_FILE.exists():
        print(f"Error: {DATA_FILE} not found.")
        return

    with open(DATA_FILE, "r", encoding="utf-8") as f:
        questions = json.load(f)

    solved_items = scan_solved_problems()

    matched_questions = {}
    used_solved_paths = set()

    for q in questions:
        q_id = q["id"]
        q_slug = extract_slug(q["url"])
        q_norm = normalize_text(q["name"])
        q_slug_norm = normalize_text(q_slug)

        target_slugs = set(q.get("aliases", []))
        if q_slug:
            target_slugs.add(q_slug)
            target_slugs.add(q_slug_norm)

        # Merge extra aliases
        if q["name"] in EXTRA_ALIASES:
            for al in EXTRA_ALIASES[q["name"]]:
                target_slugs.add(al)
                target_slugs.add(normalize_text(al))

        matches = []
        for s in solved_items:
            s_norm_title = normalize_text(s["title"])
            s_norm_slug = normalize_text(s["slug"])
            s_num = s.get("number")

            if s["slug"] in target_slugs or s_norm_slug in target_slugs:
                matches.append(s)
                used_solved_paths.add(s["path"])
                continue

            if s_num and s_num in target_slugs:
                matches.append(s)
                used_solved_paths.add(s["path"])
                continue

            if q_norm and (q_norm == s_norm_title or q_norm == s_norm_slug):
                matches.append(s)
                used_solved_paths.add(s["path"])
                continue

            if q_slug_norm and (q_slug_norm == s_norm_title or q_slug_norm == s_norm_slug):
                matches.append(s)
                used_solved_paths.add(s["path"])
                continue

        if matches:
            matched_questions[q_id] = matches

    total_q = len(questions)
    total_solved = len(matched_questions)
    overall_percent = (total_solved / total_q * 100) if total_q else 0.0

    extra_solved = [s for s in solved_items if s["path"] not in used_solved_paths]
    total_all_solved = total_solved + len(extra_solved)

    # Group by Topic
    topics = {}
    for q in questions:
        t = q["topic"]
        if t not in topics:
            topics[t] = []
        topics[t].append(q)

    lines = []
    lines.append("# 🎯 DSA Tracker - Apna College Sheet (375 Questions)")
    lines.append("")
    lines.append("> Automated progress tracking for **DSA by Shradha Didi & Aman Bhaiya (Apna College)**.")
    lines.append("> Automatically synced via **LeetSync** (`Leetcode/`), **GeekSync** (`Geeks For Geeks/`), and **GitHub Actions**.")
    lines.append("")
    lines.append("---")
    lines.append("")
    lines.append("## 📊 Overall Progress Summary")
    lines.append("")
    lines.append("| Metric | Solved | Total | Progress |")
    lines.append("| :--- | :---: | :---: | :--- |")
    lines.append(f"| **🎯 Apna College Sheet** | `{total_solved}` | `{total_q}` | `{get_progress_bar(overall_percent, 18)}` **{overall_percent:.1f}%** |")
    lines.append(f"| **🌟 Outside Sheet Problems** | `{len(extra_solved)}` | `-` | `{get_progress_bar(100, 18)}` **Tracked** |")
    lines.append(f"| **🔥 Total Solved in Repo** | `{total_all_solved}` | `-` | **All Platforms** |")
    lines.append("")
    lines.append("---")
    lines.append("")
    lines.append("## 📑 Topic Summary")
    lines.append("")
    lines.append("| Topic | Solved | Total | Progress | Link |")
    lines.append("| :--- | :---: | :---: | :--- | :---: |")

    for t_name, t_questions in topics.items():
        t_solved = sum(1 for q in t_questions if q["id"] in matched_questions)
        t_total = len(t_questions)
        t_percent = (t_solved / t_total * 100) if t_total else 0.0
        anchor = re.sub(r"[^a-z0-9]+", "-", t_name.lower()).strip("-")
        lines.append(f"| **{t_name}** | `{t_solved}` | `{t_total}` | `{get_progress_bar(t_percent, 15)}` {t_percent:.1f}% | [View](#{anchor}) |")

    lines.append("")
    lines.append("---")
    lines.append("")

    # Outside Sheet Problems Table (Collapsible)
    lines.append("<details>")
    lines.append(f"<summary><h2 style=\"display:inline\" id=\"outside-sheet-problems\">🌟 Outside Sheet Problems ({len(extra_solved)} Extra Solved)</h2></summary>\n")
    lines.append(f"> Additional `{len(extra_solved)}` problems solved on LeetCode / GFG outside the Apna College sheet.\n")
    lines.append("| # | Problem | Platform | Difficulty | Solution |")
    lines.append("| :---: | :--- | :---: | :---: | :---: |")
    for idx, s in enumerate(extra_solved, 1):
        sol_link = f"[{s['source']}]({encode_path(s['sol_file'])})"
        prob_link = f"[{s['title']}]({s['url']})" if s.get("url") else s["title"]
        lines.append(f"| {idx} | {prob_link} | `{s['source']}` | `{s['difficulty']}` | {sol_link} |")
    lines.append("\n</details>\n")
    lines.append("---")
    lines.append("")

    # Topic-wise detailed tables (Collapsible)
    lines.append("## 📚 Apna College Sheet Questions by Topic\n")
    for t_name, t_questions in topics.items():
        t_solved = sum(1 for q in t_questions if q["id"] in matched_questions)
        t_total = len(t_questions)
        t_percent = (t_solved / t_total * 100) if t_total else 0.0
        anchor = re.sub(r"[^a-z0-9]+", "-", t_name.lower()).strip("-")
        
        lines.append("<details>")
        lines.append(f"<summary><h3 style=\"display:inline\" id=\"{anchor}\">📂 {t_name} &nbsp;—&nbsp; {t_solved}/{t_total} Solved ({t_percent:.1f}%)</h3></summary>\n")
        lines.append("| Status | # | Problem | Companies | Notes / Remarks | Solution |")
        lines.append("| :---: | :---: | :--- | :--- | :--- | :--- |")

        for q in t_questions:
            q_id = q["id"]
            is_solved = q_id in matched_questions
            status = "✅" if is_solved else "⬜"

            problem_link = f"[{q['name']}]({q['url']})" if q.get("url") else q["name"]
            companies = q["companies"].replace("|", "/") if q["companies"] else "-"
            remarks = q["remarks"].replace("|", "/") if q["remarks"] else "-"

            if is_solved:
                sol_links = []
                for s in matched_questions[q_id]:
                    enc_path = encode_path(s["sol_file"])
                    label = s["source"]
                    sol_links.append(f"[{label}]({enc_path})")
                solution_str = " \\| ".join(sol_links)
            else:
                solution_str = "-"

            lines.append(f"| {status} | {q_id} | {problem_link} | {companies} | {remarks} | {solution_str} |")

        lines.append("\n[⬆ Back to Summary](#-topic-summary)\n")
        lines.append("</details>\n")

    with open(README_FILE, "w", encoding="utf-8") as f:
        f.write("\n".join(lines) + "\n")

    print(f"Updated README.md: {total_solved}/{total_q} Apna College questions tracked. {len(extra_solved)} additional solved.")

if __name__ == "__main__":
    main()
