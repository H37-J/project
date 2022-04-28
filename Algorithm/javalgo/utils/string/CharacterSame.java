package string;

public class CharacterSame {
    public static void main(String[] args) {
        assert isAllCharactersSame("");
        assert !isAllCharactersSame("aab");
        assert isAllCharactersSame("aaa");
        assert isAllCharactersSame("11111");
    }

    public static boolean isAllCharactersSame(String s){
        for(int i = 1, length = s.length(); i < length; i++){
            if(s.charAt(0)!=s.charAt(i)){
                return false;
            }
        }

        return true;
    }
}
