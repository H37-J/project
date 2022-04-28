package datastructures.stack;

import java.util.Stack;

public class Bracket {

    public static boolean isPaired(char left,char right){
        char[][] pariedBrackets={
            {'(',')'},
            {'[',']'},
            {'{','}'},
            {'<','>'},
        };

        for(char[] pariedBracket:pariedBrackets){
            if(pariedBracket[0]==left && pariedBracket[1]==right){
                return true;
            }
        }

        return false;
    }

    public static boolean isBalanced(String brackets){
        if (brackets == null) {
            throw new IllegalArgumentException("brackets is null");
          }
          Stack<Character> bracketsStack = new Stack<>();
          for (char bracket : brackets.toCharArray()) {
            switch (bracket) {
              case '(':
              case '[':
              case '{':
                bracketsStack.push(bracket);
                break;
              case ')':
              case ']':
              case '}':
                if (bracketsStack.isEmpty() || !isPaired(bracketsStack.pop(), bracket)) {
                  return false;
                }
                break;
              default: /* other character is invalid */
                return false;
            }
          }
          return bracketsStack.isEmpty();
    }
    
}
