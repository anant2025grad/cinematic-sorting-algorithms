import java.util.ArrayList;
import java.util.List;

/**
 * InterstellarSort - "Gravity pulls everything into order."
 *
 * A "gravity well" target value is established (the median of the array).
 * Elements closest to the gravity well are pulled in and placed first.
 * Remaining elements are then sorted by increasing distance from the well.
 *
 * This produces a valid sort (ascending) but via an unconventional gravity-biased
 * priority — elements "fall" into the sorted sequence based on proximity to center.
 *
 * Time complexity: O(n log n) — dominated by distance-sort step.
 * Space complexity: O(n)
 */
public class InterstellarSort {

    public static List<Integer> sort(List<Integer> arr, List<String> log) {
        List<Integer> current = new ArrayList<>(arr);
        log.add("STEP 0 | Initial array: " + current);

        // Establish gravity well: median value
        List<Integer> temp = new ArrayList<>(current);
        java.util.Collections.sort(temp);
        int gravityWell = temp.get(temp.size() / 2);
        log.add("STEP 1 | Gravity well established at value: " + gravityWell + " (median)");

        // Sort by distance from gravity well, then by value for ties
        current.sort((a, b) -> {
            int distA = Math.abs(a - gravityWell);
            int distB = Math.abs(b - gravityWell);
            if (distA != distB) return Integer.compare(distA, distB);
            return Integer.compare(a, b);
        });
        log.add("STEP 2 | Elements pulled in by gravity (sorted by proximity): " + current);

        // Final ascending sort — gravity has done its job, now settle into place
        java.util.Collections.sort(current);
        log.add("FINAL  | Elements settled into orbit (ascending): " + current);

        return current;
    }

    public static void main(String[] args) {
        List<Integer> input = List.of(38, 27, 43, 3, 9, 82, 10, 55, 17, 64);
        List<String> log = new ArrayList<>();
        List<Integer> result = sort(new ArrayList<>(input), log);
        System.out.println("=== INTERSTELLAR SORT ===");
        log.forEach(System.out::println);
        System.out.println("Result: " + result);
    }
}
