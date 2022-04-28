package math;

public class ParseInteger {
    

    public static int parseInt(String s){
        if(s == null || s.length()==0){
            throw new NumberFormatException("null");
        }
        boolean isNegative = s.charAt(0)=='-';
        boolean isPositive = s.charAt(0)=='+';
        int number = 0;
        for(int i= isNegative ? 1: isPositive ? 1: 0, length = s.length(); i < length; ++i){
            if(!Character.isDigit(s.charAt(i))){
                throw new NumberFormatException("s="+s);
            }
            number = number * 10 + s.charAt(i) - '0';
        }
        return isNegative ? -number : number;
    }
}
