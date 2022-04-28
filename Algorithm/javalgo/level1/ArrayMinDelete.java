import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayMinDelete {
   
    public static void main(String... args){
        int[] arr={3,2,4,2,1,2,3,5,6,};
        solution(arr);
    }

    public static Integer[] s(int[] arr){
        Integer[] integers=Arrays.stream(arr).mapToObj(e->(Integer)e).toArray(Integer[]::new);
        Arrays.sort(integers,Collections.reverseOrder());
        Integer[] answer=Arrays.copyOfRange(integers, 0, arr.length-1);
        if(answer.length==0) {answer=new Integer[1]; answer[0]=-1;}
        System.out.println(Arrays.toString(answer));
        return answer;
    }

    public static Integer[] solution(int[] arr){
        ArrayList<Integer> list=new ArrayList<>();
        int index=-1;
        int min=Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++){
            if(arr[i]<min){
                min=arr[i];
                index=i;
            }
        }

        for(int i=0; i<arr.length; i++){
            if(i==index) continue;
            list.add(arr[i]);
        }

        if(list.size()==0) list.add(-1);

        return list.stream().toArray(Integer[]::new);
    }
}
