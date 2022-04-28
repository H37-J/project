package sort;

import static sort.SortUtils.*;

public class InsertSort implements SortAlgorithm{
    
    @Override
    public <T extends Comparable<T>> T[] sort(T[] arr){
        for(int i=1; i<arr.length; i++){
            T insertValue = arr[i];
            int j;

            for(j = i - 1; j >= 0 && less(insertValue, arr[j]); j--){
                arr[j+1] = arr[j];
            }
            if(j != i-1){
                arr[j+1] = insertValue;
                System.out.println("j:"+j);
                System.out.println("insertValue:"+insertValue);
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Integer[] integers = {2,1};
        InsertSort sort= new InsertSort();
        sort.sort(integers);
        print(integers); /* [1, 4, 6, 9, 12, 23, 54, 78, 231] */
    
        String[] strings = {"c", "a", "e", "b", "d"};
        sort.sort(strings);
        print(strings); /* [a, b, c, d, e] */
      }
}
