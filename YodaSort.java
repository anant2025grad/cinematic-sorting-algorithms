import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * YodaSort - "Do, or do not. There is no try."
 *
 * Yoda speaks in reverse. So YodaSort sorts in reverse first (descending),
 * contemplates the result, then reverses its own logic — producing
 * a correct ascending sort, but only after going the "wrong" way first.
 *
 * Internally, this is a reverse-then-flip sort using Collections.sort + reverse.
 * It always produces a correct result, just via a roundabout philosophical journey.
 *
 * Time complexity: O(n log n) — two sorts + one reverse.
 * Space complexity: O(n)
 */
public class YodaSort {

    public static List<Integer> sort(List<Integer> arr, List<String> log) {
        List<Integer> current = new ArrayList<>(arr);
        log.add("STEP 0 | \"Begun, the sorting has.\" Initial: " + current);

        // Step 1: Sort descending — Yoda's way (backwards first)
        current.sort(Collections.reverseOrder());
        log.add("STEP 1 | \"Backwards, the path is.\" Descending pass: " + current);

        // Step 2: Contemplate — find the median as the "Force center"
        int forceCenter = current.get(current.size() / 2);
        log.add("STEP 2 | \"The Force center, I sense it.\" Pivot value: " + forceCenter);

        // Step 3: Reverse — "Do or do not, there is no try" — flip to ascending
        Collections.reverse(current);
        log.add("FINAL  | \"Unlearn what you have learned.\" Ascending: " + current);

        return current;
    }

    public static void main(String[] args) {
        List<Integer> input = List.of(38, 27, 43, 3, 9, 82, 10, 55, 17, 64);
        List<String> log = new ArrayList<>();
        List<Integer> result = sort(new ArrayList<>(input), log);
        System.out.println("=== YODA SORT ===");
        log.forEach(System.out::println);
        System.out.println("Result: " + result);
    }
}
