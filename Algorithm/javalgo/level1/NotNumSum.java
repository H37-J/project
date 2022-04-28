public class NotNumSum {
    // numbers	result
    // [1,2,3,4,6,7,8,0]	14
    // [5,8,4,0,6,7,9]	6
    public static void main(String... args){
        int[] numbers={1,2,3,4,6,7,8,0};
        System.out.println(solution(numbers));
    }

    public static int solution(int[] numbers){
        int answer=45;
        for(int num : numbers){
            answer-=num;
        }
        return answer;
    }
}
