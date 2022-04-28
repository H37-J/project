import java.util.Stack;

public class StackBracket {
    // s answer
    // "()()" true
    // "(())()" true
    // ")()(" false
    // "(()(" false
    public static void main(String... args) {
        String str ="(())";
        boolean answer=solution(str);
        System.out.println(answer);
    }

    public static boolean solution(String str){
        Stack<String> stack=new Stack<>();

        for(int i=0; i<str.length(); i++){
            stack.push(String.valueOf(str.charAt(i)));
        }
        
        int count=stack.size()/2;
        String bracket=stack.pop();
        if(bracket.equals("(")) return false;
        if(stack.get(0).equals(")")) return false;
        int index=stack.size()-1;
    
        while(!stack.isEmpty()){
            if(index < 0) break;
            if(!bracket.equals(stack.get(index))){
                count--;
                stack.remove(index);
                if(stack.isEmpty()) break;
                bracket=stack.pop();
                index=stack.size()-1;
            }
            else{
                index--;
            }
        }

        return count == 0 ? true : false;
    }
}
