package string;

public class CharToString {
    
    public static void main(String... args) {
        char[] chars = {'a','b','c'};
    }

    public static void chartoString(char[] chars) {
        String str = String.valueOf(chars);
        System.out.println(str);
    }

    public static void StringtoChars(String str) {
        char[] chars = str.toCharArray();
        for(char c : chars){
            System.out.println(c);
        }
    }

    public static void StringtoCharahcter(String str) {
        Character[] chars = str.chars().mapToObj(c -> (char)c).toArray(Character[]::new);
    }
}
