import java.util.Arrays;
import java.util.stream.Stream;

public class ArrayMinNum {
//     A	B	answer
// [1, 4, 2]	[5, 4, 4]	29
// [1,2]	[3,4]	10

    public static void main(String... args){
        int[] a={1,4,2};
        int[] b={5,4,4};
        solution(a,b);
    }

    public static int solution(int[] a, int[] b){
        int answer=0;
        Arrays.sort(a);
        Integer[] c=Arrays.stream(b).boxed().toArray(Integer[]::new); //Integer로 바꿔야 compare가능
        c=Stream.of(c).sorted((e1,e2)-> e2.compareTo(e2)).toArray(Integer[]::new);

        for(int i=0; i<a.length; i++){
            answer+=a[i] * b[i];
        }



        return answer;
    }
}
