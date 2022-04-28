import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


public class Spy {
    public static void main(String... args) {
        String[][] clothes={{"yellowhat","headgear"},{"bluesunglasses","headgear"},{"green_turban","headgear"}};
        solution(clothes);
    }

    public static int solution(String[][] clothes) {
        int answer = 0;
        Map<String,Integer> map=new HashMap<>();
        for(int i=0; i<clothes.length; i++){
            if(map.containsKey(clothes[i][1])) map.put(clothes[i][1],map.get(clothes[i][1])+1);
            else map.put(clothes[i][1],1);
        }
        Optional<Integer> sum=map.values().stream().reduce((v1,v2)-> v1 + v2);
        Optional<Integer> mul=map.values().stream().reduce((v1,v2)-> v1 * v2);
   
        
        answer=sum.get()+mul.get();
        return answer;
    }

}


// 종류	이름
// 얼굴	동그란 안경, 검정 선글라스
// 상의	파란색 티셔츠
// 하의	청바지
// 겉옷	긴 코트


// [["yellowhat", "headgear"], ["bluesunglasses", "eyewear"], ["green_turban", "headgear"]]	5
// [["crowmask", "face"], ["bluesunglasses", "face"], ["smoky_makeup", "face"]]	3