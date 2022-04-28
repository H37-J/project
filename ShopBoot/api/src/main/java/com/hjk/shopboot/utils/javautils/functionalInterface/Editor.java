package com.hjk.shopboot.utils.javautils.functionalInterface;

@FunctionalInterface
public interface Editor<T> {

    T edit(T t);
}
