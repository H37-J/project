package datastructures.queue;

import java.util.ArrayList;

public class GenericArrayListQueue<T> {
    ArrayList<T> _queue = new ArrayList<>();

    private boolean hasElement() {
        return !_queue.isEmpty();
    }

    public T peek(){
        T result = null;
        if(this.hasElement()){
            result = _queue.get(0);
        }
        return result;
    }


    public boolean add(T element){
        return _queue.add(element);
    }

    public T pull() {
        T result = null;
        if(this.hasElement()){
            result = _queue.remove(0);
        }
        return result;
    }

}
