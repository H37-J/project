import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class studyString {
    //문자열
    
    public static void main(String[] args){
        String removeStr = "apple";
        removeDuplicate(removeStr);

        String[] arr = {"a","b"};

        String sortStr = "cab";
        sort(sortStr);

        String toChar = "abc";
        toChars(toChar);
    }

    public static String removeDuplicate(String str){
        String[] arr = str.split("");
        //Set<String> set = Arrays.stream(arr).collect(Collectors.toSet());
        String[] result = Arrays.stream(arr).distinct().map(s -> s.toUpperCase()).toArray(String[]::new);
        //System.out.println(Arrays.toString(result));
        String s = String.join("", result);
        //System.out.println(s);
        //Arrays.stream(result).forEach(System.out::println);
        return s;
    }

    public static String sort(String str){
        String[] arr = str.split("");
        String result = Arrays.stream(arr).sorted((e1, e2) -> e2.compareTo(e1)).collect(Collectors.joining());
        //System.out.println(result);
        return result;
    }

    public static int[] toChars(String str){
        int[] arr = str.chars().toArray();
        for(int a : arr){
            System.out.println(a);
        }
        return arr;
    }

}
