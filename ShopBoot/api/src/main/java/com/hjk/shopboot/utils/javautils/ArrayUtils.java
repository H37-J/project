package com.hjk.shopboot.utils.javautils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

import com.hjk.shopboot.utils.javautils.functionalInterface.Editor;
import com.hjk.shopboot.utils.javautils.functionalInterface.Filter;

public class ArrayUtils extends pArrayUtils {

    public static void main(String[] args){
        Integer[] a = {};
        System.out.println(getComponentType(a));
    }

    public static<T> boolean isEmpty(T[] array){
        if(array!=null){
            if(isArray(array)){
                return 0==Array.getLength(array);
            }
            return false;
        }
        return true;
    }
    
    public static boolean isEmpty(Object array){
        if(array!=null){
            if(isArray(array)){
                return 0==Array.getLength(array);
            }
            return false;
        }
        return true;
    }

    public static <T> boolean isNotEmpty(T[] array){
        return (array!=null && array.length!=0);
    }

    public static boolean isNotEmpty(Object array) {
        return false == isEmpty(array);
    }


    @SuppressWarnings("unchecked")
    public static<T> boolean hasNull(T... array){
        if(isNotEmpty(array)){
            for(T element: array){
                if(null==element){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isArray(Object obj){
        return null!=obj && obj.getClass().isArray();
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] newArray(Class<?> componentType,int newSize){
        return (T[]) Array.newInstance(componentType, newSize);
    }

    public static Object[] newArray(int newSize){
        return new Object[newSize];
    }

    public static Class<?> getComponentType(Object array){
        return null== array ? null : array.getClass().getComponentType();
    }

    public static Class<?> getArrayType(Class<?> componentType){
        return Array.newInstance(componentType,0).getClass();
    }

    public static Object[] cast(Class<?> type, Object arrayObj) throws NullPointerException, IllegalArgumentException {
		if (null == arrayObj) {
			throw new NullPointerException("Argument [arrayObj] is null !");
		}
		if (!arrayObj.getClass().isArray()) {
			throw new IllegalArgumentException("Argument [arrayObj] is not array !");
		}
		if (null == type) {
			return (Object[]) arrayObj;
		}

		final Class<?> componentType = type.isArray() ? type.getComponentType() : type;
		final Object[] array = (Object[]) arrayObj;
		final Object[] result = ArrayUtils.newArray(componentType, array.length);
		System.arraycopy(array, 0, result, 0, array.length);
		return result;
	}

	public static int length(Object array) throws IllegalArgumentException{
        if(array==null){
            return 0;
        }
        return Array.getLength(array);
    }

    @SafeVarargs
    public static <T> T[] append(T[] buffer, T... newElements) {
        if (isEmpty(buffer)) {
            return newElements;
        }
        return insert(buffer, buffer.length, newElements);
    }

    @SafeVarargs
    public static <T> Object append(Object array,T... newElements){
        if(isEmpty(array)){
            return newElements;
        }
        return insert(array,length(array),newElements);
    }

    public static <T> T[] setOrAppend(T[] buffer, int index, T value) {
        if (index < buffer.length) {
            Array.set(buffer, index, value);
            return buffer;
        } else {
            return append(buffer, value);
        }
    }

    public static Object setOrAppend(Object array, int index, Object value) {
        if (index < length(array)) {
            Array.set(array, index, value);
            return array;
        } else {
            return append(array, value);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] insert(T[] buffer, int index, T... newElements) {
        return (T[]) insert((Object) buffer, index, newElements);
    }

    @SuppressWarnings({"unchecked", "SuspiciousSystemArraycopy"})
    public static <T> Object insert(Object array,int index,T... newElements){
        if(isEmpty(newElements)){
            return array;
        }
        if(isEmpty(array)){
            return newElements;
        }

        final int len=length(array);
        if(index < 0){
            index=(index % len) + len;
        }

        final T[] result = newArray(array.getClass().getComponentType(), Math.max(len, index) + newElements.length);
        System.arraycopy(array, 0, result, 0, Math.min(len, index));
        System.arraycopy(newElements, 0, result, index, newElements.length);
        if (index < len) {
            System.arraycopy(array, index, result, index + newElements.length, len - index);
        }
        return result;
    }

    public static <T> T[] resize(T[] data,int newSize,Class<?> componentType){
        if(newSize<0){
            return data;
        }

        final T[] newArray=newArray(componentType,newSize);
        if(newSize >0 && isNotEmpty(data)){
            System.arraycopy(data,0,newArray,0,Math.min(data.length,newSize));
        }
        return newArray;
    }

    public static Object resize(Object array, int newSize) {
        if (newSize < 0) {
            return array;
        }
        if (null == array) {
            return null;
        }
        final int length = length(array);
        final Object newArray = Array.newInstance(array.getClass().getComponentType(), newSize);
        if (newSize > 0 && isNotEmpty(array)) {
            //noinspection SuspiciousSystemArraycopy
            System.arraycopy(array, 0, newArray, 0, Math.min(length, newSize));
        }
        return newArray;
    }

    @SafeVarargs
    public static <T> T[] addAll(T[]... arrays){
        if(arrays.length==1){
            return arrays[0];
        }
        int length=0;

        for(T[] array : arrays){
            if(array!=null){
                length+=array.length;
            }
        }

        T[] result=newArray(arrays.getClass().getComponentType().getComponentType(),length);

        length=0;

        for(T[] array:arrays){
            if(null!= array){
                System.arraycopy(array,0,result,length,array.length);
                length+= array.length;
            }
        }
        return result;
    }

    public static <T> T[] clone(T[] array){
        if (array == null) {
            return null;
        }
        return array.clone();
    }

    @SuppressWarnings("unchecked")
    public static <T> T clone(final T obj) {
        if (null == obj) {
            return null;
        }
        if (isArray(obj)) {
            final Object result;
            final Class<?> componentType = obj.getClass().getComponentType();
            if (componentType.isPrimitive()) {// 原始类型
                int length = Array.getLength(obj);
                result = Array.newInstance(componentType, length);
                while (length-- > 0) {
                    Array.set(result, length, Array.get(obj, length));
                }
            } else {
                result = ((Object[]) obj).clone();
            }
            return (T) result;
        }
        return null;
    }

    public static <T> T[] edit(T[] array, Editor<T> editor){
        if (editor == null) {
            return array;
        }

        final ArrayList<T> list=new ArrayList<>(array.length);
        T modified;
        for(T t:array){
            modified=editor.edit(t);
            if(modified!=null){
                list.add(modified);
            }
        }
        final T[] result=newArray(array.getClass().getComponentType(),list.size());
        return list.toArray(result);
    }

    public static <T> T[] filter(T[] array, Filter<T> filter){
        if(array==null || filter==null){
            return array;
        }
        return edit(array, t-> filter.accept(t) ? t : null);
    }

    public static <T> T[] removeNull(T[] array) {
        return edit(array, t -> {

            return t;
        });
    }

    public static <T extends CharSequence> T[] removeEmpty(T[] array) {
        return filter(array, StrUtils::isNotEmpty);
    }

    public static <T> T[]
    reverse(T[] array, final int startIndexInclusive, final int endIndexExclusive) {
        if (isEmpty(array)) {
            return array;
        }
        int i = Math.max(startIndexInclusive, 0);
        int j = Math.min(array.length, endIndexExclusive) - 1;
        T tmp;
        while (j > i) {
            tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
            j--;
            i++;
        }
        return array;
    }

    public static<T> T[] reverse(T[] array){
        return reverse(array,0,array.length);
    }

    public static char[] reverse(char[] array) {
        return reverse(array, 0, array.length);
    }

    public static  char[]
    reverse(char[] array, final int startIndexInclusive, final int endIndexExclusive) {
        if (isEmpty(array)) {
            return array;
        }
        int i = Math.max(startIndexInclusive, 0);
        int j = Math.min(array.length, endIndexExclusive) - 1;
        char tmp;
        while (j > i) {
            tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
            j--;
            i++;
        }
        return array;
    }
}
