package string;

import java.util.HashMap;
import java.util.Map;

public class CheckAnagram {
    
    public static void main(String... args){
        assert isAnagrams("Silent","Listen");
    }

    public static boolean isAnagrams(String s1,String s2){
        int l1=s1.length();
        int l2=s2.length();
        s1=s1.toLowerCase();
        s2=s2.toLowerCase();
        Map<Character,Integer> charApparances = new HashMap<>();

        for(int i = 0; i < l1; i++){
            char c = s1.charAt(i);
            int numOfAppearance = charApparances.getOrDefault(c, 0);
            charApparances.put(c, numOfAppearance + 1);
        }

        for(int i = 0; i < l2; i++){
            char c = s2.charAt(i);
            if(!charApparances.containsKey(c)){
                return false;
            }
            charApparances.put(c, charApparances.get(c)-1);
        }

        for(int cnt : charApparances.values()){
            if(cnt != 0){
                return false;
            }
        }
        return true;

    }
}
