public class Phone {
    
//     phone_number	return
// "01033334444"	"*******4444"
// "027778888"	"*****8888"
    public static void main(String... args){
        String phone_number="01033334444";
        System.out.println(solution(phone_number));
    }

    public static String solution(String phone_number){
        String answer="";
        for(int i=0; i<phone_number.length(); i++){
            if(phone_number.length()-5 >= i){
                answer+="*";
                continue;
            }
            answer+=phone_number.charAt(i);
        }
        return answer;
    }
}
