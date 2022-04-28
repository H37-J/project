import javax.swing.text.AbstractDocument.LeafElement;

public class MaxDDang {

    // land answer
    // [[1,2,3,5],[5,6,7,8],[4,3,2,1]] 16

    public static void main(String... args) {
        int[][] land = { { 1, 2, 3, 5 }, { 5, 6, 7, 8 }, { 4, 3, 2, 1 } };
        int answer=findMax(land,land.length,0,-1);
        System.out.println(answer);
    }

    public static int findMax(int[][] land,int size,int hang,int idx) {
        int answer=Integer.MIN_VALUE;
        if(hang >= size) return 0;
        for(int i=0; i<4; i++){
            if(idx!=i){
                answer=Math.max(findMax(land,size,hang+1,i)+land[hang][i],answer);
            }
        }

        return answer;
    }
}
