import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * SortBenchmark - Runs all cinematic sorting algorithms and compares
 * their runtime and step counts against standard sorts.
 *
 * For each algorithm:
 *   - Uses the same input array
 *   - Records wall-clock time (nanoseconds → milliseconds)
 *   - Records number of log steps produced
 *   - Reports whether result is correctly sorted (or lossy)
 */
public class SortBenchmark {

    public static void main(String[] args) {
        int[] sizes = {10, 50, 100};

        for (int n : sizes) {
            List<Integer> input = randomArray(n);
            System.out.println("\n====================================================");
            System.out.println("  BENCHMARK — Array size: " + n);
            System.out.println("  Input: " + (n <= 10 ? input.toString() : "[" + n + " random elements]"));
            System.out.println("====================================================");

            runBenchmark("ThanosSort      (Lossy Halving)",     input, "thanos");
            runBenchmark("InterstellarSort (Gravity Well)",      input, "interstellar");
            runBenchmark("T1000Sort        (Liquid Bubble)",     input, "t1000");
            runBenchmark("YodaSort         (Reverse+Flip)",      input, "yoda");
            runBenchmark("WallESort        (Patient Selection)", input, "walle");
            runBenchmark("AntonChigurhSort (Coin Flip Chaos)",   input, "chigurh");
            runBenchmark("Java Arrays.sort (Timsort baseline)",  input, "builtin");
        }
    }

    private static void runBenchmark(String label, List<Integer> input, String which) {
        List<Integer> copy = new ArrayList<>(input);
        List<String> log = new ArrayList<>();

        long start = System.nanoTime();
        List<Integer> result = null;

        switch (which) {
            case "thanos"       -> result = ThanosSort.sort(copy, log);
            case "interstellar" -> result = InterstellarSort.sort(copy, log);
            case "t1000"        -> result = T1000Sort.sort(copy, log);
            case "yoda"         -> result = YodaSort.sort(copy, log);
            case "walle"        -> result = WallESort.sort(copy, log);
            case "chigurh"      -> result = AntonChigurhSort.sort(copy, log);
            case "builtin"      -> {
                java.util.Collections.sort(copy);
                result = copy;
            }
        }

        long elapsed = System.nanoTime() - start;
        double ms = elapsed / 1_000_000.0;

        boolean sorted = isSorted(result);
        boolean lossy  = which.equals("thanos") && result.size() < input.size();

        System.out.printf("  %-40s | %6.3f ms | %4d steps | %s%n",
                label, ms, log.size(),
                lossy ? "LOSSY (" + result.size() + "/" + input.size() + " survived)"
                       : (sorted ? "✓ Sorted" : "✗ NOT sorted"));
    }

    private static boolean isSorted(List<Integer> arr) {
        if (arr == null || arr.size() <= 1) return true;
        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i) > arr.get(i + 1)) return false;
        }
        return true;
    }

    private static List<Integer> randomArray(int n) {
        Random rng = new Random(42); // fixed seed for reproducibility
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) arr.add(rng.nextInt(1000));
        return arr;
    }
}
