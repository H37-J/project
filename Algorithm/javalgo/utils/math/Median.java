package math;

import java.util.Arrays;

public class Median {
    
    public static double median(int[] values){
        Arrays.sort(values);
        int length=values.length;
        return length % 2 ==0 ? (values[length / 2]+ values[length / 2 - 1])/ 2.0
        : values[length / 2];
    }

    public static void main(String... args){
        assert median(new int[] {4, 1, 3, 2}) == 2.5;
        assert median(new int[] {1, 3, 3, 6, 7, 8, 9}) == 6;
        assert median(new int[] {1, 2, 3, 4, 5, 6, 8, 9}) == 4.5;
    }
}
