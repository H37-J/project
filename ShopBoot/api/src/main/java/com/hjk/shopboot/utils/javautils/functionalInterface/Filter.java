package com.hjk.shopboot.utils.javautils.functionalInterface;

@FunctionalInterface
public interface Filter<T> {

    boolean accept(T t);
}
