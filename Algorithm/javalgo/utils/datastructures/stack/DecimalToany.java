package datastructures.stack;

import java.util.Stack;

public class DecimalToany {
    
    private static String convert(int number,int radix){
        if(radix < 2 || radix > 16){
            throw new ArithmeticException(String.format("Invalid Input -> number:%d,radix:%d",number,radix));
        }
        char[] tables = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
        };
        Stack<Character> bits = new Stack<>();
        do{
            bits.push(tables[number % radix]);
            number = number / radix;
        }while(number != 0);
        
        StringBuilder result = new StringBuilder();
        while(!bits.isEmpty()){
            result.append(bits.pop());
        }
        return result.toString();
    }
}
