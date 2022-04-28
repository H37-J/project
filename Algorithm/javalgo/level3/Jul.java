import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Jul {
    
    public static void main(String... args){
        int n=3;
        int k=5;
        int[] person=new int[n];
        List<String> answers=new ArrayList<>();



        for(int i=0; i<n; i++){
            person[i]=i+1;
        }

        solution(person,0,0,answers);

       
        answers.stream().forEach(System.out::println);

        String str=answers.get(k-1);
        int[] solution=toIntArray(str);

        System.out.println(Arrays.toString(solution));

    }

    public static void solution(int[] person,int index,int count,List<String> answers){
        if(count==person.length-1){
            String answer="";
            for(int i=0; i<person.length; i++)answer+=Integer.toString(person[i]);
            answers.add(answer);
        }

        for(int i=index; i<person.length; i++){
            swap(person,index,i);
            solution(person,index+1,count+1,answers);
            swap(person,index,i);
        }
    }

    public static int[] toIntArray(String str){
        int[] arr=new int[str.length()];

        for(int i=0; i<str.length(); i++){
            arr[i]=(int)str.charAt(i)-'0';
        }

        return arr;
    }



    public static void swap(int[] person,int index,int i){
        int temp=person[index];
        person[index]=person[i];
        person[i]=temp;
    }


}
