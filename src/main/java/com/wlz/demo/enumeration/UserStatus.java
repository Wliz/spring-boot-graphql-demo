package com.wlz.demo.enumeration;

/**
 * 用户状态
 *
 * @author wlz
 * @date 9/6/18 14:06
 */
public enum UserStatus implements BaseEnum {
    NORAMAL("正常", 1), // 正常
    LOCK("锁定", 2), // 锁定
    ERASE("删除", 0);// 删除

    private String msg;

    private Integer value;

    UserStatus(String msg, Integer value) {
        this.msg = msg;
        this.value = value;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    @Override
    public Integer getValue() {
        return value;
    }
}
