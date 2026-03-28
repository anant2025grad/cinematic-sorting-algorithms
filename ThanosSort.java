import java.util.ArrayList;
import java.util.List;

/**
 * ThanosSort - "Perfectly balanced, as all things should be."
 *
 * Repeatedly eliminates half the elements (the "worse" half by value)
 * until only 1 or 2 elements remain. The survivors are the sorted result.
 *
 * This is a LOSSY sort — not all input elements survive.
 * Time complexity: O(n log n) eliminations, but result size shrinks to O(1).
 * Space complexity: O(n)
 */
public class ThanosSort {

    public static List<Integer> sort(List<Integer> arr, List<String> log) {
        List<Integer> current = new ArrayList<>(arr);
        int step = 0;

        log.add("STEP 0 | Initial array (" + current.size() + " elements): " + current);

        while (current.size() > 2) {
            List<Integer> survivors = snap(current);
            step++;
            log.add("STEP " + step + " | Snapped " + (current.size() - survivors.size())
                    + " elements. Survivors (" + survivors.size() + "): " + survivors);
            current = survivors;
        }

        log.add("FINAL  | " + current.size() + " element(s) remain (perfectly balanced): " + current);
        return current;
    }

    /**
     * The Snap: remove the lower half of values (the "weakest").
     * In case of odd size, the middle element is spared.
     */
    private static List<Integer> snap(List<Integer> arr) {
        List<Integer> sorted = new ArrayList<>(arr);
        java.util.Collections.sort(sorted);
        int half = sorted.size() / 2;
        return new ArrayList<>(sorted.subList(half, sorted.size()));
    }

    public static void main(String[] args) {
        List<Integer> input = List.of(38, 27, 43, 3, 9, 82, 10, 55, 17, 64);
        List<String> log = new ArrayList<>();
        List<Integer> result = sort(new ArrayList<>(input), log);
        System.out.println("=== THANOS SORT ===");
        log.forEach(System.out::println);
        System.out.println("Result: " + result);
    }
}
