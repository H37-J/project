import java.util.Arrays;

public class Combination {
    
    public static void main(String... args){
            int[] arr={1,3,7};
            combination(arr, 0, 0);
    }

    public static void combination(int[] arr,int count,int index){

        if(count==2){
            for(int i=0; i<count; i++){
                System.out.print(arr[i]+",");
            }
            System.out.println("");
        }


        for(int i=index; i<arr.length; i++){
            swap(arr,index,i);
            combination(arr,count+1,index+1);
            swap(arr,index,i);
            
        }
    }

    public static void swap(int[] arr,int index,int i){
        int temp = arr[i];
        arr[i] = arr[index];
        arr[index] = temp;
    }
}
