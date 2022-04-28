
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BignumCreate {

    public static void main(String... args) {
        String number = "1231234";
        int k = 3;
        solution(number, k);
    }

    public static String solution(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();
        Queue<Character> numbers = new LinkedList<>();
        for (int i = 0; i < number.length(); i++) numbers.add(number.charAt(i));
        while (!numbers.isEmpty()) {
            if (!stack.isEmpty() && stack.peek() < numbers.peek() && k-- > 0) {
                stack.pop();
            }
            stack.push(numbers.poll());
            stack.stream().forEach(e->System.out.print(e+","));
            System.out.println("");
        }
        for(int i=0; i<result.length; i++){
            result[i]=stack.get(i);
        }
        System.out.println(new String(result));
        return new String(result);
    }

    public static String solution2(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
      
        }
        for (int i=0; i<result.length; i++) {
            result[i] = stack.get(i);
        }
        System.out.println(new String(result));
        return new String(result);
    }

    // 재귀 실패, 시간초과
    public static void recursive(String number, int k, List<String> list, int index, int count, String answer) {
        if (count == k) {
            list.add(answer);
        }

        for (int i = index; i < number.length(); i++) {
            answer += number.charAt(i);
            recursive(number, k, list, i + 1, count + 1, answer);
            answer = answer.substring(0, answer.length() - 1);
        }
    }
}
