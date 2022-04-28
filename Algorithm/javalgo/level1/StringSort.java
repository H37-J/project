import java.util.Arrays;
import java.util.Comparator;

public class StringSort {
    
//     strings	n	return
// ["sun", "bed", "car"]	1	["car", "bed", "sun"]
// ["abce", "abcd", "cdx"]	2	["abcd", "abce", "cdx"]
    public static void main(String... args){
        String[] arr={"sun","bed","car"};
        int index=1;
        stream(arr,index);
        print(stream(arr,index));
    }

    public static String[] solution(String[] arr,int index){
        Arrays.sort(arr,new Comparator<String>() {
            @Override
            public int compare(String s1,String s2){
                if(s1.charAt(index) > s2.charAt(index)) return 1;
                else if(s1.charAt(index) == s2.charAt(index)) return 0;
                else return -1;
            }
        });

        for(String value : arr){
            System.out.println(value);
        }

        return arr;
    }

    public static String[] stream(String[] arr,int index){
        return Arrays.stream(arr).sorted(new Comparator<String>() {
            @Override 
            public int compare(String s1,String s2){
                if(s1.charAt(index) > s2.charAt(index)) return 1;
                else if(s1.charAt(index) == s2.charAt(index)) return 0;
                else return -1;
            }
        }).toArray(String[]::new);
    }

    public static <T> void print(T[] arr){
        for(T value:arr){
            System.out.println(value);
        }
    }
}
