package math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Mode {

    public static void main(String[] args) {

        assert (mode(new int[] {})) == null;
        assert Arrays.equals(mode(new int[] { 5 }), new int[] { 5 });
        assert Arrays.equals(mode(new int[] { 1, 2, 3, 4, 5 }), new int[] { 1, 2, 3, 4, 5 });
        assert Arrays.equals(mode(new int[] { 7, 9, 9, 4, 5, 6, 7, 7, 8 }), new int[] { 7 });
        assert Arrays.equals(mode(new int[] { 7, 9, 9, 4, 5, 6, 7, 7, 9 }), new int[] { 7, 9 });
    }

    public static int[] mode(int[] numbers) {
        if (numbers.length == 0)
            return null;

        HashMap<Integer, Integer> count = new HashMap<>();

        for (int num : numbers) {

            if (count.containsKey(num)) {
                count.put(num, count.get(num) + 1);
            } else {
                count.put(num, 1);
            }
        }

        int max = Collections.max(count.values());
        ArrayList<Integer> modes = new ArrayList<>();

        for (int num : count.keySet()) {
            if (count.get(num) == max) {
                modes.add(num);
            }
        }

        return modes.stream().mapToInt(n -> n).toArray();
    }
}
