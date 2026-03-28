import java.util.ArrayList;
import java.util.List;

/**
 * T1000Sort - "Liquid metal. It reforms. It adapts. It always reaches its target."
 *
 * A dramatic bubble sort variant where elements "melt and reflow" each pass.
 * Each pass is narrated as the T-1000 reforming after damage.
 * Adjacent elements are compared and swapped if out of order (classic bubble sort),
 * but each pass is framed as the T-1000 "reconstituting" into a more ordered form.
 *
 * Time complexity:  O(n^2) worst case — like bubble sort.
 * Space complexity: O(1) auxiliary — in-place.
 */
public class T1000Sort {

    public static List<Integer> sort(List<Integer> arr, List<String> log) {
        List<Integer> current = new ArrayList<>(arr);
        int n = current.size();
        int pass = 0;

        log.add("STEP 0 | T-1000 takes initial form: " + current);

        boolean reformed = true;
        while (reformed) {
            reformed = false;
            for (int i = 0; i < n - 1 - pass; i++) {
                if (current.get(i) > current.get(i + 1)) {
                    // Swap — the liquid metal reflowing
                    int tmp = current.get(i);
                    current.set(i, current.get(i + 1));
                    current.set(i + 1, tmp);
                    reformed = true;
                }
            }
            if (reformed) {
                pass++;
                log.add("PASS  " + pass + " | T-1000 reflows — " + current);
            }
        }

        log.add("FINAL  | T-1000 locks into final form: " + current);
        return current;
    }

    public static void main(String[] args) {
        List<Integer> input = List.of(38, 27, 43, 3, 9, 82, 10, 55, 17, 64);
        List<String> log = new ArrayList<>();
        List<Integer> result = sort(new ArrayList<>(input), log);
        System.out.println("=== T-1000 SORT ===");
        log.forEach(System.out::println);
        System.out.println("Result: " + result);
    }
}
