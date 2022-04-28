
import java.util.LinkedList;

import java.util.*;
public class TruckQueue {
    
//     경과 시간 	다리를 지난 트럭 	다리를 건너는 트럭 	대기 트럭
//         0 	      [] 	     [] 	   [7,4,5,6]
//         1~2 	   [] 	         [7] 	[4,5,6]
//         3 	   [7] 	         [4] 	[5,6]
//         4 	   [7] 	           [4,5] 	[6]
//         5 	   [7,4] 	     [5] 	[6]
//          6~7 	[7,4,5] 	 [6] 	[]
//         8 	  [7,4,5,6] 	 [] 	[]

// bridge_length 	weight 	truck_weights 	return
// 2 	10 	[7,4,5,6] 	8
// 100 	100 	[10] 	101
// 100 	100 	[10,10,10,10,10,10,10,10,10,10] 	110

    //프로그래머스 레벨2 다리를 지나가는 트럭
    public static void main(String[] args){
        int[] w={7,4,5,6};
        solution(2,10,w);
    }

    public static void solution(int bridge_length, int weight, int[] t) {
        Queue<Truck> q=new LinkedList<Truck>();
        Queue<Truck> wait=new LinkedList<Truck>();
        int cw=0;
        int time=0;
        Truck on=null;
        for(int w:t){
            wait.add(new Truck(w,0));
        }


        while(!q.isEmpty() || !wait.isEmpty()){
            if(weight>cw+wait.peek().getWeight()){
                on=wait.poll();
                q.add(on);
                cw+=on.getWeight();
                time++;
            }
            else{
                if(q.peek().getTime()>bridge_length) { 
                    cw-=q.peek().getWeight(); 
                    q.poll();  
                    on=wait.poll();
                    q.add(on);
                    cw+=on.getWeight();
                }
                time++;
            }
            q.stream().forEach(e->e.addTime());
            q.stream().forEach(e->System.out.print("time:"+e.getTime()+", weight:"+e.getWeight()));
            System.out.print(",count:"+time);
            System.out.println();
        }
        System.out.println(time);

    }

    public static class Truck{
        int time;
        int weight;

        public Truck(int weight,int time){
            this.weight=weight;
            this.time=time;
        }

        public void addTime(){
            this.time=this.time+1;
        }

        public void setTime(int time){
            this.time=time;
        }

        public void setWeight(int weight){
            this.weight=weight;
        }

        public int getTime(){
            return this.time;
        }
        
        public int getWeight(){
            return this.weight;
        }
    }

}
