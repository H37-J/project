import java.util.Arrays;

public class Maraton {
    
    // 프로그래머스 레벨1 완주선수
//     participant	completion	return
// ["leo", "kiki", "eden"]	["eden", "kiki"]	"leo"
// ["marina", "josipa", "nikola", "vinko", "filipa"]	["josipa", "filipa", "marina", "nikola"]	"vinko"
// ["mislav", "stanko", "mislav", "ana"]	["stanko", "ana", "mislav"]	"mislav"

    public static void main(String[] args){
        String[] participant={"mislav","stanko","mislav","ana"};
        String[] completion={"stanko","ana","mislav"};

        Arrays.sort(participant);
        Arrays.sort(completion);

        System.out.println(Arrays.toString(participant));
        System.out.println(Arrays.toString(completion));
        System.out.println(solution(participant,completion));
    }

    public static String solution(String[] participant, String[] completion){
        Arrays.sort(participant);
        Arrays.sort(completion);
        int n=completion.length;
        String answer="";
        for(int i=0; i<n; i++){
            if(!participant[i].equals(completion[i])){
                answer=participant[i];
                break;
            }
        }
        if(answer.equals("")) answer=participant[participant.length-1]; //마지막일경우
        return answer;
    }
}
