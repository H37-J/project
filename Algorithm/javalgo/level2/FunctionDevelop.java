import java.util.ArrayList;

public class FunctionDevelop {
    public static void main(String... args){
        int[] progresses={93,30,55};
        int[] speeds={1,30,5};
        solution(progresses,speeds);
    }

    public static Integer[] solution(int[] progresses,int[] speeds){
        int[] rem=new int[progresses.length];
        ArrayList<Integer> answers=new ArrayList<>();

        for(int i=0; i<progresses.length; i++){
            int r= (100 - progresses[i]) % speeds[i] == 0 ? (100 - progresses[i]) / speeds[i] : (100 - progresses[i]) / speeds[i] + 1;
            rem[i]= r;
        }

        int temp=rem[0];
        int count=1;
        for(int i=1; i<rem.length; i++){
            if(temp >= rem[i]){
                count++;
                continue;
            }else{
                answers.add(count);
                temp=rem[i];
                count=1;
            }
        }
        answers.add(count);

        return answers.stream().toArray(Integer[]::new);
    }
}











// progresses	speeds	return
// [93, 30, 55]	[1, 30, 5]	[2, 1]
// [95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]	[1, 3, 2]