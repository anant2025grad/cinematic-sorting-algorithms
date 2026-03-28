import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * AntonChigurhSort - "Call it, friend-o."
 *
 * Anton Chigurh decides each element's fate by a coin flip.
 * Each pass: iterate through all adjacent pairs. For each pair,
 * flip a coin — heads: swap them, tails: leave them.
 * Repeat until the array happens to be sorted.
 *
 * This is a themed Bogosort variant — randomly shuffling and checking —
 * but with the coin-flip framing applied per-pair rather than globally,
 * making it slightly less catastrophic but still deeply unreliable.
 *
 * Time complexity: O(∞) expected — unbounded random walks.
 *                  Average case for n elements: O(n * n!) — like Bogosort.
 * Space complexity: O(1) auxiliary.
 *
 * NOTE: For large arrays this may run for a VERY long time.
 *       A max iteration cap is applied for safety.
 */
public class AntonChigurhSort {

    private static final int MAX_ITERATIONS = 10_000;
    private static final Random rng = new Random();

    public static List<Integer> sort(List<Integer> arr, List<String> log) {
        List<Integer> current = new ArrayList<>(arr);
        int flips = 0;
        log.add("STEP 0 | Anton surveys the situation: " + current);
        log.add("        \"What's the most you ever lost on a coin toss?\"");

        while (!isSorted(current) && flips < MAX_ITERATIONS) {
            for (int i = 0; i < current.size() - 1; i++) {
                boolean heads = rng.nextBoolean();
                if (heads) {
                    // Coin says swap
                    int tmp = current.get(i);
                    current.set(i, current.get(i + 1));
                    current.set(i + 1, tmp);
                }
            }
            flips++;
            if (flips <= 5 || flips % 100 == 0) {
                log.add("FLIP  " + flips + " | " + current
                        + (isSorted(current) ? " ← SORTED" : ""));
            }
        }

        if (!isSorted(current)) {
            // Fallback: Anton gets impatient
            Collections.sort(current);
            log.add("FINAL  | Anton ran out of patience after " + flips
                    + " flips. He sorted it himself: " + current);
        } else {
            log.add("FINAL  | Sorted after " + flips + " coin flip passes: " + current);
            log.add("        \"The coin knows. It always knew.\"");
        }

        return current;
    }

    private static boolean isSorted(List<Integer> arr) {
        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i) > arr.get(i + 1)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // Use a small array — Chigurh is unpredictable with large ones
        List<Integer> input = List.of(5, 3, 8, 1, 9, 2, 7, 4, 6);
        List<String> log = new ArrayList<>();
        List<Integer> result = sort(new ArrayList<>(input), log);
        System.out.println("=== ANTON CHIGURH SORT ===");
        log.forEach(System.out::println);
        System.out.println("Result: " + result);
    }
}
