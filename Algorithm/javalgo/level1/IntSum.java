public class IntSum {
    
    public static void main(String... args){
        int num=987;
        int sum=0;
        System.out.println(solution(num,sum));
    }

    public static int solution(int num,int sum){
        sum+=num % 10;
        return num / 10 == 0 ? sum : solution(num/10,sum);
    }
}
