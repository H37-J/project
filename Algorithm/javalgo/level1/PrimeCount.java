public class PrimeCount {
    public static void main(String... args){
        int num=10;
        solution(23);
    }

    public static int solution(int num){
        int count=num-1;
        for(int i=3; i<=num; i++){
            if(i % 2 == 0){
                count--;
                continue;
            }

            for(int j=3; j<=(int)Math.sqrt(i); j+=2){
                if(i % j == 0) {
                    count--; 
                    break;
                }
            }
        }

        return count;
    }
}
