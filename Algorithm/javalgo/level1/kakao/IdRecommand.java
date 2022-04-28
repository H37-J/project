package kakao;

import java.util.ArrayList;

public class IdRecommand {
    // 아이디의 길이는 3자 이상 15자 이하여야 합니다.
    // 아이디는 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 문자만 사용할 수 있습니다.
    // 단, 마침표(.)는 처음과 끝에 사용할 수 없으며 또한 연속으로 사용할 수 없습니다.
    public static void main(String... args) {
        String id = "...!@BaT#*..y.abcdefghijklm";
        System.out.println(solution2(id));
    }

    public static String solution(String id) {
        String answer = "";

        // 특정 특수문자 제거
        String[] match = { "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "{", "}", "[", "]", "+", "=","`","'",":",",","?","/","|","~","<",">" };
        ArrayList<String> match_list = new ArrayList<>();
        for (int i = 0; i < match.length; i++) {
            match_list.add(match[i]);
        }

        for (int i = 0; i < id.length(); i++) {
            if (match_list.contains(String.valueOf(id.charAt(i))))
                answer += "";
            else
                answer += id.charAt(i);
        }

        // 연속 .제거
        int index = -1;
        ArrayList<Integer> index_list = new ArrayList<>();

        while (answer.indexOf('.', index + 1) != -1) {
            index = answer.indexOf('.', index + 1);
            index_list.add(index);
        }

        for (int i = 1; i < index_list.size(); i++) {
            if (index_list.get(i - 1) == index_list.get(i) - 1) {
                index_list.remove(i - 1);
                i--;
            }
        }

        String copy = answer;
        answer = "";

        for (int i = 0; i < copy.length(); i++) {
            if (copy.charAt(i) == '.') {
                for (int j = 0; j < index_list.size(); j++) {
                    if (i == index_list.get(j))
                        answer += copy.charAt(i);
                }
            } else {
                answer += copy.charAt(i);
            }
        }

        // 첫과 끝이 .일시 제거
        if (answer.length() > 0) {
            if (answer.charAt(0) == '.')
                answer = answer.substring(1, answer.length());
            if (answer.length() != 0) {
                if (answer.charAt(answer.length() - 1) == '.')
                    answer = answer.substring(0, answer.length() - 1);
            }
        }

        // 빈 문자열일시 a대입
        if (answer.length() == 0)
            answer = "a";

        copy = "";


        if (answer.length() >= 16) {
            for (int i = 0; i < 15; i++) {
                copy += answer.charAt(i);
              
            }
            answer = copy;
        }

        if (answer.length() > 0) {
            if (answer.charAt(0) == '.')
                answer = answer.substring(1, answer.length());
            if (answer.length() != 0) {
                if (answer.charAt(answer.length() - 1) == '.')
                    answer = answer.substring(0, answer.length() - 1);
            }
        }

        if (answer.length() <= 2) {
            while (true) {
                answer += answer.charAt((answer.length() - 1));
                if (answer.length() == 3)
                    break;
            }
        }

        return answer.toLowerCase();
    }

    public static String solution2(String id){
        String answer="";

        StringBuilder sb = new StringBuilder();

        id=id.toLowerCase();

        id.chars().filter(c -> 'a' <= c && c <= 'z' || '0' <= c && c <= '9' || c == '-' || c == '_' || c == '.').mapToObj(c -> (char) c).forEach(sb::append);

        id=sb.toString();

        while(id.contains("..")) id = id.replace("..", ".");


        if(id.startsWith("."))id = id.substring(1);
        if(id.endsWith(".")) id = id.substring(0,id.length()-1);

        if(id.isEmpty()) id="a";

        if(id.length()>=16) id = id.substring(0, 15);
        if(id.endsWith(".")) id = id.substring(0,id.length()-1);

        if(id.length()<=2) id+=String.valueOf(id.charAt(id.length()-1)).repeat(3-id.length());

        answer=id;
        return answer;
    }
}
