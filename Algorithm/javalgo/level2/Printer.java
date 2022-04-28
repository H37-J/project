import java.util.LinkedList;
import java.util.Queue;

public class Printer {
    public static void main(String... args){
        int[] priorities={2,1,3,2};
        int location=0;

        solution(priorities,location);
    }

    public static int solution(int[] priorities,int location){
        Queue<Integer> pri=new LinkedList<>();
        Queue<Integer> keys=new LinkedList<>();
        int index=0;
        int answer=0;
        for(int p : priorities){
            pri.add(p);
            keys.add(index);
            index++;
        }


        int count=priorities.length;
        while(!pri.isEmpty()){
            int temp=pri.poll();
            int key=keys.poll();
            boolean check=pri.stream().allMatch(p -> p <= temp);
            
            if(!check){
                pri.add(temp);
                keys.add(key);
                continue;
            }
            if(key==location){
                answer=count-pri.size();
                break;
            }
        }
        return answer;
    }


}


// priorities	location	return
// [2, 1, 3, 2]	2	1
// [1, 1, 9, 1, 1, 1]	0	5