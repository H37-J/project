import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class SortUtils {
    
    public static void main(String... args){

    }

    public static void sort(Integer[] numbers) {
        String answer = "";
        Comparator<String> comp = (e1, e2) -> {
            for (int i = 0; i < e2.length(); i++) {
                if (e1.charAt(i) < e2.charAt(i))
                    return 1;
                else if (e1.charAt(i) == e2.charAt(i)){
                    if(e1.length() > e2.length()) return 1;
                    else if(e1.length() < e2.length()) return -1;
                    else continue;
                }
                else
                    return -1;
            }
            return 0;
        };
        String[] str = Stream.of(numbers).map(String::valueOf).sorted(comp).toArray(String[]::new);
        System.out.println(Arrays.toString(str));
    }
}
