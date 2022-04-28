

import java.util.*;
import java.util.stream.Stream;

public class ArrayDistinct {
    
    //배열에서 중복 숫자를 제거하는 문제
    public static void main(String[] args){
        int[] arr={4,4,3,3,1};

        // print(stream(arr)); 
        // print(hash(arr));
        print(map(arr));
    }

    //스트림을 이용한 방법
    public static int[] stream(int[] arr){
        return Arrays.stream(arr).distinct().toArray();
    }

    //해쉬의 성질을 이용한 중복제거 방법
    public static Integer[] hash(int[] arr){
        HashSet<Integer> set=new HashSet<>();
        for(int value : arr){
            set.add(value);
        }
        return set.stream().toArray(Integer[]::new);
    }

    //맵을 이용한 방법
    public static Integer[] map(int[] arr){
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int value : arr){
            if(!map.containsKey(value)) map.put(value,1);
            else map.put(value,map.get(value)+1);
        }
        return map.keySet().stream().toArray(Integer[]::new);
    }

    public static void print(int[] arr){
        Arrays.stream(arr).forEach(e->System.out.println(e));
    }

    public static <T>void print(T[] arr){
        Arrays.stream(arr).forEach(e->System.out.println(e));
    }

  


}
