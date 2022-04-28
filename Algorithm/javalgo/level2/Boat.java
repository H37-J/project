import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Boat {
    
    public static void main(String... args){
        int[] people={70, 80, 50};
        int limit=100;
        solution(people,limit);
    }



    public static int solution(int[] people,int limit){
        int answer=0;
        Arrays.sort(people);
        int start=0;
        int end=people.length-1;
        while(start<=end){
            int sum=0;
            if(start!=end) sum = people[end] + people[start];
            else sum = people[end];
            if(sum > limit){
                end--;
            }else{
                end--;
                start++;
            }
            answer++;
        }
        return answer;
    }
}


// people	limit	return
// [70, 50, 80, 50]	100	3
// [70, 80, 50]	100	3