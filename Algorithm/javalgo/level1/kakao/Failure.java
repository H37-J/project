package kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;



public class Failure {
    
//     N	stages	result
// 5	[2, 1, 2, 6, 2, 4, 3, 3]	[3,4,2,1,5]
// 4	[4,4,4,4,4]	[4,1,2,3]

//몇가지 테스트케이스 실패, 시간초과 개선하기
    public static void main(String... args){
        int N=5;
        int[] stages={2,1,2,6,2,4,3,3};
        System.out.println(solution(N, stages));
    }

    public static Integer[] solution(int N,int[] stages){
        int userNum=stages.length;
        int count;

        ArrayList<Integer> stages_list=new ArrayList<>();
        ArrayList<Integer> answer=new ArrayList<>();
        Map<Integer,Double> map=new HashMap<Integer,Double>();

        for(int value : stages){
            stages_list.add(value);
        }

        for(int i=1; i<=N; i++){
            count=0;
            while(stages_list.indexOf(i)!=-1){
                count++;
                stages_list.remove(stages_list.indexOf(i));
            } //공통 값 몇개 있는지 찾는 것
            map.put(i,(double)count/userNum);
            userNum-=count;
        }

        List<Entry<Integer, Double>> entries = new ArrayList<Entry<Integer, Double>>(map.entrySet());

        Collections.sort(entries,new Comparator<Map.Entry<Integer,Double>>() {
            public int compare(Entry<Integer,Double> e1, Entry<Integer,Double> e2){
                return e2.getValue().compareTo(e1.getValue()); //값순으로 내림차순 정렬
            }
        });

        for(Map.Entry<Integer,Double> value : entries){
            System.out.println(value.getValue());
            answer.add(value.getKey());
        }
        return answer.stream().toArray(Integer[]::new);
    }
}
