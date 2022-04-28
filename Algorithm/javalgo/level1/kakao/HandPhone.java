package kakao;

import java.util.HashMap;

public class HandPhone {
    
//     numbers	hand	result
// [1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5]	"right"	"LRLLLRLLRRL"
// [7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2]	"left"	"LRLLRRLLLRR"
// [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]	"right"	"LLRLLRLLRL"

    public static void main(String... args){
        int[] numbers={1,2,3,4,5,6,7,8,9,0};
        String hand="right";

        solution(numbers,hand);
    }

    public static String solution(int[] numbers, String hand){
        String answer="";
        HashMap<String,Integer> hands=new HashMap<>();
        hands.put("left",0);
        hands.put("right",0);
        int[][] keys=new int[10][10];

        keys[1][2]=1;
        keys[1][5]=2;
        keys[1][8]=3;
        keys[1][0]=4;

        keys[2][2]=0;
        keys[2][5]=1;
        keys[2][8]=2;
        keys[2][0]=3;

        keys[4][2]=2;
        keys[4][5]=1;
        keys[4][8]=2;
        keys[4][0]=3;

        keys[5][2]=1;
        keys[5][5]=0;
        keys[5][8]=1;
        keys[5][0]=2;

        keys[7][2]=3;
        keys[7][5]=2;
        keys[7][8]=1;
        keys[7][0]=2;

        keys[8][2]=2;
        keys[8][5]=1;
        keys[8][8]=0;
        keys[8][0]=1;

        keys[0][2]=3;
        keys[0][5]=2;
        keys[0][8]=1;
        keys[0][0]=0;

        keys[3][2]=1;
        keys[3][5]=2;
        keys[3][8]=3;
        keys[3][0]=4;

        keys[6][2]=2;
        keys[6][5]=1;
        keys[6][8]=2;
        keys[6][0]=3;

        keys[9][2]=3;
        keys[9][5]=2;
        keys[9][8]=1;
        keys[9][0]=2;


        for(int i=0; i<numbers.length; i++){      
            String str=checkClick(numbers[i], hand, keys,hands);
            answer+=str;
        }

        return answer;
    }

    public static String checkClick(int number,String hand,int[][] keys,HashMap<String,Integer> hands){
        if(number == 1 || number == 4 || number == 7){
            hands.put("left",number);
            return "L";
        }
        else if(number == 3 || number == 6 || number == 9){
            hands.put("right",number);
            return "R";
        }
        else{
            if(keys[hands.get("left")][number] == keys[hands.get("right")][number] && hand.equals("left")){
                hands.put("left",number);
                return "L";
            } 
            else if(keys[hands.get("left")][number] == keys[hands.get("right")][number] && hand.equals("right")){
                hands.put("right",number);
                return "R";
            } 
            else if(keys[hands.get("left")][number] < keys[hands.get("right")][number]){
                hands.put("left",number);
                return "L";
            }
            else if(keys[hands.get("left")][number] > keys[hands.get("right")][number]){
                hands.put("right",number);
                return "R";
            }
            else{
                return "";
            }
        }
    }


}
