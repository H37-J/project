

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class GreedyReserve {
    
    //프로그래머스 레벨1 체육복 빌려주기 문제
//     n 	lost 	reserve 	return
//     5 	[2, 4] 	[1, 3, 5] 	5
//     5 	[2, 4] 	[3] 	    4
//     3 	[3] 	[1] 	    2
    public static void main(String[] args){
        int[] arr={3};
        int[] reserve={1};
        int answer=solution(3,arr,reserve);
        System.out.println(answer);
    }

    public static ArrayList<Integer> toArrayList(int[] arr){
        return new ArrayList<Integer>(Arrays.asList(Arrays.stream(arr).boxed().toArray(Integer[]::new)));
    }

    public static int solution(int n,int[] l,int[] r){
        int answer=n-l.length;
        ArrayList<Integer> lost=toArrayList(l);
        ArrayList<Integer> reserve=toArrayList(r);

    
        for(int i=0; i<lost.size(); i++){
            for(int j=0; j<reserve.size(); j++){
                if(lost.get(i)-reserve.get(j)==-1 || lost.get(i)-reserve.get(j)==1 || lost.get(i)-reserve.get(i)==0){
                    lost.remove(i);
                    reserve.remove(j);
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }

    // lost와 reserve의 차이는 -1,0,1 범위내
    // 빌려주기가 된다면 lost와 reserve에서 각 요소 제거 후 answer++

}
