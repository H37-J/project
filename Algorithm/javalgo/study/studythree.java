import java.util.ArrayList;

public class studythree {
   
    public static void main(String[] args){
        Integer[] arr = {1,2,3,4,5,6,7};
        int left = 0;
        int right = arr.length;
        int median = getMedian(left, right);

        int index = find(arr,7);
        System.out.println(index);
    }

    public static int getMedian(int left, int right){
        return (left + right) >>> 1;
    }

    public static <T extends Comparable<T>> int find(T[] array, T key) {
        int l, r, k, cmp;

        l = 0;
        r = array.length;

        while (l <= r) {
            k = (l + r) >>> 1;
            cmp = key.compareTo(array[k]);

            if (cmp == 0) {
                return k;
            } else if (cmp < 0) {
                r = --k;
            } else {
                l = ++k;
            }
        }

        return -1;
    }
}
