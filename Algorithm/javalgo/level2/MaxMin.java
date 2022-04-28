import java.util.Arrays;

public class MaxMin {
//     s	return
// "1 2 3 4"	"1 4"
// "-1 -2 -3 -4"	"-4 -1"
// "-1 -1"	"-1 -1"
    public static void main(String... args){
        String str="-1 -2 -3 -4";
        String answer=solution(str);
        System.out.println(answer);
    }

    public static String solution(String str){
        String answer="";
        String[] str_list=str.split(" ");
        int[] arr=new int[str_list.length];

        for(int i=0; i<str_list.length; i++){
            arr[i]=Integer.parseInt(str_list[i]);
        }

        Arrays.sort(arr);

        return answer+=Integer.toString(arr[0])+" "+Integer.toString(arr[arr.length-1]);
    }
}
