import java.util.Stack;

public class StringJjak {
    public static void main(String... args){
        String s="baabcd";
        int result=solution2(s);
        System.out.println(result);
    }

    public static int solution2(String s){
        if(s==null || s.length() % 2 == 1) return 0;

        Stack<Character> stack=new Stack<>();
        stack.add(s.charAt(0));
        for(int i=1; i<s.length(); i++){
            if(!stack.isEmpty() && stack.peek()==s.charAt(i)) stack.pop();
            else stack.add(s.charAt(i));
        }

        return stack.size() == 0 ? 1 : 0;
    }

    public static int solution(String s){
        if(s==null || s.length() % 2 == 1) return 0;
        
        int start=0;
        while(start < s.length()){
            int index = s.indexOf(s.charAt(start),start+1); if(index==-1) break;
            int end = start+1;
            if(s.charAt(start) == s.charAt(end)){  
                s=s.substring(0,start)+s.substring(end+1); 
                start=0; 
            }
            else start++;
            System.out.println(s);
        }

        return s.length()==0 ? 1 : 0;
    }

}


// s	result
// baabaa	1
// cdcd	0