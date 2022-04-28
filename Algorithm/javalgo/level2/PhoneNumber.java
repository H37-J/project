import java.util.Arrays;
import java.util.Comparator;

public class PhoneNumber {
    
    public static void main(String... args){
        String[] phone_book={"119", "11","1","10","2","20","19"};
        boolean result=solution2(phone_book);
        System.out.println(result);
    }

    public static boolean solution2(String[] phoneBook) { 
        Arrays.sort(phoneBook);
        for(int i=0; i<phoneBook.length; i++){
            if(phoneBook[i+1].startsWith(phoneBook[i])) return false;
        }
        return true;
    }


    public static boolean solution(String[] phone_book){
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String e1,String e2){
                return Integer.compare(e1.length(),e2.length());
            }
        };
        Arrays.sort(phone_book,comp);
        for(int i=0; i<phone_book.length; i++){
            for(int j=i+1; j<phone_book.length; j++){
                if(startWith(phone_book[i], phone_book[j])) return false;
            }
        }
        return true;
    }

    public static boolean startWith(String s1,String s2){
        if(s1.length()==s2.length()) return false;
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i)!=s2.charAt(i)) return false;
        }
        return true;
    }
}


// phone_book	return
// ["119", "97674223", "1195524421"]	false
// ["123","456","789"]	true
// ["12","123","1235","567","88"]	false