package com.hjk.shopboot.utils.javautils;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class pArrayUtils {
    
    public static final int INDEX_NOT_FOUND=-1;

    public static boolean isEmpty(int[] array){
        return array==null || array.length==0;
    }

    public static<T> boolean isEmpty(T[] array){
        return array==null || array.length==0;
    }

    public static<T> boolean isNotEmpty(T[] array){
        return false==isEmpty(array);
    }

    public static byte[] resize(byte[] bytes, int newSize){
        if(newSize<0){
            return bytes;
        }
        final byte[] newArray=new byte[newSize];
        if(newSize>0 ){
            System.arraycopy(bytes, 0, newArray, 0, Math.min(bytes.length,newSize));
        }
        return newArray;
    }

    public static int[] addAll(int[]... arrays){
        if(arrays.length==1){
            return arrays[0];
        }

        int length=0;
        for(int[] array: arrays){
            if(array!=null){
                length+=array.length;
            }
        }

        final int[] result=new int[length];
        length=0;
        for(int[] array:arrays){
            if(null!=array){
                System.arraycopy(array, 0, result, length, array.length);
                length+=array.length;
            }
        }
        return result;
    }

    public static int[] range(int includeStart,int excludeEnd,int step){
        if(includeStart > excludeEnd){
            int temp=includeStart;
            includeStart=excludeEnd;
            excludeEnd=temp;
        }

        if(step<=0){
            step=1;
        }

        int deviation=excludeEnd-includeStart;
        int length=deviation/step;
        
        if(deviation % step !=0){
            length+=1;
        }
        int[] range=new int[length];
        for(int i=0; i<length; i++){
            range[i]=includeStart;
            includeStart+=step;
        }
        return range;
    }

    public static byte[][] split(byte[] array, int len) {
		int amount = array.length / len;
		final int remainder = array.length % len;
		if (remainder != 0) {
			++amount;
		}
		final byte[][] arrays = new byte[amount][];
		byte[] arr;
		for (int i = 0; i < amount; i++) {
			if (i == amount - 1 && remainder != 0) {
				// 有剩余，按照实际长度创建
				arr = new byte[remainder];
				System.arraycopy(array, i * len, arr, 0, remainder);
			} else {
				arr = new byte[len];
				System.arraycopy(array, i * len, arr, 0, len);
			}
			arrays[i] = arr;
		}
		return arrays;
	}

    public static int indexOf(long[] array,long value){
        if(null!=array){
            for(int i=0; i<array.length; i++){
                if(value==array[i]){
                    return i;
                }
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static int indexOf(int[] array,int value){
        if(null!=array){
            for(int i=0; i<array.length; i++){
                if(value==array[i]){
                    return i;
                }
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static int lastIndexOf(long[] array,long value){
        if(null!=array){
            for(int i=array.length-1; i>=0; i--){
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static boolean contains(long[] array,long value){
        return indexOf(array,value) > INDEX_NOT_FOUND;
    }

    public Integer[] wrap(int[] values){
        if(null==values){
            return null;
        }

        final int length=values.length;
        if(0==length){
            return new Integer[0];
        }

        final Integer[] array=new Integer[length];
        for(int i=0; i<length; i++){
            array[i]=values[i];
        }
        return array;
    }

    public static int[] sub(int[] array, int start,int end){
        int length=Array.getLength(array);
        if(start< 0){
            start+=length;
        }
        if(end < 0){
            end+=length;
        }
        if(start==length){
            return new int[0];
        }

        if(start>end){
            int temp=start;
            start=end;
            end=temp;
        }

        if(end>length){
            if(start>=length){
                return new int[0];
            }
            end =length;
        }
        return Arrays.copyOfRange(array, start, end);
    }

    public static int[] remove(int[] array, int index) throws IllegalArgumentException{
        return (int[]) remove((Object) array,index);
    }

    public static int[] removeEle(int[] array,int element) throws IllegalAccessException{
        return remove(array,indexOf(array,element));
    }

    public static Object remove(Object array,int index) throws IllegalArgumentException{
        if(null==array){
            return null;
        }
        int length=Array.getLength(array);
        if(index < 0 || index>=length){
            return array;
        }
        
        final Object result=Array.newInstance(array.getClass().getComponentType(), length-1);
        System.arraycopy(array, 0, result, 0, index); //인덱스 전까지
        if(index < length-1){
            System.arraycopy(array, index+1, result, index, length-index-1); //인덱스 후부터
        }
        return result;
    }

    public static int[] reverse(int[] array,int startIndexInclusive, final int endIndexExclusive){
        if(isEmpty(array)){
            return array;     
        }
        int i=Math.max(startIndexInclusive,0);
        int j=Math.min(endIndexExclusive,array.length)-1;
        while(i < j){
            swap(array,i,j);
            i++;
            j--;
        }
        return array;
    }

    public static int max(int[] numberArray){
        if (isEmpty(numberArray)) {
			throw new IllegalArgumentException("Number array must not empty !");
		}
        int max=numberArray[0];
        for(int i=1; i<numberArray.length; i++){
            if(max < numberArray[i]){
                max=numberArray[i];
            }
        }
        return max;
    }

    public static int min(int[] numberArray){
        if (isEmpty(numberArray)) {
			throw new IllegalArgumentException("Number array must not empty !");
		}

        int min=numberArray[0];
        for(int i=1; i<numberArray.length; i++){
            if(min > numberArray[i]){
                min=numberArray[i];
            }
        }

        return min;
    }

    public static int[] swap(int[] array,int index1,int index2){
        if(isEmpty(array)){
            return null;
        }

        int temp=array[index1];
        array[index1]=array[index2];
        array[index2]=temp;

        return array;
    }

    public static boolean isSortedASC(byte[] array){
        if(array==null){
            return false;
        }

        for(int i=0; i<array.length-1; i++){
            if(array[i] > array[i+1]){
                return false;
            }
        }

        return true;
    }

    public static boolean isSortedDESC(byte[] array) {
		if (array == null) {
			return false;
		}

		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] < array[i + 1]) {
				return false;
			}
		}

		return true;
	}
  


}
