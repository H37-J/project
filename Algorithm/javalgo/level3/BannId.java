import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BannId {
    
    public static void main(String... args){
        
        String[] user_id={"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] bannd_id={"fr*d*", "*rodo", "******", "******"};
        solution(user_id,bannd_id);
    }

    public static void solution(String[] user_id,String[] bannd_id){
        HashMap<String,ArrayList<String>> ids=new HashMap<>();
        for(int i=0; i<bannd_id.length; i++){
            String ban=bannd_id[i];
            if(ids.containsKey(ban)) continue;
            matchAdd(ban,user_id,ids);
        }
        ids.forEach((k,v)->System.out.println(k+","+v));

        for(Map.Entry<String,ArrayList<String>> entry : ids.entrySet()){
            ArrayList<String> id = entry.getValue();
        }
    }

    public static void getResult(String[] bannd_id,HashMap<String,ArrayList<String>> ids){
        for(int i=0; i<bannd_id.length; i++){
            ArrayList<String> id = ids.get(bannd_id[i]);
        }
    }

    public static void matchAdd(String ban,String[] user_id,HashMap<String,ArrayList<String>> ids){
        ArrayList<String> id=new ArrayList<>();
        for(int i=0; i<user_id.length; i++){
            if(matchCheck(ban, user_id[i])){
                if(ids.containsKey(ban)) id=ids.get(ban);
                else id = new ArrayList<>();
                id.add(user_id[i]);
                ids.put(ban,id);
            }
        }
    }

    public static boolean matchCheck(String ban,String user){
        if(ban.length()!=user.length()) return false;
        for(int i=0; i<ban.length(); i++){
            if(ban.charAt(i) == '*') continue;
            if(ban.charAt(i) != user.charAt(i)) return false;
        }
        return true;
    }
}



// user_id	banned_id	result
// ["frodo", "fradi", "crodo", "abc123", "frodoc"]	["fr*d*", "abc1**"]	2
// ["frodo", "fradi", "crodo", "abc123", "frodoc"]	["*rodo", "*rodo", "******"]	2
// ["frodo", "fradi", "crodo", "abc123", "frodoc"]	["fr*d*", "*rodo", "******", "******"]	3
