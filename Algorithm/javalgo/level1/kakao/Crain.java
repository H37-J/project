package kakao;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Crain {

    // board moves result
    // [[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]]
    // [1,5,3,5,1,2,1,4] 4

    public static void main(String[] args) {
        int[][] board = { { 0, 0, 0, 1, 1 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
                { 3, 5, 1, 3, 1 } };
        int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };

        solution(board, moves);
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        List<Stack<Integer>> boxes = new ArrayList<Stack<Integer>>(board.length);
        Stack<Integer> box = new Stack<>();
        Stack<Integer> baguni = new Stack<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                box.add(board[i][j]);
            }
            boxes.add(box);
            box = new Stack<>();
        }
        
        for (int value : moves) {
    
            if(boxes.get(value-1).peek()==0) continue; 
            if (!baguni.isEmpty()) {
                if (baguni.peek() == boxes.get(value-1).peek()) {
                    baguni.pop();
                    boxes.get(value-1).pop();
                    answer+=2;
                    continue;
                }
            }
            baguni.add(boxes.get(value-1).pop());
        }

        return answer;
    }
}
