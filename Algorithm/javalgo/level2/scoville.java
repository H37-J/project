import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;


public class scoville {
    
//     scoville	K	return
// [1, 2, 3, 9, 10, 12]	7	2

    public static void main(String[] args){
        int[] scoville={1,2,3,9,10,12};
        int k=7;

        solution2(scoville,k);
    }

    public static int solution2(int[] scoville,int k){
        int answer=0;
        PriorityQueue<Integer> q=new PriorityQueue<>();

        for(int s : scoville) q.add(s);

        while(q.peek() < k){
            if(q.size()==1) { answer=-1; break;}
            int first=q.poll();
            int second=q.poll();
            int num = first + (second * 2);
            q.add(num);
            answer++;
        }


        return answer;
    }

    public static int solution(int[] scoville,int k){
        int answer=0;
        List<Integer> list=Arrays.stream(scoville).sorted().boxed().collect(Collectors.toList());

        while(list.get(0) < k ){
            if(list.get(0) < k && list.size()==1) {answer=-1; break;}
            int first = Math.min(list.get(0),list.get(1));
            int second = Math.max(list.get(0),list.get(1));
            int num=first + (second * 2);
            list.remove(0);
            list.set(0,num);
            answer++;
            Collections.sort(list);
        } 

        return answer;
    }

 
}
