import java.util.ArrayList;


public class Eng {
   
    public static void main(String... args){
        int n=2;
        String[] words={"hello", "one", "even", "never", "now", "world", "draw"};
        solution(n,words);
    }

    public static int[] solution(int n, String[] words) {
        ArrayList<String> list=new ArrayList<String>();
        int num=0;
        for(int i=1; i<words.length; i++){
            list.add(words[i-1]);
            if(words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0) || list.contains(words[i])){
                num=i+1;
                break;
            }
        }
        int person = num % n;
        int count = num / n;
        if(num % n > 0) count++;
        if(num % n == 0) person=n;
        if(num==0) person=0;
        int[] answer={person,count};
        return answer;
    }
}


// n	words	result
// 3	["tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"]	[3,3]
// 5	["hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"]	[0,0]
// 2	["hello", "one", "even", "never", "now", "world", "draw"]	[1,3]
