package math;

public class AliqutoSum {
    
    public static void main(String[] args){
        System.out.println(aliqutoSum(19));
    }

    public static int aliqutoSum(int number){
        int sum=0;
        for(int i=1, limit= number/2; i<=limit; i++){
            if(number % i==0){
                sum+=i;
            }
        }
        return sum;
    }
}
