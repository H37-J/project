package com.hjk.shopboot.utils.javautils;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.hjk.shopboot.utils.etc.ObjectUtils;

import org.springframework.lang.Nullable;

public abstract class CollectionUtils {

    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    public static boolean isEmpty(@Nullable Collection<?> collection){
        return (collection==null || collection.isEmpty());
    }

    public static boolean isEmpty(@Nullable Map<?,?> map){
        return (map==null || map.isEmpty());
    }

    public static <K,V> HashMap<K,V> newHashMap(int expectedSize){
        return new HashMap<>((int) (expectedSize/DEFAULT_LOAD_FACTOR),DEFAULT_LOAD_FACTOR);
    }

    public static <K, V> LinkedHashMap<K, V> newLinkedHashMap(int expectedSize) {
        return new LinkedHashMap<>((int) (expectedSize / DEFAULT_LOAD_FACTOR), DEFAULT_LOAD_FACTOR);
    }

    public static List<?> arrayToList(@Nullable Object source){
        return Arrays.asList(ObjectUtils.toObjectArray(source));
    }

    public static boolean contains(@Nullable Iterator<?> iterator,Object element){
        if(iterator!=null){
            while(iterator.hasNext()){
                Object candiate=iterator.next();
                if(ObjectUtils.nullSafeEquals(candiate,element)){
                    return true;
                }
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public static <E> E findFirstMatch(Collection<?> source, Collection<E> candidates) {
        if (isEmpty(source) || isEmpty(candidates)) {
            return null;
        }
        for (Object candidate : candidates) {
            if (source.contains(candidate)) {
                return (E) candidate;
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public static <T> T findValueOfType(Collection<?> collection, @Nullable Class<T> type) {
        if(isEmpty(collection)){
            return null;
        }
        T value=null;
        for(Object element:collection){
            if(type==null || type.isInstance(element)){
                if(value!=null){
                    return null;
                }
                value =(T) element;
            }
        }
        return value;
    }

    @Nullable
    public static <T> T firstElement(@Nullable List<T> list) {
        if (isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }

    @Nullable
    public static <T> T lastElement(@Nullable List<T> list){
        if(isEmpty(list)){
            return null;
        }
        return list.get(list.size()-1);
    }



}
