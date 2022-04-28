public class YaksooSum {
    
//     n	return
// 12	28
// 5	6
    
    public static void main(String... args){
        int n=12;
        System.out.println(solution(n));
    }

    public static int solution(int n){
        int sum=0;
        for(int i=1; i<=n; i++){
            if(n % i==0){
                sum+=i;
            }
        }
        return sum;
    }
}
