package sort;

import java.util.Arrays;
import java.util.List;

public class SortUtils {
    
    static <T> boolean swap(T[] arr, int x, int y){
        T swap = arr[x];
        arr[x] = arr[y];
        arr[y] = swap;
        return true;
    }

    static <T extends Comparable<T>> boolean less(T v, T w){
        return v.compareTo(w) < 0;
    }

    static <T extends Comparable<T>> boolean greater(T v, T w){
        return v.compareTo(w) > 0;
    }

    static <T extends Comparable<T>> boolean greaterOrEqual(T v, T w){
        return v.compareTo(w) >= 0;
    }

    static void print(List<?> toPrint){
        toPrint.stream().map(Object::toString).map(str-> str+ " ").forEach(System.out::print);
        System.out.println();
    }

    static void print(Object[] toPrint){
        System.out.println(Arrays.toString(toPrint));
    }

    static <T extends Comparable<T>> void flip(T[] array, int left, int right){
        while(left <= right){
            swap(array,left++,right);
        }
    }
}
