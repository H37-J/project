package dev;

import java.util.Arrays;

public class lotto {
    // lottos win_nums result
    // [44, 1, 0, 0, 31, 25] [31, 10, 45, 1, 6, 19] [3, 5]
    // [0, 0, 0, 0, 0, 0] [38, 19, 20, 40, 15, 25] [1, 6]
    // [45, 4, 35, 20, 3, 9] [20, 9, 3, 45, 4, 35] [1, 1]

//     순위	당첨 내용
// 1	6개 번호가 모두 일치
// 2	5개 번호가 일치
// 3	4개 번호가 일치
// 4	3개 번호가 일치
// 5	2개 번호가 일치
// 6(낙첨)	그 외
    public static void main(String... args) {
        int[] lottos = { 44, 1, 0, 0, 31, 25 };
        int[] win_nums = { 31, 10, 45, 1, 6, 19 };

        System.out.println(Arrays.toString(solution(lottos,win_nums)));
    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] results = new int[2];
        int zero_count = 0;
        int match_count = 0;

        Arrays.sort(lottos);
        Arrays.sort(win_nums);

        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) {
                zero_count++;
                continue;
            }
            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[i] == win_nums[j]) {
                    match_count++;
                    break;
                }
            }
        }

        int max=match_count+zero_count;
        int min=match_count;


        if(max==6) results[0]=1;
        if(max==5) results[0]=2;
        if(max==4) results[0]=3;
        if(max==3) results[0]=4;
        if(max==2) results[0]=5;
        else if(max==1 || max==0) results[0]=6;

        if(min==6) results[1]=1;
        if(min==5) results[1]=2;
        if(min==4) results[1]=3;
        if(min==3) results[1]=4;
        if(min==2) results[1]=5;
        else if(min==1 || min==0) results[1]=6;
        

        return results;
    }
}
