# Cinematic Sorting Algorithms

A pop-culture themed sorting algorithm visualizer and Java implementation suite — built as an open-source educational tool for introductory CS and data structures courses.

Each algorithm is inspired by a well-known film character whose fictional behavior naturally mirrors the mechanics of a classical sorting algorithm. The goal is to make abstract concepts like time complexity, swap counts, and algorithmic efficiency more intuitive and memorable for students.

> Created for the John R. Chapin Undergraduate Exhibition 2026 — The Pennsylvania State University

\---

## What's Inside

```
cinematic-sorting-algorithms/
├── webVisualizer.html

├── ThanosSort.java
├── InterstellarSort.java
├── T1000Sort.java
├── YodaSort.java
├── WallESort.java
├── AntonChigurhSort.java

\---

## The Algorithms

### Thanos Sort

> \\\*"Perfectly balanced, as all things should be."\\\*

**Based on:** Halving / Elimination (novel lossy sort category)
**Time:** O(n log n)  |  **Space:** O(n)  |  **Lossy: YES**

Repeatedly sorts the array and eliminates the bottom half of values each pass, until only 1–2 elements survive. Unlike every other sort, this one is **lossy** — not all elements make it to the output. This raises a genuine research question: what happens when we relax the requirement that a sort must preserve every element?

\---

### Interstellar Sort

> \\\*"Gravity pulls everything into order."\\\*

**Based on:** Gravity-biased / Median-pivot sort (related to Quicksort)
**Time:** O(n log n)  |  **Space:** O(n)  |  **Lossy: No**

Establishes a "gravity well" at the median value of the array. Elements are first pulled in by proximity to the center, then settle into their final ascending positions. Demonstrates the concept of pivot-based partitioning in an intuitive way.

\---

### T-1000 Sort

> \\\*"It reforms. It adapts. It always reaches its target."\\\*

**Based on:** Bubble Sort
**Time:** O(n²)  |  **Space:** O(1)  |  **Lossy: No**

A Bubble Sort where each pass is framed as the T-1000 "reflowing." Adjacent pairs are compared and swapped if out of order, pass after pass, until the array solidifies into sorted order. The largest unsorted element bubbles to its correct position at the end of each pass.

\---

### Yoda Sort

> \\\*"Do, or do not. There is no try."\\\*

**Based on:** Reverse + Flip (equivalent to standard ascending sort)
**Time:** O(n log n)  |  **Space:** O(n)  |  **Lossy: No**

Sorts descending first — because Yoda does everything backwards. After identifying the "Force center" (median), it reverses the array to produce a correct ascending result. Demonstrates that multiple algorithmic paths can produce identical correct outputs.

\---

### WALL-E Sort

> \\\*"Directive: organize. One piece at a time."\\\*

**Based on:** Selection Sort
**Time:** O(n²)  |  **Space:** O(1)  |  **Lossy: No**

Patiently scans the unsorted section to find the smallest remaining element, then places it at the front — one "cube" at a time. Makes exactly n-1 swaps regardless of input, minimizing writes to memory compared to Bubble Sort.

\---

### Anton Chigurh Sort

> \\\*"Call it, friend-o."\\\*

**Based on:** Bogosort / Coin-flip
**Time:** O(∞) expected  |  **Space:** O(1)  |  **Lossy: No**

For each adjacent pair, flips a coin. Heads: swap if out of order. Tails: do nothing — even if the pair needs fixing. Repeats until the array is sorted by chance, or until a safety cap is hit and Anton "gives up." Exists to illustrate why determinism and guaranteed forward progress matter in algorithm design.

\---

## Running the Visualizer

Just open `webVisualizer.html` in any modern browser (Chrome recommended). No dependencies, no build step, no installation.

**Controls:**

* **Algorithm** — select which sort to run from the dropdown
* **Array size** — how many elements to sort (5–50)
* **Speed** — controls animation delay between steps
* **Run** — generates a new random array and starts the sort
* **Stop** — halts the sort mid-run
* **New Array** — generates a fresh array without running

**Bar colors during animation:**

* 🔵 Blue — default / unsorted
* 🔴 Red — currently being compared
* 🟡 Yellow — being swapped
* 🟢 Green — confirmed sorted position

\---

## For Educators

This project is designed to be classroom-ready. The visualizer requires no setup and runs in any browser, making it easy to demo live during a lecture. Suggested uses:

* **Intro to sorting** — use WALL-E Sort and T-1000 Sort to contrast Selection Sort vs. Bubble Sort side by side
* **Complexity discussion** — run Anton Chigurh Sort to show why O(∞) algorithms are impractical
* **Algorithm equivalence** — use Yoda Sort to demonstrate that different paths can produce the same correct output
* **Research discussion** — use Thanos Sort to open a conversation about what "correct" means in algorithm design

Feel free to fork, modify, and use this in your course. MIT licensed.

\---

## License

MIT License — free to use, modify, and distribute. See `LICENSE` for details.

\---

## Author

Built by Anant V. Palve — first-year Cybersecurity student at The Pennsylvania State University.
John R. Chapin Undergraduate Exhibition 2026.

