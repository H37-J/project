package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RemoveDuplicateFromString {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inpStr = br.readLine();

        System.out.println("Actual string is: " + inpStr);
        System.out.println("String after removing duplicates: " + removeDuplicate(inpStr));

        br.close();
    }

    public static String removeDuplicate(String s) {
        if(s==null || s.isEmpty()){
            return s;
        }

        StringBuilder sb=new StringBuilder();
        int n=s.length();

        for(int i=0; i < n; i++){
            if(sb.toString().indexOf(s.charAt(i))==-1){
                sb.append(String.valueOf(s.charAt(i)));
            }
        }

        return sb.toString();

    }
}
