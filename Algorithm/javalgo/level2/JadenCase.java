public class JadenCase {
//     입출력 예
// s	return
// "3people unFollowed me"	"3people Unfollowed Me"
// "for the last week"	"For The Last Week"

    public static void main(String... args){
        String str="1aa fas test T33";
        solution(str);
    }

    public static String solution(String str){
        String answer="";
        String[] list=str.split(" ");
        if(String.valueOf(str.charAt(str.length()-1)).equals(" ")) list[list.length-1]+=" ";
        for(int i=0; i<list.length; i++){
            for(int j=0; j<list[i].length(); j++){
                if(j==0 && !Character.isDigit(list[i].charAt(j))) answer+=String.valueOf(list[i].charAt(j)).toUpperCase();
                else answer+=String.valueOf(list[i].charAt(j)).toLowerCase();
            }
            if(i!=list.length-1) {answer+=" "; System.out.println("gong");}
        }


      

        return answer;
    }
}
