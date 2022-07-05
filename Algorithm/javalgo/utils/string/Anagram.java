package string;

import java.util.Arrays;
import java.util.HashMap;

public class Anagram {
    public static void main(String arags[]){
        String first = "deal";
        String second = "lead";
        System.out.println(app1(first,second));
    }

    static boolean app1(String s,String t){
        if(s.length() != t.length()) return false;  
        char c[] = s.toCharArray();
        char d[] = t.toCharArray();
        Arrays.sort(c);
        Arrays.sort(d);

        if(Arrays.equals(c,d)) return true;
        else return false;
    }

    static boolean app2(String s,String t){
        if(s.length() != t.length()) return false;
        HashMap<Character,Integer> nm = new HashMap<>();
        HashMap<Character,Integer> kk = new HashMap<>();
        for(char c : s.toCharArray()) nm.put(c, nm.getOrDefault(c,0) + 1);
        for(char c : t.toCharArray()) kk.put(c, kk.getOrDefault(c,0) + 1);
        for(char c : nm.keySet()){
            if(!nm.get(c).equals(kk.get(c))) return false;
        }
        return true;
    }
}
