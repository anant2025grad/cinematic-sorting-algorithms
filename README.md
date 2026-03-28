# Cinematic Sorting Algorithms

A sorting algorithm visualizer and Java implementation suite built as an open source educational tool for introductory CS courses.

Each algorithm is inspired by a film character whose behavior mirrors a classical sorting algorithm, making concepts like time complexity and swaps easier to understand and remember.

---

## Files

- webVisualizer.html
- ThanosSort.java
- InterstellarSort.java
- T1000Sort.java
- YodaSort.java
- WallESort.java
- AntonChigurhSort.java

---

## The Algorithms

**Thanos Sort** - based on halving/elimination (lossy sort)

Repeatedly eliminates the bottom half of values each pass until 1-2 elements survive. The only lossy sort in the project - not all elements make it to the output.

**Interstellar Sort** - based on median-pivot sort (related to Quicksort)

Finds the median value as a gravity well, pulls elements in by proximity, then settles them into ascending order.

**T-1000 Sort** - based on Bubble Sort

Scans adjacent pairs each pass and swaps them if out of order. Repeats until no swaps are needed. The largest unsorted value bubbles to the end each pass.

**Yoda Sort** - based on reverse and flip

Sorts descending first, then reverses the result to get ascending order. Shows that different paths can produce the same correct output.

**WALL-E Sort** - based on Selection Sort

Finds the smallest remaining element each pass and places it in the next open slot. Makes exactly n-1 swaps regardless of input.

**Anton Chigurh Sort** - based on Bogosort

Flips a coin for each adjacent pair. Heads: swap if out of order. Tails: do nothing. Repeats until sorted by chance or a safety cap is hit.

---

## Running the Visualizer

Download webVisualizer.html and open the file in a browser. No installation needed.

Bar colors during animation:
- Blue = unsorted/default
- Red = being compared
- Yellow = being swapped
- Green = sorted

---

## For Educators

The visualizer runs in any browser with no setup, making it easy to demo during a lecture. Each algorithm is designed to map onto a concept taught in intro CS:

- T-1000 Sort and WALL-E Sort show the difference between Bubble Sort and Selection Sort
- Anton Chigurh Sort demonstrates why non-deterministic algorithms are impractical
- Yoda Sort illustrates algorithm equivalence
- Thanos Sort opens a discussion about what correctness means in algorithm design

Free to use and modify for classroom purposes.

---

## License

MIT License - free to use, modify, and distribute.

---

## Author

Anant V. Palve - first year CyberSecurity student, The Pennsylvania State University
John R. Chapin Undergraduate Exhibition 2026
