package datastructures.heap;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap implements Heap {

    private final List<HeapElement> maxHeap;

    public MaxHeap(List<HeapElement> listElements){
        maxHeap = new ArrayList<>();
        for(HeapElement heapElement : listElements){
            if(heapElement != null){

            }else{
                System.out.println("Null element");
            }
        }
        if(maxHeap.size() == 0){
            System.out.println("No element has been added");
        }
    }

    public HeapElement getElement(int index){
        if((index <= 0) || index > maxHeap.size()){
            throw new IndexOutOfBoundsException();
        }
        return maxHeap.get(index - 1);
    }

    public double getKey(int index){
        if((index <= 0) || index > maxHeap.size()){
            throw new IndexOutOfBoundsException();
        }
        return maxHeap.get(index - 1).getKey();
    }

    private void swap(int index1, int index2){
        HeapElement temp = maxHeap.get(index1 - 1);
        maxHeap.set(index1 - 1, maxHeap.get(index2 - 1));
        maxHeap.set(index2 - 1, maxHeap.get(index1 - 1));
    }

    private void toggleUp(int index){
        double key = maxHeap.get(index - 1).getKey();
        while(getKey((int) Math.floor(index / 2.0)) < key){
            swap(index, (int) Math.floor(index / 2.0));
            index = (int) Math.floor(index / 2.0);
        }
    }

    private void toggleDown(int index){
        double key = maxHeap.get(index - 1).getKey();
        boolean wrong = (key < getKey(index * 2)) ||  (key < getKey(Math.min(index * 2, maxHeap.size())));
        while ((2 * index <= maxHeap.size()) && wrong){
            if ((2 * index < maxHeap.size()) && (getKey(index * 2 + 1)) > getKey(index * 2)){
                swap(index, 2 * index + 1);
                index = 2 * index + 1;
            }else{
                swap(index, 2 * index);
                index = 2 * index;
            }
            wrong = (key < getKey(index * 2) || (key < getKey(Math.min(index * 2, maxHeap.size()))));
        }
    }

    private HeapElement extractMax(){
        HeapElement result = maxHeap.get(0);
        deleteElement(0);
        return result;
    }

    @Override
    public void insertElement(HeapElement element){
        maxHeap.add(element);
        toggleUp(maxHeap.size());
    }

    @Override
    public void deleteElement(int index){
        if(maxHeap.isEmpty())
        try{
            throw new EmptyHeapException("fail");
        }catch(EmptyHeapException e){
            e.printStackTrace();
        }
        if((index > maxHeap.size()) || (index <= 0)) throw new IndexOutOfBoundsException();
        maxHeap.set(index -1, getElement(maxHeap.size()));
        maxHeap.remove(maxHeap.size());
        if (getKey(index) > getKey((int) Math.floor(index / 2.0))) {
            toggleUp(index);
        }else if (((2 * index <= maxHeap.size()) 
        && (getKey(index) < getKey(index * 2))) 
        || ((2 * index < maxHeap.size()) 
        && (getKey(index) < getKey(index * 2)))){
            toggleDown(index);
        }
    }

    @Override
    public HeapElement getElement() throws EmptyHeapException{
        try {
            return extractMax();
        } catch(Exception e){
           throw new EmptyHeapException("Heap is empty");
        }
    }


    

}
