package kakao;

public class StringZip {
    
    public static void main(String... args){
        String str="aabbaccc";
        String answer="";
        int min=Integer.MAX_VALUE;
        solution(str);
        recur(str,answer,min,1,1,0,0);
    }

    public static void recur(String str,String answer,int min,int count,int index,int start,int end){
        if(start > str.length()) return;

        end=Math.min(end+index,str.length());
        String temp=str.substring(start,end+index);
        String next=str.substring(start+index, end);
        if(temp.equals(next)) count++;
        else answer+=temp;
        
    }

    public static int solution(String str){
        int count=1;
        int min=str.length();
        String answer="";

        for(int i=1; i<str.length(); i++){
            String temp=str.substring(0,i);
            for(int start=i; start<str.length(); start+=i){
                int end=Math.min(start+i, str.length());
                if(temp.equals(str.substring(start,end))){
                    count++;
                    continue;
                }else{
                    if(count!=1)answer+=Integer.toString(count)+temp;
                    else answer+=temp;
                    temp=str.substring(start,end);
                    count=1;
                }
            }
            if(count!=1)answer+=Integer.toString(count)+temp;
            else answer+=temp;
            count=1;
            if(min > answer.length()) min=answer.length();
            answer="";
        }

        return min;
    }
}
