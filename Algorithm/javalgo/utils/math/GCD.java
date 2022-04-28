package math;

public class GCD {
    
    private static int gcd(int num1, int num2){
        if(num1 < 0 || num2 < 0){
            throw new ArithmeticException();
        }

        if(num1==0 || num2==0){
            return Math.abs(num1-num2);
        }

        while(num1 % num2 !=0){
            int reminder=num1 % num2;
            num1=num2;
            num2=reminder;
        }
        return num2;
    }

    public static int gcd(int[] number){
        int result=number[0];
        for(int i=1; i<number.length; i++){
            result=gcd(result,number[i]);
        }
        return result;
    }

    //재귀방식
    public static int gcdRecursion(int a, int b) {

        if (a < 0 || b < 0) {
          throw new ArithmeticException();
        }
    
        if (a == 0 || b == 0) {
          return Math.abs(a - b);
        }
    
        if (a % b == 0) {
          return b;
        } else {
          return gcdRecursion(b, a % b);
        }
      }

    public static void main(String[] args){
        int[] myIntArray={4,16,32};

        System.out.println(gcd(myIntArray));
    }
}
