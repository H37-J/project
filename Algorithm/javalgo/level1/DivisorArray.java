import java.util.ArrayList;
import java.util.Arrays;

public class DivisorArray {
//     arr	divisor	return
// [5, 9, 7, 10]	5	[5, 10]
// [2, 36, 1, 3]	1	[1, 2, 3, 36]
// [3,2,6]	10	[-1]
    public static void main(String... args){
        int[] arr={3,2,6};
        int divisor=10;
        Integer[] answer=solution(arr,divisor);
        System.out.println(Arrays.toString(answer));
        
    }

    public static Integer[] solution(int[] arr, int divisor){
        ArrayList<Integer> list=new ArrayList<>();
        for(int value : arr){
            if(value % divisor==0) list.add(value);
        }
        if(list.size()==0) list.add(-1);
        return list.stream().sorted().toArray(Integer[]::new);
    }
}
