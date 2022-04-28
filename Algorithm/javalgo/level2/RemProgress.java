
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.text.html.parser.DTD;

public class RemProgress {
    
    //프로그래머스 레벨2 기능개발 남은 진행률 구하기
//  progresses 	     speeds 	      return
// [93, 30, 55] 	[1, 30, 5] 	[2, 1]
// [95, 90, 99, 99, 80, 99] 	[1, 1, 1, 1, 1, 1] 	[1, 3, 2]
    public static void main(String[] args){
        int[] progresses={95,90,99,99,80,99};
        int[] speeds={1,1,1,1,1,1};
        solution(progresses,speeds);

    }

    public static Integer[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> days=new LinkedList<>();
        ArrayList<Integer> rems=new ArrayList<>();
        for(int i=0; i<progresses.length; i++){
            int rem=100-progresses[i];
            if(rem%speeds[i]==0) days.offer(rem/speeds[i]); 
            else{ days.offer(rem/speeds[i]+1); }
        }
       
        while(!days.isEmpty()){
            int count=1;
            int compare=days.poll();

            while(!days.isEmpty() && days.peek()<=compare){
                days.poll();
                count++;
            }
            rems.add(count);
        }

        return rems.stream().toArray(Integer[]::new);
    }

    //100-proress으로 남은 퍼센트 계산
    //남은 퍼센트를 sppeds로 계산
    //나온 days를 알고리∏즘으로 계산

}
