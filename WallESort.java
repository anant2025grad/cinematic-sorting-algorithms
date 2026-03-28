import java.util.ArrayList;
import java.util.List;

/**
 * WallESort - "Directive: organize. One piece at a time."
 *
 * WALL-E patiently picks up the smallest unsorted element and stacks it
 * neatly at the end of the sorted section — a pure selection sort.
 * Each "cube" WALL-E compresses and stacks is narrated step by step.
 *
 * Time complexity:  O(n^2) — selection sort.
 * Space complexity: O(1) auxiliary — in-place.
 */
public class WallESort {

    public static List<Integer> sort(List<Integer> arr, List<String> log) {
        List<Integer> current = new ArrayList<>(arr);
        int n = current.size();
        log.add("STEP 0 | WALL-E surveys the mess: " + current);

        for (int i = 0; i < n - 1; i++) {
            // Find the smallest element in the unsorted section
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (current.get(j) < current.get(minIdx)) {
                    minIdx = j;
                }
            }

            // Swap the found minimum into position
            if (minIdx != i) {
                int tmp = current.get(i);
                current.set(i, current.get(minIdx));
                current.set(minIdx, tmp);
            }

            log.add("CUBE  " + (i + 1) + " | WALL-E stacks " + current.get(i)
                    + " → stack so far: " + current.subList(0, i + 1)
                    + " | remaining: " + current.subList(i + 1, n));
        }

        log.add("FINAL  | WALL-E's perfectly organized stack: " + current);
        return current;
    }

    public static void main(String[] args) {
        List<Integer> input = List.of(38, 27, 43, 3, 9, 82, 10, 55, 17, 64);
        List<String> log = new ArrayList<>();
        List<Integer> result = sort(new ArrayList<>(input), log);
        System.out.println("=== WALL-E SORT ===");
        log.forEach(System.out::println);
        System.out.println("Result: " + result);
    }
}
