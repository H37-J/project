package math;

public class SumofDigit {

    public static void main(String[] args){
        System.out.println(sumOfDigitRecursion(12345));
    }
    
    public static int sumOfDigitRecursion(int number){
        number = number < 0 ? -number : number;
        return number < 10 ? number : number % 10 + sumOfDigitRecursion(number/10);
    }

    public static int sumOfDigits(int number){
        number = number < 0 ? -number : number;
        int sum=0;
        while(number!=0){
            sum+=number%10;
            number/=10;
        }
        return sum;
    }
}
