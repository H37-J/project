// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.List;
// import java.util.stream.Collectors;

// public class Graph {

//     public static void main(String... args) {
//         int[][] vertex = { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } };
//         int n=6;
//         Graphs graphs = new Graphs(n);
//         List<Integer> answers=new ArrayList<>();
//         graphs.createGrpah(vertex);
//         graphs.print();
//         for(int i=1; i<n; i++){
//             int distance=graphs.getDistance(0, i, 0,10000);
//             answers.add(distance);
//         }
//         Collections.sort(answers);
//         int max=answers.get(answers.size()-1);
//         answers=answers.stream().filter(e-> e== max).collect(Collectors.toList());
//         System.out.println(answers.size());
//     }

//     public static class Graphs {
//         public int nodes;
//         public int[][] graphs;
//         public boolean[] visited;

//         public Graphs(int nodes) {
//             this.nodes = nodes;
//             graphs = new int[nodes][nodes];
//             visited = new boolean[nodes];
//         }

//         public void createGrpah(int[][] vertex) {
//             for (int i = 0; i < vertex.length; i++) {
//                 graphs[vertex[i][0] - 1][vertex[i][1] - 1] = 1;
//                 graphs[vertex[i][1] - 1][vertex[i][0] - 1] = 1;
//             }
//         }

//         public int getDistance(int start, int find, int count,int min) {
//             if (start == find && min > count ){
//                 min=count;
//                 return count;
//             }
//             for (int i = 0; i < graphs.length; i++) {
//                 visited[start]=true;
//                 if (graphs[start][i] == 0 || visited[i] == true) continue;
//                 min=getDistance(i, find, count + 1, min);
//                 visited[i]=false;
//             }
//             return min;
//         }

//         public void print() {
//             for (int i = 0; i < this.graphs.length; i++) {
//                 for (int j = 0; j < this.graphs[0].length; j++) {
//                     System.out.print(graphs[i][j] + ",");
//                 }
//                 System.out.println("");
//             }
//         }

//         // public void printDistance(){
//         //     distances.stream().forEach(e->System.out.print(e+","));
//         // }


//         // public void clearDistance(){
//         //     distances.clear();
//         // }
//     }

// }

// // n vertex return
// // 6 [[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]] 3
