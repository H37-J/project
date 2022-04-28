public class Palindrome {
    
    public static void main(String... args){
        String s="cabccbaa";
        solution(s);
    }

    public static int solution(String s){   
        int answer=1;
        String str="";
        
        for(int i=0; i<s.length(); i++){
            str=s.substring(i,s.length());
            if(str.length() <= answer) break;
            while(str.length()!=0){
                if(checkPalindrome(str) && answer < str.length()){
                    answer = str.length();
                    break;
                }
                else str = lastRemove(str);
            }
        }
        System.out.println(answer);

        return answer;
    }

    public static boolean checkPalindrome(String s){
        while(s.length()!=0 && s.length()!=1){
            if(s.charAt(0)==s.charAt(s.length()-1)) s = substring(s);
            else return false;
        }
        return true;
    }

    public static boolean isPalindrome(String s){
        return (s == null) || ( s.length() <= 1) || s.equals(new StringBuilder(s).reverse().toString());
    }

    public static String substring(String s){
        s = s.substring(1,s.length()-1);
        return s;
    }

    public static String lastRemove(String s){
        s = s.substring(0,s.length()-1);
        return s;
    }
}



// s	answer
// "abcdcba"	7
// "abacde"	3