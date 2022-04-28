import java.util.Arrays;

public class Budget {
   
//     d	budget	result
// [1,3,2,5,4]	9	3
// [2,2,3,3]	10	4

    public static void main(String... args){
        int[] d={1,3,2,5,4};
        int budget=9;

        int[] d2={2,2,3,3};
        int budget2=10;

        solution(d,budget);
        solution(d2,budget2);
    }

    public static int solution(int[] d,int budget){
        int answer=0;
        int sum=0;
        Arrays.sort(d);

        for(int value:d){
            sum+=value;
            if(budget<sum) break;
            answer++;
        }


        return answer;
    }
}
