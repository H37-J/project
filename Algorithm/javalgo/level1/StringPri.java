public class StringPri {
    
//     s	return
// "a234"	false
// "1234"	true
    public static void main(String... args){
        String str="1234";
        System.out.println(solution(str));
    }

    public static boolean solution(String str){
        if(str.length()!=4) return false;
        
        for(int i=0; i<str.length(); i++){
            if(!Character.isDigit(str.charAt(i))) return false;
        }
        return true;
    }
}
