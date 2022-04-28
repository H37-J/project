import java.util.ArrayList;

public class Skilltree {
    // skill skill_trees return
    // "CBD" ["BACDE", "CBADF", "AECB", "BDA"] 2

    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = { "BACDE", "CABDF", "AECB", "BDA" };
        solution(skill, skill_trees);
    }

    public static int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length;

        for(int i=0; i<skill_trees.length; i++){
            if(!getIndex(skill, skill_trees[i])) answer--;
        }


        return answer;
    }

    public static boolean getIndex(String skill,String str){
        ArrayList<Integer> index_list=new ArrayList<>();

        for(int i=0; i<skill.length(); i++){
            index_list.add(str.indexOf(String.valueOf(skill.charAt(i))));
        }

        index_list.stream().forEach(e->System.out.print(e+","));
        System.out.println("");

        int temp=index_list.get(index_list.size()-1);
        for(int i=index_list.size()-2; i >= 0; --i){
            if(temp!=-1 && temp < index_list.get(i)) return false; // 후스킬이 선행 스킬보다 앞에 있는경우
            if(temp >=0 && index_list.get(i)==-1) return false; //후 스킬이 있는데 선행 스킬이 없는 경우
            temp=index_list.get(i);
        }

        return true;
    }
}
