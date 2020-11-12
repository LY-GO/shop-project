package com.qfedu.discount.utils;

/**
 * lambda 表达式
 *
 * @param <S>
 * @param <T>
 */
@FunctionalInterface
public interface ColaBeanUtilsCallBack<S, T> {
    void callBack(S t, T s);
}