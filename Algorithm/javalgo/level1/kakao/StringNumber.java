package kakao;

public class StringNumber {
    
//     s	result
// "one4seveneight"	1478
// "23four5six7"	234567
// "2three45sixseven"	234567
// "123"	123

    public static void main(String... args){
        String s="23four5six7";

        System.out.println(solution(s));
    }

    public static int solution(String s){
        int answer;

        while(s.contains("zero")) s = s.replace("zero","0");
        while(s.contains("one")) s = s.replace("one","1");
        while(s.contains("two")) s = s.replace("two","2");
        while(s.contains("three")) s = s.replace("three","3");
        while(s.contains("four")) s = s.replace("four","4");
        while(s.contains("five")) s = s.replace("five","5");
        while(s.contains("six")) s = s.replace("six","6");
        while(s.contains("seven")) s = s.replace("seven","7");
        while(s.contains("eight")) s = s.replace("eight","8");
        while(s.contains("nine")) s = s.replace("nine","9");

        answer=Integer.parseInt(s);

        return answer;
    } 
}
