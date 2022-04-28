import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;



public class ReverseInt {

    public static void main(String... args) {
        long n = 12345;
        solution(n);
    }

    public static Integer[] solution(long n){
        ArrayList<Integer> list=new ArrayList<>();
        do{
            list.add((int)n%10);
            n=n/10;
        }while(n != 0);
        return list.stream().toArray(Integer[]::new);
    }

    public static int[] sum(int n) {
        String str = Integer.toString(n);
        Character[] chars = str.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
        Arrays.sort(chars, new Comparator<Character>() {
            @Override
            public int compare(Character c1, Character c2) {
                if (c1 < c2)
                    return 1;
                else if (c1 == c2)
                    return 0;
                else
                    return -1;
            }
        });
        int[] arr=new int[chars.length];
        for(int i=0; i<chars.length; i++){
            arr[i]=chars[i]-'0';
        }
        return arr;
    }
}
