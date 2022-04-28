
import java.util.*;

public class PrintQueue {
    
    //프로그래머스 레벨2 프린터큐
//     priorities 	location 	return
//    [2, 1, 3, 2] 	 2        	1
//   [1, 1, 9, 1, 1, 1] 0 	    5
    public static void main(String[] arags){
        int[] priorities={2,1,3,2};
        int location=2;

        solution(priorities,location);
    }

    public static int solution(int[] priorities, int location) {
        int answer = 1;
        Queue<Integer> q=new LinkedList<>(Arrays.asList(Arrays.stream(priorities).boxed().toArray(Integer[]::new)));
        Queue<Integer> l=new LinkedList<>();
        for(int i=0; i<q.size(); i++){
            l.offer(i);
        }

        while(!q.isEmpty()){
            int compare=q.poll();
            int tempSize=q.size();
            int loc=l.poll();
            Integer[] p=q.toArray(Integer[]::new);
            for(int i=0; i<p.length; i++){
                if(compare<p[i]) {q.add(compare); l.add(loc); break;}
            }
            if(tempSize==q.size()){
              if(loc==location){ break; }
              else{answer++;}
            }
        }

        return answer;
    }
}
