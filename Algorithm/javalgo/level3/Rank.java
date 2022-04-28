public class Rank {
    
    //풀지못함
    public static void main(String... args){
        int n=5;
        int[][] results={{4,3},{4,2},{3,2},{2,1},{2,5}};
        Graphs graphs=new Graphs(n);
        graphs.createGraphs(results);
        graphs.print();
    } 
    
    public static class Graphs{
        int nodes;
        int[][] graphs;
        boolean[] check;

        public Graphs(int nodes){
            graphs = new int[nodes][nodes];
            check = new boolean[nodes];
        }

        public void createGraphs(int[][] results){
            for(int i=0; i<results.length; i++){
                graphs[results[i][1]-1][results[i][0]-1]=1;
            }
        }

        public void print(){
            for(int i=0; i<graphs.length; i++){
                for(int j=0; j<graphs[0].length; j++){
                    System.out.print(graphs[i][j]+",");
                }
                System.out.println("");
            }
        }
        
    }
    
}

// n	results	return
// 5	[[4, 3], [4, 2], [3, 2], [1, 2], [2, 5]]	2
