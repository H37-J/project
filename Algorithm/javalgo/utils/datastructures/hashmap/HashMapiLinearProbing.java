package datastructures.hashmap;

import java.util.Arrays;

public class HashMapiLinearProbing {
    private int hsize;
    private Integer[] buckets;
    private Integer AVAILABLE;
    private int size;

    public HashMapiLinearProbing(int hsize) {
        this.buckets = new Integer[hsize];
        this.size = hsize;
        this.AVAILABLE = Integer.MIN_VALUE;
        this.size = 0;
    }

    public int hasing(int key) {
        int hash = key % hsize;
        if (hash < 0) {
            hash += hsize;
        }
        return hash;
    }

    public void insertHash(int key) {
        Integer wrappedInt = key;
        int hash = hasing(key);

        if(isFull()){
            System.out.println("Hash table is full");
            return;
        }

        for(int i=0; i < hsize; i++){
            if(buckets[hash]==null || buckets[hash]==AVAILABLE){
                buckets[hash]=wrappedInt;
                size++;
                return;
            }

            if(hash + 1 < hsize){
                hash++;
            }else{
                hash=0;
            }
            
        }
    }

    public void deleteHash(int key){
        Integer wrappedInt=key;
        int hash=hasing(key);

        if(isEmpty()){
            System.out.println("Table is empty");
            return;
        }

        for(int i=0; i<hsize; i++){
            if(buckets[hash]!=null && buckets[hash].equals(wrappedInt)){
                buckets[hash]=AVAILABLE;
                size--;
                return;
            }

            if(hash + 1 <hsize){
                hash++;
            }else{
                hash=0;
            }

            System.out.println("Key" +key +"not found");
        }
    }

    public void displayHashtable(){
        for(int i=0; i < hsize; i++){
            if(buckets[i]==null || buckets[i]==AVAILABLE){
                System.out.println("Bucket"+i+"Empty");
            }else{
                System.out.println("Bucket " + i + ": " + buckets[i].toString());
            }
        }
    }

    public void lengthenTable(){
        buckets=Arrays.copyOf(buckets, hsize * 2);
        hsize*=2;
        System.out.println("Table size is now:" + hsize);
    }

    public void checkLoadFactor() {
        double factor = (double) size / hsize;
        if (factor > .7) {
            System.out.println("Load factor is " + factor + ",  lengthening table");
            lengthenTable();
        } else {
            System.out.println("Load factor is " + factor);
        }
    }

    public boolean isFull() {
        boolean response = true;
        for (int i = 0; i < hsize; i++) {
            if (buckets[i] == null || buckets[i] == AVAILABLE) {
                response = false;
                break;
            }
        }
        return response;
    }

    public boolean isEmpty() {
        boolean response = true;
        for (int i = 0; i < hsize; i++) {
            if (buckets[i] != null) {
                response = false;
                break;
            }
        }
        return response;
    }
}
