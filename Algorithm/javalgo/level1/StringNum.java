public class StringNum {

    public static void main(String... args) {
        String str = "a1234";
        boolean check=solution(str);
        System.out.println(check);
    }

    public static boolean solution(String str) {
        for (int i = 0; i < str.length(); i++) {
            if(!Character.isDigit(str.charAt(i))) return false;
        }
        return true;
    }
}
