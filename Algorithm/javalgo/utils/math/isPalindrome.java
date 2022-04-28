package math;

public class isPalindrome {
    

    public static boolean isPalindrome(int number){
        if(number < 0){
            throw new IllegalArgumentException(number + "");
        }
        int numberCopy=number;
        int reverseNumber=0;
        while(numberCopy!=0){
            int reminder = number % 10;
            reverseNumber = reverseNumber * 10 + reminder;
            numberCopy /= 10;
        }
        return reverseNumber==number;
    }
}
