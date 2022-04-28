public class DivisorSum {
    // left	right	result
    // 13	17	43
    // 24	27	52 

    public static void main(String... args){
        int left=13;
        int right=17;
        solution(left,right);
    }

    public static int solution(int left,int right){
        int count;
        int sum=0;
        for(int num=left; num<=right; num++){
            count=0;
            for(int i=1; i<=num; i++){
                if(num % i == 0){
                    count++;
                }
            }
            if(count % 2 == 0) sum+=num;
            else sum-=num;
        }
        return sum;
    }
}
