import java.util.Arrays;

public class CommonMultiple {
//     arr	result
// [2,6,8,14]	168
// [1,2,3]	6
    public static void main(String... args){
        int[] arr={0,7,14,13,15,19,21,33};
        solution(arr);
    }

    public static long solution(int[] arr){
        Arrays.sort(arr);
        long answer=0;
        long max=arr[arr.length-1];
        int original=arr[arr.length-1];
        int count=1;
        for(int i=0; i<arr.length-1; i++){
            if(arr[i]==0) continue;
            if(max % arr[i] == 0 && i==arr.length-2){
                answer=max;
                break;
            }
            if(max % arr[i] == 0) continue;
            else{
                count++;
                max = original * count;
                i=0;
            }
        }

        return answer;
    }
}
