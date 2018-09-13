package com.wlz.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 接口返回值封装对象
 *
 * @author wlz
 * @date 9/7/18 10:20
 */
@Data
@AllArgsConstructor
public class ResponseBean<T> {
    private String msg;

    private Integer code;

    private T data;
}
