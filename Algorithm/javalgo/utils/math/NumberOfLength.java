package math;

public class NumberOfLength {
    public static void main(String[] args) {
        int[] numbers = { 0, 12, 123, 1234, -12345, 123456, 1234567, 12345678, 123456789 };
        for (int i = 0; i < numbers.length; ++i) {
            assert numberOfDigitsFaster(numbers[i]) == i + 1;
            assert numberOfDigitsRecursion(numbers[i]) == i + 1;
        }
    }

    private static int numberOfDigitsFaster(int number){
        return number < 0 ? (-number + "").length() : (number + "").length();
    }

    private static int numberOfDigitsRecursion(int number){
        return number / 10 == 0 ? 1 : 1+ numberOfDigitsRecursion(number / 10);
    }
}
