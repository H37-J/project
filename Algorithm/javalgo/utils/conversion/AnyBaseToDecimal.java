package conversion;

public class AnyBaseToDecimal {
    public static void main(String[] args) {
        assert convertToDecimal("1010", 2) == Integer.valueOf("1010", 2);
        assert convertToDecimal("777", 8) == Integer.valueOf("777", 8);
        assert convertToDecimal("999", 10) == Integer.valueOf("999", 10);
        assert convertToDecimal("ABCDEF", 16) == Integer.valueOf("ABCDEF", 16);
        assert convertToDecimal("XYZ", 36) == Integer.valueOf("XYZ", 36);

        System.out.println((int)'1');

        //'0'은 48 '1'은 49
    }


    public static int convertToDecimal(String s,int radix){
        int num=0;
        int pow=1;

        for(int i = s.length() - 1; i >= 0; i--){
            int digit = valOfChar(s.charAt(i));
            if(digit >= radix){
                throw new NumberFormatException("For input String" + s);
            }
            num += valOfChar(s.charAt(i)) * pow;
            pow *= radix; //2 4 8 16 (2진수일때)
        }
        return num;
    }

    public static int valOfChar(char c){
        if(!(Character.isUpperCase(c) || Character.isDigit(c))){
            throw new NumberFormatException("invalid character: "+c);
        }
        return Character.isDigit(c) ? c -'0' : c - 'A'+10;
    }
}
