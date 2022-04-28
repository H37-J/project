import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class IntegetDesc {
    static String res;
    public static void main(String... args){
        int n=88989874;
        System.out.println(reverseInt(n));
    }

    public static long solution(long n){
        Character[] chars=String.valueOf(n).chars().mapToObj(c->(char)c).toArray(Character[]::new);
        Arrays.sort(chars,Collections.reverseOrder());
        return Integer.parseInt(Arrays.stream(chars).map(String::valueOf).collect(Collectors.joining()));
    }

    public static int reverseInt(int n){
        res = "";
        Integer.toString(n).chars().sorted().forEach(c -> res = Character.valueOf((char)c) + res);
        return Integer.parseInt(res);
    }
}
