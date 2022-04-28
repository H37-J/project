package sort;

import static sort.SortUtils.*;

public class BubbleSort implements SortAlgorithm{
    

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array){
        for(int i=0, size=array.length; i<size-1; i++){
            boolean swapped=false;
            for(int j=0; j<size-1; j++){
                if(greater(array[j], array[j+1])){
                    swap(array,j,j+1);
                    swapped=true;
                }
            }

            if(!swapped){
                break;
            }
        }

        return array;
    }

    //재귀방식
    public static <T extends Comparable<T>> void bubbleSort(T[] unsorted,int len){
        boolean swapped=false;
        for(int i=0; i<len-1; i++){
            if(SortUtils.greater(unsorted[i],unsorted[i+1])){
                SortUtils.swap(unsorted,i,i+1);
                swapped=true;
            }
            if(swapped){
                bubbleSort(unsorted, len-1);
            }
        }
    }

    public <T extends Comparable<T>> T[] sortRecuresion(T[] unsorted){
        bubbleSort(unsorted, unsorted.length);
        return unsorted;
    }

    public static void main(String[] args){

        Integer[] integers={4,23,6,78,1};
        BubbleSort bubbleSort=new BubbleSort();
        bubbleSort.sort(integers);

        print(integers);

        String[] strings={"c","a","e","d","b"};
        bubbleSort.sortRecuresion(strings);
        print(strings);
    }



}
