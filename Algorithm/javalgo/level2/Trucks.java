import java.util.Arrays;
import java.util.LinkedList;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class Trucks {
    
    public static void main(String... args){
        int[] truck_weight={7,4,5,6};
        solution(2,10,truck_weight);
    }

    public static int solution(int bridge_length, int weight, int[] truck_weight){
        int times=1;
        Queue<Integer> trucks=new LinkedList<>(Arrays.asList(Arrays.stream(truck_weight).boxed().toArray(Integer[]::new)));
        Queue<Truck> bridge=new LinkedList<>();


        while(!trucks.isEmpty() || !bridge.isEmpty()){
            int current_weight = bridge.stream().mapToInt(Truck::getWeight).sum();
         
            if (!trucks.isEmpty() && current_weight + trucks.peek() <= weight) {
                bridge.add(new Truck(0,trucks.poll()));
            }
            bridge.stream().forEach(e -> e.setTime(e.getTime()+1));
            if(bridge.peek().getTime()==bridge_length)  bridge.poll();
            times++;
        }

        return times;
    }

    public static class Truck{
        Integer time,weight;

        public Truck(int time,int weight){
            this.time=time;
            this.weight=weight;
        }

        public void setTime(Integer time){
            this.time=time;
        }

        public void setWeight(Integer weight){
            this.weight=weight;
        }

        public Integer getTime(){
            return time;
        }

        public Integer getWeight(){
            return weight;
        }
    }
}



// 경과 시간	다리를 지난 트럭	다리를 건너는 트럭	대기 트럭
// 0	[]	[]	[7,4,5,6]
// 1~2	[]	[7]	[4,5,6]
// 3	[7]	[4]	[5,6]
// 4	[7]	[4,5]	[6]
// 5	[7,4]	[5]	[6]
// 6~7	[7,4,5]	[6]	[]
// 8	[7,4,5,6]	[]	[]