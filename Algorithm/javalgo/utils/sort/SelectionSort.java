package sort;

public class SelectionSort implements SortAlgorithm{

    @Override
    public <T extends Comparable<T>> T[] sort(T[] arr){
        int n=arr.length;
        for(int i=0; i<n-1; i++){
            int minIndex=i;
            for(int j=i+1; j<n; j++){
                if(arr[minIndex].compareTo(arr[j])>0){
                    minIndex=j;
                }
            }

            if(minIndex!=i){
                T temp=arr[i];
                arr[i]=arr[minIndex];
                arr[minIndex]=temp;
            }
        }

        return arr;
    }
    
}
