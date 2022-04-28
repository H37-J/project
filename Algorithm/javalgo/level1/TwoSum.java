import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class TwoSum {
//     numbers	result
// [2,1,3,4,1]	[2,3,4,5,6,7]
// [5,0,2,7]	[2,5,7,9,12]

    public static void main(String... args){
        int[] numbers={5,0,2,7};
        solution(numbers);

    }

    public static Integer[] solution(int[] numbers){
        HashSet<Integer> list=new HashSet<>();
        for(int i=0; i<numbers.length-1; i++){
            for(int j=i+1; j<numbers.length; j++){
                list.add(numbers[i]+numbers[j]);
            }
        }
        return list.stream().sorted().toArray(Integer[]::new);
    }
}
