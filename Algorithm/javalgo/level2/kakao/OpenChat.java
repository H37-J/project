package kakao;
import java.util.*;
public class OpenChat {
    
    public static void main(String... args){
        String[] record={"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        solution(record);
    }

    public static String[] solution(String[] record){
        String command;
        HashMap<String,String> name=new HashMap<>();
        ArrayList<String> answers=new ArrayList<>();

        for(int i=0; i<record.length; i++){
            String[] str=record[i].split(" ");
            if(str.length < 3) continue; //Leave일때 제외
            name.put(str[1],str[2]);
        }

        for(int i=0; i<record.length; i++){
            String[] str=record[i].split(" ");
            String user=name.get(str[1]);
            if(str[0].equals("Change")) continue;
            if(str[0].equals("Enter")){ 
                command=user+"님이 들어왔습니다.";
                answers.add(command);
            }else if(str[0].equals("Leave")){
                command=user+"님이 나갔습니다.";
                answers.add(command);
            }
        }

        return answers.stream().toArray(String[]::new);
    }


}











// record	result
// ["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]	
// ["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]