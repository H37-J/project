package math;

public class PrimeCheck {

    public static void main(String[] args){
        System.out.println(isPrime(8));
        System.out.println(isPrime(17));
        System.out.println(isPrime(22));
        System.out.println(isPrime(23));
        System.out.println(Math.sqrt(23));
    }
    
    public static boolean isPrime(int n){
        if(n == 2){
            return true;
        }
        if(n < 2 || n % 2==0){
            return false;
        }
        for(int i = 3, limit = (int)Math.sqrt(n); i<=limit; i+=2){
            if(n % i ==0){
                return false;
            }
        }
        return true;
    }

    //짝수는 소수가 아니다
    //sqrt범위 내에서 나뉘어지면 소수가 아니다
}
