import java.util.ArrayList;

public class Network {
    
    public static void main(String... args){
        int[][] computers={{1,1,0,0},{1,1,1,0},{0,1,1,1},{0,0,1,1}};
        int n=computers.length;
        int[][] connnected=new int[n][n];
        boolean[] visited=new boolean[computers.length];
        for(int i=0; i<n; i++){
            dfs(computers,visited,i,connnected);
        }
        print(connnected);
    }

    public static void dfs(int[][] computers,boolean[] visited,int start,int[][] connnected){
        for(int i=0; i<computers.length; i++){
            visited[start]=true;
            if(computers[start][i]==0 || visited[i]==true) continue;
            connnected[start][i]=1;
            connnected[i][start]=1;
            dfs(computers,visited,i,connnected);
        }
    }

    public static void print(int[][] connnected){
        for(int i=0; i<connnected.length; i++){
            for(int c : connnected[i]){
                System.out.print(c+",");
            }
            System.out.println("");
        }
    }
}


// n	computers	return
// 3	[[1, 1, 0], [1, 1, 0], [0, 0, 1]]	2
// 3	[[1, 1, 0], [1, 1, 1], [0, 1, 1]]	1