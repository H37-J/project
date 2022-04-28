package string;

public class toLowerCase {
    
    public static void main(String[] args) {
        String[] strings = {"ABC", "ABC123", "abcABC", "abc123ABC"};
        for (String s : strings) {
            assert toLowerCases(s).equals(s.toLowerCase());
        }
    }

    public static String toLowerCases(String s){
        char[] values = s.toCharArray();
        for(int i = 0; i < values.length; i++){
            if (Character.isLetter(values[i]) && Character.isUpperCase(values[i])){
                values[i] = Character.toLowerCase(values[i]);
            }
        }
        return new String(values);
    }
}
