public class ArrayAverage {
    
    public static void main(String... args){
        int[] nums={1,2,3,4};
        System.out.println(solution(nums));
    }

    public static double solution(int[] nums){
        double sum=0;
        for(int num : nums){
            sum+=num;
        }
        return sum/nums.length;
    }
}
