package com.wlz.demo.enumeration;

/**
 * @author wlz
 * @date 9/6/18 14:42
 */
public interface BaseEnum<T> {
    /**
     * 获取枚举信息
     * @return string
     */
    String getMsg();

    /**
     * 获取枚举值
     * @return T
     */
    T getValue();
}
