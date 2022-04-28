import java.util.Arrays;
import java.util.Comparator;

public class StringDesc {
    // s	return
    // "Zbcdefg"	"gfedcbZ"
    //문자열 내림차순으로 정렬하기 대문자는 소문자보다 작은것으로 간주
    public static void main(String... args){
        String str="Zbcdefg";
    }

    public static String solution(String str){
        String answer="";
        Character[] arr=str.chars().mapToObj(c -> (char)c).toArray(Character[]::new);
        Arrays.sort(arr, new Comparator<Character>() {
            @Override
            public int compare(Character c1,Character c2){
                if(c1 < c2) return 1;
                else if(c1 == c2) return 0;
                else return -1;
            }
        });
        for(Character value : arr){
            answer+=value;
        }
        return answer;
    }
}
