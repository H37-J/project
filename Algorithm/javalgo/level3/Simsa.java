import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Simsa {

    public static void main(String... args) {
        int n = 6;
        int[] times = { 7,10,3,1,2,5 };
        solution(n,times);

    }


    public static int solution(int n, int[] times) {
        int count = 0;
        int time = 0;
        int index=0;
        int[] nums = new int[times.length];
        Arrays.fill(nums,0);

        while (count != n) {
            index = getMin(times,nums);
            nums[index] += times[index];
            count++;
            System.out.println(Arrays.toString(nums));
        }
        time=nums[index];
        System.out.println(time);
        return time;
    }

    public static int getMin(int[] times,int[] nums) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < times.length; i++) {
            if (min > times[i] + nums[i]) {
                min = times[i] + nums[i];
                index = i;
            }
        }
        return index;
    }
}

// n times return
// 6 [7, 10] 28